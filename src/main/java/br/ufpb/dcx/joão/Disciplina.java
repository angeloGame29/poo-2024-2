package br.ufpb.dcx.joão;

public class Disciplina {
    private String nome;
    private Integer codigo;
    private list<Horario> horarios;
    private int matriculaProf;


    public String getNome() {
        return nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public list<Horario> getHorarios() {
        return horarios;
    }

    public int getMatriculaProf() {
        return matriculaProf;
    }
}
