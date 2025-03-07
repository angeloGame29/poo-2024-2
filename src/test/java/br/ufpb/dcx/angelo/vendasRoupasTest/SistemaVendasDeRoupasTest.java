package br.ufpb.dcx.angelo.vendasRoupasTest;

import br.ufpb.dcx.angelo.vendasRoupas.SistemaVendas;
import br.ufpb.dcx.angelo.vendasRoupas.SistemaVendasDeRoupas;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class SistemaVendasDeRoupasTest {
    @Test
    public void testaCadastro() throws Exception {
        SistemaVendas sistema = new SistemaVendasDeRoupas();
        sistema.cadastrarProduto("B001","Bermuda Preta Hering M");
        assertTrue(sistema.existeProduto("B001"));
    }

}
