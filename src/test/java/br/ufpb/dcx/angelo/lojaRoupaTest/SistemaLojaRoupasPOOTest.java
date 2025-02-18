package br.ufpb.dcx.angelo.lojaRoupaTest;

import br.ufpb.dcx.angelo.lojaRoupa.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SistemaLojaRoupasPOOTest {

    @Test
    public void testaCadastoDeRoupa(){
        try{
            SistemaLojaRoupasPOO sistema = new SistemaLojaRoupasPOO();
            sistema.cadastraRoupa("001","camisa polo Azul Masculina", Tamanho.M,10);
            Roupa r = sistema.pesquisaRoupa("001");
            assertEquals(10, r.getQuantidade());
            //TODO /IMPLENTAR O TEST
        }catch (RoupaJaExisteException | RoupaInexistenteException e){
            fail("Não deverua lançar exceção");
        }
    }
}
