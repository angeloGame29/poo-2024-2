package br.ufpb.dcx.angelo.amigoSecreto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap  {
    private Map<String , Mensagem> mensagensMap;
    private Map<String, Amigo> amigosMap;
    public SistemaAmigoMap(){
        this.mensagensMap = new HashMap<>();
        this.amigosMap = new HashMap<>();
    }
    public void cadastraAmigo(String nomeAmigo,String emailAmigo) throws AmigoJaExisteException {
        if(this.amigosMap.containsKey(emailAmigo)){
            throw new AmigoJaExisteException("Amigo já cadastrado: "+emailAmigo);
        }else {
            Amigo novoAmigo = new Amigo(nomeAmigo,emailAmigo);
            this.amigosMap.put(emailAmigo,novoAmigo);
        }
    }
    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
        if (!this.amigosMap.containsKey(emailAmigo)){
            throw new AmigoInexistenteException("Amigo não está cadastrado: "+ emailAmigo);
        }else {
            return this.amigosMap.get(emailAmigo);
        }
    }
    public void enviarMensagemParaTodos(String texto, String emailRemetente,boolean ehAnonima){
        Mensagem novaMensagem = new MensagemParaTodos(texto, emailRemetente,ehAnonima);
        this.mensagensMap.put(emailRemetente,novaMensagem);
    }
    public void enviarMensagemParaAlguem(String texto,String emailRemetente, String emaildestinatario, boolean ehAnonima) throws AmigoInexistenteException{
        if(!this.amigosMap.containsKey(emaildestinatario)){
            throw new AmigoInexistenteException("Amigo não está cadastrado: "+ emaildestinatario);
        }else{
            Mensagem novaMensagem = new MensagemParaAlguem(texto,emailRemetente,emaildestinatario,ehAnonima);
            this.mensagensMap.put(emailRemetente,novaMensagem);
        }

    }
    public List<Mensagem> pesquisaMensagensAnonimas(){
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for(Mensagem m: this.mensagensMap.values()){
            if(m.ehAnonima()){
                mensagensAnonimas.add(m);
            }
        }
        return mensagensAnonimas;
    }
    public List<Mensagem> pesquisaTodasAsMensagens(){
        List<Mensagem> todasAsMensagens = new ArrayList<>();
        for(Mensagem m: this.mensagensMap.values()){
            todasAsMensagens.add(m);
        }
        return todasAsMensagens;
    }
    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailDoAmigoSorteado) throws AmigoInexistenteException {
        if (!this.amigosMap.containsKey(emailDoAmigoSorteado)) {
            throw new AmigoInexistenteException("Não existe pessoa cadastrada com este e-mail: " + emailDoAmigoSorteado);
        }
        if (!this.amigosMap.containsKey(emailDoAmigoSorteado)) {
                throw new AmigoInexistenteException("Não existe pessoa cadastrada com este e-mail: " + emailDoAmigoSorteado);
        }
        Amigo pessoa = this.amigosMap.get(emailDaPessoa);
        pessoa.setEmailAmigoSorteado(emailDoAmigoSorteado);
    }
    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException{
        if (!this.amigosMap.containsKey(emailDaPessoa)) {
            throw new AmigoInexistenteException("Não existe pessoa cadastrada com este e-mail: " + emailDaPessoa);
        }

        Amigo pessoa = this.amigosMap.get(emailDaPessoa);
        if (pessoa.getEmailAmigoSorteado() == null) {
            throw new AmigoNaoSorteadoException("O amigo secreto de " + emailDaPessoa + " ainda não foi sorteado.");
        }
        return pessoa.getEmailAmigoSorteado();
    }
}
