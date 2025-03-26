package br.ufpb.dcx.angelo.gerenciadorDeTarefas;

import java.util.Objects;

public class Tarefa {

    private String codigo;
    private String descricao;
    private CategoriaTarefa categoria;
    private int tempoTarefaEmMinutos;

    public Tarefa (String codigo, String descricao, CategoriaTarefa categoria, int tempoTarefaEmMinutos){
        this.codigo = codigo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.tempoTarefaEmMinutos = tempoTarefaEmMinutos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaTarefa getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaTarefa categoria) {
        this.categoria = categoria;
    }

    public int getTempoTarefaEmMinutos() {
        return tempoTarefaEmMinutos;
    }

    public void setTempoTarefaEmMinutos(int tempoTarefaEmMinutos) {
        this.tempoTarefaEmMinutos = tempoTarefaEmMinutos;
    }

    @Override
    public String toString() {
        return "Tarefa: \n" +
                "codigo:" + codigo + "\n" +
                "descricao: " + descricao + "\n" +
                "categoria: " + categoria + "\n" +
                "tempoTarefaEmMinutos: " + tempoTarefaEmMinutos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(codigo, tarefa.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }


}
