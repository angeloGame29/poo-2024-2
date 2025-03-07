package br.ufpb.dcx.angelo.vendasRoupas;

import java.util.Collection;

public interface SistemaVendas {

    /**
     * Cadastra as vendas.
     * @param coddigoProduto código do produto que será vendido.
     * @param valorProduto o valor do produto que está sendo vendido.
     * @param mes o mês em que está acontecendo a venda.
     * @param ano o ano em que está acontecendo a venda.
     * @throws ProdutoNaoExisteException se não existir o produto;
     */
    void cadastrarVendas (String coddigoProduto, double valorProduto, Mes mes, int ano) throws ProdutoNaoExisteException;

    /**
     * cadastra os produtos.
     * @param codigo o codigo do produto.
     * @param descricao a descrição do produto.
     * @throws ProdutoJaExisteException se o produto já existir no sistema.
     */
    void cadastrarProduto (String codigo, String descricao) throws ProdutoJaExisteException;

    /**
     * pesquisa todas as vendas feitas no sistema.
     * @return uma coleção de todas as vendas realizadas.
     */
    Collection<Venda> pesquisarTodasAsVendas ();

    /**
     * Pesquisa todos os produtos cadastrados no sistema.
     * @return Uma coleção com todos os produtos que tem no sistema.
     */
    Collection<Produto> pesquisarTodosOsProdutos ();

    /**
     * Mostra o valor total das vendas feitas em um determinado mês.
     * @param mes o mês em que deseja saber o valor total de vendas.
     * @param ano o ano em que foi feito as vendas.
     * @return o valor total das vendas do mês escolhido.
     */
    double obterValorTotalVendasMes (Mes mes, int ano);

    /**
     * Verifica se há alguma venda de um produto específico.
     * @param codigoProduto o código do produto a ser pesquisado se foi feito a venda.
     * @return se existe retorna true se não false.
     */
    boolean existeVendaDoProduto (String codigoProduto);

    /**
     * Conta a quantidades de venda de um produto.
     * @param codigo o código produto que terá sua quantidade de vendas contadas.
     * @return a quantidade de vendas.
     */
    int contaVendasDoProduto (String codigo);

    /**
     * Verifica se existe um produto.
     * @param codigo o código do produto que irá ver se existe.
     * @return true se existir e false se não.
     */
    boolean existeProduto (String codigo);

    /**
     * Pesquisa a descrição do produto.
     * @param codigoProduto o código do produto que terá sua descrição pesquisada.
     * @return a descrição do produto.
     * @throws ProdutoNaoExisteException se o produto não existir.
     */
    String pesquisaDescricaoDoProduto (String codigoProduto) throws ProdutoNaoExisteException;

}
