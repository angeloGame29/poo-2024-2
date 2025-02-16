package br.ufpb.dcx.angelo.lojaRoupa;

import java.util.List;

public class SistemaLojaRoupasPOO implements SistemaLojaRoupas {
    @Override
    public List<Roupa> pesquisaRoupasPorTamanho(Tamanho tamnhoRoupa) {
        return List.of();
    }

    @Override
    public List<Roupa> pesquisaRoupasComDescricaoComecandoCom(String prefixodescricao) {
        return List.of();
    }

    @Override
    public Tamanho consultaTamanhoDaRoupa(String codigoRoupa) throws RoupaInexistenteException {
        return null;
    }

    @Override
    public void cadastraRoupa(String codigoRoupa, String descricao, Tamanho tamanho, int quantidade) throws RoupaJaExisteExeception {

    }

    @Override
    public void alteraQuantidadeDeRoupaNoEstoque(String codigoRoupa, int novaQuantidade) throws RoupaInexistenteException {

    }

    @Override
    public Roupa pesquisaRoupa(String codigoRoupa) throws RoupaInexistenteException {
        return null;
    }
}
