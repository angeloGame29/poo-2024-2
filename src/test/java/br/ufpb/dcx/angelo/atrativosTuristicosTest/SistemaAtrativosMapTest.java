package br.ufpb.dcx.angelo.atrativosTuristicosTest;

import br.ufpb.dcx.angelo.atrativosTuristicos.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SistemaAtrativosMapTest {

    @Test
    public void test() {
        SistemaAtrativosMap sistema = new SistemaAtrativosMap();
        String descricao = "Praia em João Pessoa com vários bares, restaurantes e hoteis";
        AtrativoTuristico atrativo1 = new AtrativoTuristico("Praia de Manaíra",
                descricao, TipoAtrativo.PRAIA, new ArrayList<>());
        atrativo1.adicionaSiteMaisInfo("https://paraondeir.blog/praia-de-manaira/");
        try {
            sistema.cadastraAtrativo(atrativo1);
            AtrativoTuristico atrativoAchado = sistema.pesquisaAtrativo("Praia de Manaíra");
            assertNotNull("atrativo não encontrado", atrativoAchado);
            assertEquals(descricao, atrativoAchado.getDescricao());
            int quantPraia = sistema.contaAtrativosDoTipo(TipoAtrativo.PRAIA);
            int quantMuseu = sistema.contaAtrativosDoTipo(TipoAtrativo.MUSEU);
            assertTrue(1 == quantPraia);
            assertTrue(0 == quantMuseu);
        } catch (AtrativoJaExisteException | AtrativoNaoExisteException e) {
            fail("Não deveria lançar exceções nestes casos");
        }
    }
}
