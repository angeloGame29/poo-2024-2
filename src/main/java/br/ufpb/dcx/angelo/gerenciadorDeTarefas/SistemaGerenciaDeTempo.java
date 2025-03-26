package br.ufpb.dcx.angelo.gerenciadorDeTarefas;

import java.util.Collection;

public interface SistemaGerenciaDeTempo {
     void cadastrarTarefa(String codigo, String descricao, CategoriaTarefa categoria, int tempoEmMinutos) throws TarefaJaExisteException;

     Collection<Tarefa> pesquisarTarefasDaCategoria(CategoriaTarefa categoriaTarefa);

     Collection<Tarefa> pesquisarTarefasQueDuraramMaisDe(int tempoEmMinutos);

     int calcularTempoTotalDeTarefasDaCategoria(CategoriaTarefa categoriaTarefa);

     int calcularTempoTotalDeTarefasComDescricao(String descricaoTarefa);

     Collection<Tarefa> pesquisarTarefasPorDescricao(String descricaoTarefa);

     void alterarTempoDeTarefa(String codigoTarefa, int novoTempo) throws TarefaNaoExisteException;
}
