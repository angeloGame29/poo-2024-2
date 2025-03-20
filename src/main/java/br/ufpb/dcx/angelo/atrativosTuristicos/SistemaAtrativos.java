package br.ufpb.dcx.angelo.atrativosTuristicos;

import java.util.List;

public interface SistemaAtrativos {
    /**
     * Cadastra um atrativo turistico
     * @param atrativo O atrativo turistico a ser cadastrado.
     * @throws AtrativoJaExisteException Se caso já existir um atrativo semelhante no sistema.
     */
    void cadastraAtrativo(AtrativoTuristico atrativo) throws AtrativoJaExisteException;

    /**
     * Pesquisa por um Atrativo Turistico
     * @param nome O nome do atrativo.
     * @return O atrativo pesquisado.
     * @throws AtrativoNaoExisteException Caso não exista no sistema o atrativo.
     */
    AtrativoTuristico pesquisaAtrativo(String nome) throws AtrativoNaoExisteException;

    /**
     * Pesquisa todos os atrativos de um determinado tipo
     * @param tipo O tipo do atrativo a qual será pesquisado.
     * @return Os Atrativos do tipo que foi pesquisado.
     */
    List<AtrativoTuristico> pesquisaAtrativosDoTipo(TipoAtrativo tipo);

    /**
     * Pesquisa todos os sites a qual sejam do suposto atrativo
     * @param nomeAtrativo O nome do atrativo a qual será pesquisado.
     * @return Todos os sites relacionados ao nome do atrativo.
     * @throws AtrativoNaoExisteException Caso aquele atrativo não exista.
     */
    List<String> pesquisaSitesComMaisInformacoesSobreAtrativo (String nomeAtrativo) throws AtrativoNaoExisteException;

    /**
     * Conta quantos atrativos com o mesmo tipo há no sistema
     * @param tipo O tipo do atrativo a ser contado.
     * @return A quantidade de atrativos com aquele tipo.
     * @throws AtrativoNaoExisteException Caso não exista no sistema esse atrativo.
     */
    int contaAtrativosDoTipo(TipoAtrativo tipo) throws AtrativoNaoExisteException;

    /**
     * Verifica se o atrativo existe no sistema
     * @param nomeAtrativo Nome do atrativo a ser verificado.
     * @return (True) se o atrativo existir no sistema, (false) caso não existir.
     */
    boolean existeAtrativo(String nomeAtrativo);

}
