package br.ufpb.dcx.angelo.gerenciadorDeTarefas;

import br.ufpb.dcx.angelo.vendasRoupas.gui.MeuProgramaVendaGUI;

import java.util.*;

public class MeuSistemaGerenciaDeTempo implements SistemaGerenciaDeTempo {
    private Map<String, Tarefa> tarefas;

    public MeuSistemaGerenciaDeTempo(){
        this.tarefas = new HashMap<>();
    }

    @Override
    public void cadastrarTarefa(String codigo, String descricao, CategoriaTarefa categoria, int tempoEmMinutos) throws TarefaJaExisteException {
        if(this.tarefas.containsKey(codigo)){
            throw new TarefaJaExisteException("Tarefa com o código: ["+codigo+"] já existe.");
        }else {
            Tarefa t = new Tarefa(codigo, descricao, categoria, tempoEmMinutos);
            this.tarefas.put(codigo,t);
        }
    }

    @Override
    public Collection<Tarefa> pesquisarTarefasDaCategoria(CategoriaTarefa categoriaTarefa) {
        Collection<Tarefa> tarefasPesquisadas = new ArrayList<>();
        for (Tarefa t : this.tarefas.values()){
            if (t.getCategoria().equals(categoriaTarefa)){
                tarefasPesquisadas.add(t);
            }
        }
        return  tarefasPesquisadas;
    }

    @Override
    public Collection<Tarefa> pesquisarTarefasQueDuraramMaisDe(int tempoEmMinutos) {
        Collection<Tarefa> tarefasPesquisadas = new ArrayList<>();
        for(Tarefa t : this.tarefas.values()){
            if (t.getTempoTarefaEmMinutos() > tempoEmMinutos){
                tarefasPesquisadas.add(t);
            }
        }
        return tarefasPesquisadas;
    }

    @Override
    public int calcularTempoTotalDeTarefasDaCategoria(CategoriaTarefa categoriaTarefa) {
        int valorTotal = 0;
        for (Tarefa t : this.tarefas.values()){
            if (t.getCategoria().equals(categoriaTarefa)) {
                valorTotal += t.getTempoTarefaEmMinutos();
            }
        }
        return valorTotal;
    }

    @Override
    public int calcularTempoTotalDeTarefasComDescricao(String descricaoTarefa) {
        int valorTotal = 0;
        for (Tarefa t : this.tarefas.values()){
            if (t.getDescricao().equals(descricaoTarefa)) {
                valorTotal += t.getTempoTarefaEmMinutos();
            }
        }
        return valorTotal;
    }

    @Override
    public Collection<Tarefa> pesquisarTarefasPorDescricao(String descricaoTarefa) {
        Collection<Tarefa> tarefasPesquisadas = new ArrayList<>();
        for (Tarefa t : this.tarefas.values()){
            if (t.getDescricao().equals(descricaoTarefa)){
                tarefasPesquisadas.add(t);
            }
        }
        return  tarefasPesquisadas;
    }

    @Override
    public void alterarTempoDeTarefa(String codigoTarefa, int novoTempo) throws TarefaNaoExisteException {
        if (!this.tarefas.containsKey(codigoTarefa)){
            throw new TarefaNaoExisteException("Tarefa com o código: ["+codigoTarefa+"] não existe");
        }else {
            this.tarefas.get(codigoTarefa).setTempoTarefaEmMinutos(novoTempo);
        }
    }
}
