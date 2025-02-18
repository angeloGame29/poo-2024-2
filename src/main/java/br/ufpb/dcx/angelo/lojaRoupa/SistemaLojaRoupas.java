package br.ufpb.dcx.angelo.lojaRoupa;

import java.util.List;

public interface SistemaLojaRoupas {
    /**
     * Pesquisador de roupas pelo tamanho:
     * @param tamanhoRoupa
     * @return uma lista de roupas com um tamanho especifico
     */
    public List<Roupa> pesquisaRoupasPorTamanho(Tamanho tamanhoRoupa);

    /**
     * Pesquisador de roupas pela sua descrição:
     * @param prefixodescricao
     * @return uma lista de roupa com uma descrição especifica
     */
    public List<Roupa> pesquisaRoupasComDescricaoComecandoCom(String prefixodescricao);

    /**
     * Consultador de tamanho de uma roupa:
     * @param codigoRoupa
     * @return retorna o tamanho de uma roupa
     * @throws RoupaInexistenteException
     */
    public Tamanho consultaTamanhoDaRoupa (String codigoRoupa) throws RoupaInexistenteException;

    /**
     * Cadastrador de roupas:
     * @param codigoRoupa
     * @param descricao
     * @param tamanho
     * @param quantidade
     * @throws RoupaJaExisteException
     */
    public void cadastraRoupa(String codigoRoupa, String descricao, Tamanho tamanho, int quantidade) throws RoupaJaExisteException;

    /**
     * Alterador de quantidade de roupas no estoque:
     * @param codigoRoupa
     * @param novaQuantidade
     * @throws RoupaInexistenteException
     */
    public void alteraQuantidadeDeRoupaNoEstoque(String codigoRoupa, int novaQuantidade) throws RoupaInexistenteException;

    /**
     * Pesquisa uma roupa:
     * @param codigoRoupa
     * @return uma roupa pelo seu codigo
     * @throws RoupaInexistenteException
     */
    public Roupa pesquisaRoupa (String codigoRoupa) throws RoupaInexistenteException;

}
