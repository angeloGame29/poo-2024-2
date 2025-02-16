package br.ufpb.dcx.angelo.amigoSecreto;

import java.util.Scanner;

public class TestaSistemaAmigoGUI {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            SistemaAmigo sistema = new SistemaAmigo();

            // Passo b:
            System.out.print("Digite a quantidade de amigos na brincadeira: ");
            int quantidadeAmigos = Integer.parseInt(scanner.nextLine());

            // Passo c:
            for (int i = 0; i < quantidadeAmigos; i++) {
                System.out.println("Cadastro do amigo " + (i + 1) + ":");
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("E-mail: ");
                String email = scanner.nextLine();
                sistema.cadastraAmigo(nome, email);
            }

            // Passo d:
            System.out.println("Informe o resultado do sorteio dos amigos secretos:");
            for (int i = 0; i < quantidadeAmigos; i++) {
                System.out.print("E-mail do amigo que pegou: ");
                String emailAmigo = scanner.nextLine();
                System.out.print("E-mail do amigo sorteado: ");
                String emailSorteado = scanner.nextLine();
                try {
                    sistema.configuraAmigoSecretoDe(emailAmigo, emailSorteado);
                } catch (AmigoInexistenteException e) {
                    System.out.println(e.getMessage());
                }
            }

            // Passo e:
            System.out.println("Envio de mensagem:");
            System.out.print("E-mail do remetente: ");
            String emailRemetente = scanner.nextLine();
            System.out.print("Texto da mensagem: ");
            String mensagem = scanner.nextLine();
            System.out.print("A mensagem é anônima? (true/false): ");
            boolean anonima = Boolean.parseBoolean(scanner.nextLine());

            sistema.enviarMensagemParaTodos(mensagem, emailRemetente, anonima);
            System.out.println("Mensagem enviada com sucesso!");
            scanner.close();
        }
}
