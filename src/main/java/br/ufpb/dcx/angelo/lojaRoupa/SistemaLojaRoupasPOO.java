package br.ufpb.dcx.angelo.lojaRoupa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaLojaRoupasPOO implements SistemaLojaRoupas {
    private Map<String, Roupa> roupasMap;


    public SistemaLojaRoupasPOO() {
        this.roupasMap = new HashMap<>();
    }

    @Override
    public List<Roupa> pesquisaRoupasPorTamanho(Tamanho tamanhoRoupa) {
        List <Roupa> roupasPesquisadas = new ArrayList<>();
        for (Roupa r: roupasMap.values()){
            if(r.getTamanho().equals(tamanhoRoupa)){
                roupasPesquisadas.add(r);
            }

        }
        return roupasPesquisadas;
    }

    @Override
    public List<Roupa> pesquisaRoupasComDescricaoComecandoCom(String prefixodescricao) {
        return List.of();
        //TODO IMPLEMENTAR
    }

    @Override
    public Tamanho consultaTamanhoDaRoupa(String codigoRoupa) throws RoupaInexistenteException {
        return null;
        //TODO IMPLEMENTAR
    }

    @Override
    public void cadastraRoupa(String codigoRoupa, String descricao, Tamanho tamanho, int quantidade) throws RoupaJaExisteException {
        if (this.roupasMap.containsKey(codigoRoupa)) {
            throw new RoupaJaExisteException("Roupa já cadastrada: " + codigoRoupa);
        } else {
            Roupa roupa = new Roupa(codigoRoupa, descricao, tamanho, quantidade);
            this.roupasMap.put(codigoRoupa, roupa);
        }
    }

    @Override
    public void alteraQuantidadeDeRoupaNoEstoque(String codigoRoupa, int novaQuantidade) throws RoupaInexistenteException {
        //TODO IMPLEMENTAR
    }

    @Override
    public Roupa pesquisaRoupa(String codigoRoupa) throws RoupaInexistenteException {
        if (this.roupasMap.containsKey(codigoRoupa)) {
            throw new RoupaInexistenteException("Roupa não existe no sistema:" + codigoRoupa);
        } else {
            for(Roupa r: roupasMap.values()){
                if(r.getCodigo().equals(codigoRoupa)){
                  Roupa roupa = r;
                }
            }
        }
        return null;
        //TODO IMPLEMENTAR
    }
}
