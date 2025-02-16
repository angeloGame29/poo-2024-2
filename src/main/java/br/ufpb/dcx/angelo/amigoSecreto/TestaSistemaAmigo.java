package br.ufpb.dcx.angelo.amigoSecreto;

public class TestaSistemaAmigo {
    public static void main(String [] args) {
        SistemaAmigo sistema = new SistemaAmigo();
        sistema.cadastraAmigo("José","jose.a@dcx.ufpb.br");
        sistema.cadastraAmigo("Maria","maria.a@dcx.ufpb.br");
        try{
            sistema.configuraAmigoSecretoDe("jose.a@dcx.ufpb.br","maria.a@dcx.ufpb.br");
            sistema.configuraAmigoSecretoDe("maria.a@dcx.ufpb.br","jose.a@dcx.ufpb.br");
        } catch (AmigoInexistenteException e) {
            System.out.println("Erro ao configurar o amigo secreto: " + e.getMessage());
        }
    }

}
