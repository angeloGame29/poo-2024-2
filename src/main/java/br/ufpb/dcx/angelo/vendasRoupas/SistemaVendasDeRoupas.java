package br.ufpb.dcx.angelo.vendasRoupas;

import java.util.*;

public class SistemaVendasDeRoupas implements SistemaVendas {
    private List<Venda> vendas;
    private Map<String, Produto> produtosMap;

    public SistemaVendasDeRoupas (){
        this.vendas = new ArrayList<>();
        this.produtosMap = new HashMap<>();
    }

    @Override
    public void cadastrarVendas(String coddigoProduto, double valorProduto, Mes mes, int ano) throws ProdutoNaoExisteException {
        if(existeProduto(coddigoProduto)){
            Venda v = new Venda(coddigoProduto,valorProduto,mes,ano);
            this.vendas.add(v);
        }else{
            throw new ProdutoNaoExisteException("Não existe produto com "+"o código"+coddigoProduto);
        }
    }

    @Override
    public void cadastrarProduto(String codigo, String descricao) throws ProdutoJaExisteException {
        if(!this.produtosMap.containsKey(codigo)){
            Produto p = new Produto(codigo,descricao);
            this.produtosMap.put(codigo,p);
        }else{
            throw new ProdutoJaExisteException("Erro: produto com o código: "+codigo+" já existe");
        }
    }

    @Override
    public Collection<Venda> pesquisarTodasAsVendas() {
        Collection<Venda> vendasPesquisadas = new ArrayList<>();
        for (Venda v: this.vendas){
            vendasPesquisadas.add(v);
        }
        return vendasPesquisadas;
    }

    @Override
    public Collection<Produto> pesquisarTodosOsProdutos() {
        Collection<Produto> produtosPesquisados = new ArrayList<>();
        for (Produto p: this.produtosMap.values()){
            produtosPesquisados.add(p);
        }
        return produtosPesquisados;
    }

    @Override
    public double obterValorTotalVendasMes(Mes mes, int ano) {
        double totalVendasMes = 0;
        for (Venda v: this.vendas){
            if (v.getAno() == ano && v.getMes().equals(mes)){
                totalVendasMes += v.getValorProduto();
            }
        }
        return totalVendasMes;
    }

    @Override
    public boolean existeVendaDoProduto(String codigoProduto) {
        for(Venda v: this.vendas){
            if(v.getCodigoProduto().equals(codigoProduto)){
               return true;
            }
        }

        return false;
    }

    @Override
    public int contaVendasDoProduto(String codigo) {
        int contaVendas = 0;
        for(Venda v: this.vendas){
            if (v.getCodigoProduto().equals(codigo)) {
                contaVendas++;
            }
        }
        return contaVendas;
    }

    @Override
    public boolean existeProduto(String codigo) {
        return this.produtosMap.containsKey(codigo);

    }

    @Override
    public String pesquisaDescricaoDoProduto(String codigoProduto) throws ProdutoNaoExisteException {
        if(this.produtosMap.containsKey(codigoProduto)){
            return this.produtosMap.get(codigoProduto).getDescricao();
        }else{
            throw new ProdutoNaoExisteException ("Não existe nenhum produto com o código "+codigoProduto);
        }
    }
    public List<Venda> pesquisarVendasParaOSegundoSemestre(){
        Mes [] mes = {Mes.JULHO, Mes.AGOSTO, Mes.SETEMBRO, Mes.OUTUBRO,  Mes.NOVEMBRO, Mes.DEZEMBRO};
        List<Venda> vendasDoSegundoSemestre = new ArrayList<>();
        for (Venda v: this.vendas){
            for(Mes m: mes){
                if (v.getMes().equals(m)){
                    vendasDoSegundoSemestre.add(v);
                }
            }
        }
        return vendasDoSegundoSemestre;
    }
}
