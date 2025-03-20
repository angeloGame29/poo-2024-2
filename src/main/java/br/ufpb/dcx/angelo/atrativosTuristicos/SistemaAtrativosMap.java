package br.ufpb.dcx.angelo.atrativosTuristicos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAtrativosMap implements SistemaAtrativos {
    private Map<String, AtrativoTuristico> atrativos;

    public SistemaAtrativosMap(){
        this.atrativos = new HashMap<>();
    }

    @Override
    public void cadastraAtrativo(AtrativoTuristico atrativo) throws AtrativoJaExisteException {
        //TODO IMPLEMENTAR
    }

    @Override
    public AtrativoTuristico pesquisaAtrativo(String nome) throws AtrativoNaoExisteException {
        return null;
        //TODO IMPLEMENTAR

    }

    @Override
    public List<AtrativoTuristico> pesquisaAtrativosDoTipo(TipoAtrativo tipo) {
        return List.of();
        //TODO IMPLEMENTAR

    }

    @Override
    public List<String> pesquisaSitesComMaisInformacoesSobreAtrativo(String nomeAtrativo) throws AtrativoNaoExisteException {
        return List.of();
        //TODO IMPLEMENTAR

    }

    @Override
    public int contaAtrativosDoTipo(TipoAtrativo tipo) throws AtrativoNaoExisteException {
        return 0;
        //TODO IMPLEMENTAR

    }

    @Override
    public boolean existeAtrativo(String nomeAtrativo) {
        return false;
        //TODO IMPLEMENTAR

    }
}
