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
        //=======================[ ITERAÇÃO EXTERNA ]==============================
//        Collection<Tarefa> tarefasPesquisadas = new ArrayList<>();
//        for (Tarefa t : this.tarefas.values()){
//            if (t.getCategoria().equals(categoriaTarefa)){
//                tarefasPesquisadas.add(t);
//            }
//        }
//        return  tarefasPesquisadas;
        //=======================[ ITERAÇÃO INTERNA ]==============================
        return this.tarefas.values().stream()
                .filter(tarefa -> tarefa.getCategoria().equals(categoriaTarefa))
                .toList();
        //========================[ EXPLICANDO PASSO A PASSO ]===============================================
        //this.tarefas.values() -> Obtém todas as tarefas do mapa.
        //stream() -> Converte tudo em um Stream, assim permitindo manipular tudo de forma declarativa.
        //Filter() -> Filtra tudo deixando apenas as tarefas cuja categoria seja igual a do parâmetro.
        //tarefa -> Representa cada elemento do fluxo [cada objeto Tarefa].
    }

    @Override
    public Collection<Tarefa> pesquisarTarefasQueDuraramMaisDe(int tempoEmMinutos) {
//        Collection<Tarefa> tarefasPesquisadas = new ArrayList<>();
//        for(Tarefa t : this.tarefas.values()){
//            if (t.getTempoTarefaEmMinutos() > tempoEmMinutos){
//                tarefasPesquisadas.add(t);
//            }
//        }
//        return tarefasPesquisadas;
        return this.tarefas.values().stream()
                .filter(tarefa -> tarefa.getTempoTarefaEmMinutos() > tempoEmMinutos)
                .toList();
    }

    @Override
    public int calcularTempoTotalDeTarefasDaCategoria(CategoriaTarefa categoriaTarefa) {
//        int valorTotal = 0;
//        for (Tarefa t : this.tarefas.values()){
//            if (t.getCategoria().equals(categoriaTarefa)) {
//                valorTotal += t.getTempoTarefaEmMinutos();
//            }
//        }
//        return valorTotal;
        return this.tarefas.values().stream()
                .filter(t -> t.getCategoria().equals(categoriaTarefa))
                .mapToInt(Tarefa::getTempoTarefaEmMinutos)
                .reduce(0, (a,b) -> a + b);
    }

    @Override
    public int calcularTempoTotalDeTarefasComDescricao(String descricaoTarefa) {
//        int valorTotal = 0;
//        for (Tarefa t : this.tarefas.values()){
//            if (t.getDescricao().equals(descricaoTarefa)) {
//                valorTotal += t.getTempoTarefaEmMinutos();
//            }
//        }
//        return valorTotal;
        //1) com o reduce:
//      return this.tarefas.values().stream()
//      .filter(t -> t.getDescricao().equals(descricaoTarefa))
//      .mapToInt(Tarefa::getTempoTarefaEmMinutos)
//      .reduce(0, (a,b) -> a + b);

        //2) com o sum e sem usar o operador ::
        return this.tarefas.values().stream()
                .filter(t -> t.getDescricao().equals(descricaoTarefa))
                .mapToInt(t -> t.getTempoTarefaEmMinutos())
                .sum();
//
    }

    @Override
    public Collection<Tarefa> pesquisarTarefasPorDescricao(String descricaoTarefa) {
//        Collection<Tarefa> tarefasPesquisadas = new ArrayList<>();
//        for (Tarefa t : this.tarefas.values()){
//            if (t.getDescricao().equals(descricaoTarefa)){
//                tarefasPesquisadas.add(t);
//            }
//        }
//        return  tarefasPesquisadas;
        return this.tarefas.values().stream()
                .filter(tarefa -> tarefa.getDescricao().equals(descricaoTarefa))
                .toList();
    }

    @Override
    public void alterarTempoDeTarefa(String codigoTarefa, int novoTempo) throws TarefaNaoExisteException {

//        if (!this.tarefas.containsKey(codigoTarefa)){
//            throw new TarefaNaoExisteException("Tarefa com o código: ["+codigoTarefa+"] não existe");
//        }else {
//            this.tarefas.get(codigoTarefa).setTempoTarefaEmMinutos(novoTempo);
//        }
        this.tarefas.values().stream()
                .filter(t-> t.getCodigo().equals(codigoTarefa))
                .findFirst().orElseThrow(()-> new TarefaNaoExisteException("Tarefa com o código: ["+codigoTarefa+"] não existe"))
                .setTempoTarefaEmMinutos(novoTempo);
    }
}
