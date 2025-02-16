package br.ufpb.dcx.angelo.amigoSecreto;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo() {
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();

    }
    public void cadastraAmigo(String nomeAmigo, String emailAmigo){
        Amigo novoAmigo = new Amigo(nomeAmigo,emailAmigo);
        amigos.add(novoAmigo);
    }

    public Amigo pesquisaAmigo(String emailAmigo){
        Amigo pessoa = null;
        for (Amigo a: amigos){
            if (a.getEmail().equalsIgnoreCase(emailAmigo)){
                pessoa = a;
            }
        }
        return pessoa;
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente,boolean ehAnonima){
        Mensagem novaMensagem = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        mensagens.add(novaMensagem);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente,String emailDestinatario,boolean ehAnonima) {
        Mensagem novaMensagem = new MensagemParaAlguem(texto, emailRemetente,emailDestinatario,ehAnonima);
        mensagens.add(novaMensagem);
    }

    public List<Mensagem> pesquisaMensagensAnonimas(){
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for (Mensagem m : this.mensagens){
            if(m.ehAnonima()){
                mensagensAnonimas.add(m);
            }
        }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens(){
        List<Mensagem> todasAsMsg = new ArrayList<>();
        for (Mensagem m : this.mensagens){
            todasAsMsg.add(m);
        }
        return todasAsMsg;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
            Amigo pessoa = null;
            for (Amigo a: amigos) {
                if (a.getEmail().equalsIgnoreCase(emailDaPessoa)) {
                    pessoa = a;
                    break;
                }
            }
            if (pessoa == null) {
                throw new AmigoInexistenteException("Não existe pessoa cadastrada com este e-mail: " + emailDaPessoa);
            }
            pessoa.setEmailAmigoSorteado(emailAmigoSorteado);
        }
    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo pessoa = null;
        for (Amigo a: amigos){
            if (a.getEmail().equalsIgnoreCase(emailDaPessoa)){
                pessoa = a;
                break;
            }
            if(pessoa == null){
                throw new AmigoInexistenteException("Não existe pessoa cadastrada com este e-mail: " + emailDaPessoa);
            }
            if (pessoa.getEmailAmigoSorteado()==null){
                throw new AmigoNaoSorteadoException("O amigo secreto de " + emailDaPessoa + " ainda não foi sorteado.");
            }

        }

        return pessoa.getEmailAmigoSorteado();
    }

}

