package br.ufpb.dcx.angelo.atrativosTuristicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AtrativoTuristico {
    private String nome;
    private String descricao;
    private TipoAtrativo tipo;
    private List<String> sitesParaMaisInfo;

    public AtrativoTuristico (String nome, String descricao,TipoAtrativo tipo, List<String> sitesParaMaisInfo){
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.sitesParaMaisInfo = sitesParaMaisInfo;
    }

    public AtrativoTuristico(){
        this("","",null, new ArrayList<>());
    }

    public boolean ehDoTipo(TipoAtrativo tipo){
        return this.tipo == tipo;
    }

    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String novaDescricao){
        this.descricao = novaDescricao;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String novoNome){
        this.nome = novoNome;
    }

    public TipoAtrativo getTipo() {
        return this.tipo;
    }
    public void setTipo(TipoAtrativo novoTipo){
        this.tipo = novoTipo;
    }

    public List<String> getSitesParaMaisInfo() {
        return this.sitesParaMaisInfo;
    }
    public void setSitesParaMaisInfo (List<String> novosSites){
        this.sitesParaMaisInfo = novosSites;
    }
    public void adicionaSiteMaisInfo(String site){
        this.sitesParaMaisInfo.add(site);
    }

    @Override
    public String toString() {
        return "Atrativo Turistico:\n" +
                "Nome: " + this.nome+ "\n"+
                "Descrição: "+this.descricao+"\n"+
                "tipo: "+this.tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtrativoTuristico that = (AtrativoTuristico) o;
        return Objects.equals(nome, that.nome) && tipo == that.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, tipo);
    }
}
