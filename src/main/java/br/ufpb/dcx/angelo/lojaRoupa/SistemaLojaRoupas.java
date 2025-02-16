package br.ufpb.dcx.angelo.lojaRoupa;

import java.util.List;

public interface SistemaLojaRoupas {
    public List<Roupa> pesquisaRoupasPorTamanho(Tamanho tamnhoRoupa);
    public List<Roupa> pesquisaRoupasComDescricaoComecandoCom(String prefixodescricao);
    public Tamanho consultaTamanhoDaRoupa (String codigoRoupa) throws RoupaInexistenteException;
    public void cadastraRoupa(String codigoRoupa, String descricao, Tamanho tamanho, int quantidade) throws RoupaJaExisteExeception;
    public void alteraQuantidadeDeRoupaNoEstoque(String codigoRoupa, int novaQuantidade) throws RoupaInexistenteException;
    public Roupa pesquisaRoupa (String codigoRoupa) throws RoupaInexistenteException;

}
