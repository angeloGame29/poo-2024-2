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
    @Test
    public void testaPesquisarTarefasQueDuraramMaisDe(){
        MeuSistemaGerenciaDeTempo sistema = new MeuSistemaGerenciaDeTempo();
        try {
            sistema.cadastrarTarefa("P001", "Estudar LP", CategoriaTarefa.ESTUDO, 120);
            sistema.cadastrarTarefa("P002", "Estudar calculo", CategoriaTarefa.ESTUDO, 40);
            assertTrue(2 == sistema.pesquisarTarefasDaCategoria(CategoriaTarefa.ESTUDO).size());
            assertFalse(2 == sistema.pesquisarTarefasQueDuraramMaisDe(100).size());
        } catch (TarefaJaExisteException e) {
            fail("Não deveria lançar exceção");
        }
    }
    @Test
    public void testaCalcularTempoTotalDeTarefasDaCategoriaAndCalcularTempoTotalDeTarefasComDescricao(){
        MeuSistemaGerenciaDeTempo sistema = new MeuSistemaGerenciaDeTempo();
        try {
            sistema.cadastrarTarefa("C001", "Estudar LP", CategoriaTarefa.ESTUDO, 120);
            sistema.cadastrarTarefa("C002", "Estudar Html/Css", CategoriaTarefa.ESTUDO, 60);
            sistema.cadastrarTarefa("C003","Jogar YuGiOh", CategoriaTarefa.LAZER,30);
            sistema.cadastrarTarefa("C004","Jogar YuGiOh", CategoriaTarefa.LAZER,60);
            assertTrue(180 == sistema.calcularTempoTotalDeTarefasDaCategoria(CategoriaTarefa.ESTUDO));
            assertTrue(90 == sistema.calcularTempoTotalDeTarefasComDescricao("Jogar YuGiOh"));
        } catch (TarefaJaExisteException e) {
            fail("Não deveria lançar exceção");
        }


    }
}
