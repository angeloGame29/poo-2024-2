package br.ufpb.dcx.angelo.lojaRoupa;

import java.util.Objects;

public class Roupa {
    private String codigo;
    private String descricao;
    private Tamanho tamanho;
    private int quantidade;


    public Roupa (String codigo, String descricao, Tamanho tamanho, int quantidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
    }

    public String getCodigo (){
        return this.codigo;
    }
    public String getDescricao (){
        return this.descricao;
    }
    public int getQuantidade (){
        return this.quantidade;
    }
    public Tamanho getTamanho (){
        return this.tamanho;
    }

public void setQuantidade (int novaQuantidade){
        this.quantidade = novaQuantidade;
}

    @Override
    public String toString() {
        return "Roupa{" +
                "codigo='" + codigo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", tamanho=" + tamanho +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roupa roupa = (Roupa) o;
        return Objects.equals(codigo, roupa.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }
}
