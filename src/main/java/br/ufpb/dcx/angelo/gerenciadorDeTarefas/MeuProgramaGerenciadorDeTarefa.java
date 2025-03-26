package br.ufpb.dcx.angelo.gerenciadorDeTarefas;

public class MeuProgramaGerenciadorDeTarefa {


    public static void main(String [] args) throws TarefaJaExisteException {
        MeuSistemaGerenciaDeTempo sistema = new MeuSistemaGerenciaDeTempo();
        try {
            sistema.cadastrarTarefa("T001", "Estudar LP", CategoriaTarefa.ESTUDO, 120);
            sistema.cadastrarTarefa("T002", "Estudar LP", CategoriaTarefa.ESTUDO, 120);
        } catch (TarefaJaExisteException e) {
            throw new TarefaJaExisteException(e.getMessage());
        }
        System.out.println(sistema.pesquisarTarefasPorDescricao("Estudar LP").toString());
    }
}
