package br.ufpb.dcx.angelo.vendasRoupasTest;

import br.ufpb.dcx.angelo.vendasRoupas.Mes;
import br.ufpb.dcx.angelo.vendasRoupas.SistemaVendas;
import br.ufpb.dcx.angelo.vendasRoupas.SistemaVendasDeRoupas;
import br.ufpb.dcx.angelo.vendasRoupas.Venda;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SistemaVendasDeRoupasTest {
    @Test
    public void testaCadastro() throws Exception {
        SistemaVendas sistema = new SistemaVendasDeRoupas();
        sistema.cadastrarProduto("B001","Bermuda Preta Hering M");
        assertTrue(sistema.existeProduto("B001"));
        //A)
        sistema.cadastrarVendas("B001",100, Mes.JANEIRO,2024);
        int valorTotal = sistema.contaVendasDoProduto("B001");
        assertTrue(valorTotal == 1);
//        5.A) É o código em que as classes ou funções possuem uma forte dependência entre eles.
//        B)Não pelo contrario se busca por um código mais flexível.
    }

    @Test
    public void testaPesquisaOSegundoSemestre() throws Exception{
        SistemaVendas sistema = new SistemaVendasDeRoupas();
        sistema.cadastrarProduto("015","casaco");
        sistema.cadastrarVendas("015",55,Mes.SETEMBRO,2024);
        Venda venda = new Venda("015",55,Mes.SETEMBRO,2024);
        assertEquals(venda.getCodigoProduto(), sistema.pesquisarVendasParaOSegundoSemestre().get(0).getCodigoProduto());
    }
}
