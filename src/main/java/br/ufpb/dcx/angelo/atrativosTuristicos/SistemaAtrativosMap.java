package br.ufpb.dcx.angelo.atrativosTuristicos;

import java.util.ArrayList;
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
        if(this.atrativos.containsKey(atrativo.getNome())){
            throw new AtrativoJaExisteException("Esse atrativo já existe no sistema"+atrativo.getNome());
        }else {
            this.atrativos.put(atrativo.getNome(), atrativo);
        }
    }

    @Override
    public AtrativoTuristico pesquisaAtrativo(String nomeAtrativo) throws AtrativoNaoExisteException {
        AtrativoTuristico atrativoPesquisado = new AtrativoTuristico();
        if(!this.atrativos.containsKey(nomeAtrativo)){
            throw new AtrativoNaoExisteException("Esse atrativo não existe no sistema: "+nomeAtrativo);
        }else {
            for (AtrativoTuristico at: this.atrativos.values()){
                if (at.getNome().equalsIgnoreCase(nomeAtrativo)) {
                    atrativoPesquisado = at;
                }
            }
        }
        return atrativoPesquisado;
    }

    @Override
    public List<AtrativoTuristico> pesquisaAtrativosDoTipo(TipoAtrativo tipo) {
        List<AtrativoTuristico> atrativosEncontrados = new ArrayList<>();
        for(AtrativoTuristico at: this.atrativos.values()){
            if(at.getTipo().equals(tipo)){
                atrativosEncontrados.add(at);
            }
        }
        return atrativosEncontrados;
    }

    @Override
    public List<String> pesquisaSitesComMaisInformacoesSobreAtrativo(String nomeAtrativo) throws AtrativoNaoExisteException {
        if (!this.atrativos.containsKey(nomeAtrativo)) {
            throw new AtrativoNaoExisteException("Não existe no sistema esse atrativo: " + nomeAtrativo);
        }else {
            return this.atrativos.get(nomeAtrativo).getSitesParaMaisInfo();
        }
    }

    @Override
    public int contaAtrativosDoTipo(TipoAtrativo tipo) throws NullPointerException{
        int cont = 0;
        for (AtrativoTuristico at: this.atrativos.values()){
            if(at.getTipo().equals(tipo)){
                cont ++;
            }
        }
        return cont;
    }

    @Override
    public boolean existeAtrativo(String nomeAtrativo) {
        return this.atrativos.containsKey(nomeAtrativo);
    }
}
