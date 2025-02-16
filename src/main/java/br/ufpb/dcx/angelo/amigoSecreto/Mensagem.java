package br.ufpb.dcx.angelo.amigoSecreto;

public abstract class Mensagem {
    private String texto;
    private String emailRemetente;
    private boolean anonima;

    public Mensagem(String texto, String emailRemetente, boolean anonima){
        this.texto = texto;
        this.emailRemetente = emailRemetente;
        this.anonima = anonima;
    }

    public String getTexto(){
        return this.texto;
    }
    public void setTexto(String novoTexto){
        this.texto = novoTexto;
    }

    public abstract String getTextoCompletoAExibir();

    public String getEmailRemetente(){
        return this.emailRemetente;
    }
    public void setEmailRemetente(String novoEmailRemetente){
        this.emailRemetente = novoEmailRemetente;
    }

    public boolean ehAnonima(){
        return this.anonima;
    }

}
