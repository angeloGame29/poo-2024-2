package br.ufpb.dcx.angelo.amigoSecretoTest;

import br.ufpb.dcx.angelo.amigoSecreto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SistemaAmigoMapTest {

    SistemaAmigoMap sistemaMap;

    @BeforeEach
    void setUp()  {
        this.sistemaMap = new SistemaAmigoMap();
    }

    @Test
    void testSistemaAmigo() {
        assertTrue(sistemaMap.pesquisaTodasAsMensagens().isEmpty());
        assertThrows(AmigoInexistenteException.class,
                ()-> sistemaMap.pesquisaAmigo("joao@teste.com"));
    }

    @Test
    void testPesquisaECadastraAmigo() {
        try {
            sistemaMap.pesquisaAmigo("joao@teste.com");
            fail("Deveria falhar pois não existe ainda");
        } catch (AmigoInexistenteException e) {
            //Ok
        }
        try {
            sistemaMap.cadastraAmigo("joao", "joao@teste.com");
            Amigo a = sistemaMap.pesquisaAmigo("joao@teste.com");

            assertEquals("joao", a.getNome());
            assertEquals("joao@teste.com", a.getEmail());
        } catch (AmigoJaExisteException | AmigoInexistenteException e) {
            fail("Não deveria lançar exceção");
        }


    }

    @Test
    void testEnviarMensagemParaTodos() {
        assertTrue(sistemaMap.pesquisaTodasAsMensagens().isEmpty());
        sistemaMap.enviarMensagemParaTodos("texto", "joao@dcx.ufpb.br", true);
        List<Mensagem> mensagensAchadas = sistemaMap.pesquisaTodasAsMensagens();
        assertTrue(mensagensAchadas.size()==1);
        assertTrue(mensagensAchadas.get(0).getEmailRemetente().equals("joao@dcx.ufpb.br"));
    }

    @Test
    void testEnviarMensagemParaAlguem() throws AmigoInexistenteException, AmigoJaExisteException {
        sistemaMap.cadastraAmigo("Stefan","Stefan@dcx.ufpb.br");
        assertTrue(sistemaMap.pesquisaTodasAsMensagens().isEmpty());
        sistemaMap.enviarMensagemParaAlguem("texto", "joao@dcx.ufpb.br", "Stefan@dcx.ufpb.br", true);
        List<Mensagem> mensagensAchadas = sistemaMap.pesquisaTodasAsMensagens();
        assertEquals(1, mensagensAchadas.size());
        assertTrue(mensagensAchadas.get(0) instanceof MensagemParaAlguem);
        assertTrue(mensagensAchadas.get(0).getTexto().equals("texto"));
    }

    @Test
    void testPesquisaMensagensAnonimas() throws AmigoInexistenteException, AmigoJaExisteException {
        sistemaMap.cadastraAmigo("Stefan","Stefan@dcx.ufpb.br");
        assertTrue(sistemaMap.pesquisaTodasAsMensagens().isEmpty());
        sistemaMap.enviarMensagemParaAlguem("texto 1", "joao@dcx.ufpb.br", "Stefan@dcx.ufpb.br", false);
        assertTrue(sistemaMap.pesquisaMensagensAnonimas().isEmpty());
        sistemaMap.enviarMensagemParaAlguem("texto 2", "joao@dcx.ufpb.br", "Stefan@dcx.ufpb.br", true);
        assertTrue(sistemaMap.pesquisaMensagensAnonimas().size()==1);
    }

    @Test
    void testPesquisaTodasAsMensagens() throws AmigoInexistenteException, AmigoJaExisteException {
        sistemaMap.cadastraAmigo("Stefan","Stefan@dcx.ufpb.br");
        assertTrue(sistemaMap.pesquisaTodasAsMensagens().isEmpty());
        sistemaMap.enviarMensagemParaAlguem("texto 1", "joao@dcx.ufpb.br", "Stefan@dcx.ufpb.br", false);
        assertTrue(sistemaMap.pesquisaTodasAsMensagens().size()==1);
        sistemaMap.enviarMensagemParaAlguem("texto 2", "joao@dcx.ufpb.br", "Stefan@dcx.ufpb.br", true);
        assertTrue(sistemaMap.pesquisaTodasAsMensagens().size()==2);
    }

    @Test
    void testPesquisaAmigoEConfiguraAmigoSecretoDe() {
        assertThrows(AmigoInexistenteException.class,
                ()-> sistemaMap.pesquisaAmigoSecretoDe("joao@dcx.ufpb.br"));
        try {
            sistemaMap.cadastraAmigo("joao", "joao@dcx.ufpb.br");
            sistemaMap.cadastraAmigo("luiza", "luiza@dcx.ufpb.br");
            sistemaMap.configuraAmigoSecretoDe("joao@dcx.ufpb.br", "luiza@dcx.ufpb.br");
            sistemaMap.configuraAmigoSecretoDe("luiza@dcx.ufpb.br", "joao@dcx.ufpb.br");
            assertEquals("luiza@dcx.ufpb.br", sistemaMap.pesquisaAmigoSecretoDe("joao@dcx.ufpb.br"));
            assertEquals("joao@dcx.ufpb.br", sistemaMap.pesquisaAmigoSecretoDe("luiza@dcx.ufpb.br"));
        } catch (AmigoInexistenteException | AmigoJaExisteException | AmigoNaoSorteadoException e) {
            fail("Não deveria lançar exceção");
        }
    }


}
