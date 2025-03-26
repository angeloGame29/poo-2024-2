package br.ufpb.dcx.angelo.gerenciadorDeTarefasTest;

import br.ufpb.dcx.angelo.gerenciadorDeTarefas.CategoriaTarefa;
import br.ufpb.dcx.angelo.gerenciadorDeTarefas.MeuSistemaGerenciaDeTempo;
import br.ufpb.dcx.angelo.gerenciadorDeTarefas.TarefaJaExisteException;
import br.ufpb.dcx.angelo.gerenciadorDeTarefas.TarefaNaoExisteException;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class MeuSistemaGerenciaDeTempoFORTest {
    @Test
    public void testaCadastroAndPesquisa() {
        MeuSistemaGerenciaDeTempo sistema = new MeuSistemaGerenciaDeTempo();
        try {
            sistema.cadastrarTarefa("T001", "Estudar LP", CategoriaTarefa.ESTUDO, 120);
            assertEquals(120,sistema.calcularTempoTotalDeTarefasDaCategoria(CategoriaTarefa.ESTUDO));
            sistema.alterarTempoDeTarefa("T001", 20);
            //A)
            assertTrue(20 == sistema.calcularTempoTotalDeTarefasDaCategoria(CategoriaTarefa.ESTUDO));
            //B)
            sistema.cadastrarTarefa("T002","Estudar Calculo", CategoriaTarefa.ESTUDO,40);
            assertEquals(2, sistema.pesquisarTarefasDaCategoria(CategoriaTarefa.ESTUDO).size());
        } catch (TarefaJaExisteException | TarefaNaoExisteException e){
            fail("Não deveria lançar exceção aqui");
        }
    }
}
