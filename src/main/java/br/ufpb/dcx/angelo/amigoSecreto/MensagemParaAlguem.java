package br.ufpb.dcx.angelo.amigoSecreto;

public class MensagemParaAlguem extends Mensagem{
    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonimo){
        super(texto, emailRemetente,anonimo);
        this.emailDestinatario = emailDestinatario;
    }
    public String getEmailDestinatario(){
        return this.emailDestinatario;
    }
    public void setEmailDestinatario(String novoEmailDestinatario){
        this.emailDestinatario = novoEmailDestinatario;
    }

    public String getTextoCompletoAExibir(){
        if(ehAnonima()){
        return "Mensagem  para "+getEmailDestinatario()+
                " Texto: "+getTexto();}
        else{
            return "Mensagem de:" + getEmailRemetente()+
                    " para " + getEmailDestinatario()+" Texto: "+ getTexto();
        }
    }
}
