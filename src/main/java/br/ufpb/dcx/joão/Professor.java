package br.ufpb.dcx.joão;

public class Professor {
    private String nome;
    private Integer matricula;

    public Professor (String nome, int matricula){
        this.nome = nome;
        this.matricula = matricula;
    }
    public String getNome(){
        return this.nome;
    }

    public int getMatricula(){
        return this.matricula;
    }
}
