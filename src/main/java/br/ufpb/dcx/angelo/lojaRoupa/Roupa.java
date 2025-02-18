package br.ufpb.dcx.angelo.lojaRoupa;

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
}
