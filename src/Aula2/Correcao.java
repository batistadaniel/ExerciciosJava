package Aula2;

import java.util.Scanner;

public class Correcao {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Cadastro de usuarios");
        System.out.println("Informe o nome: ");
        String nome = teclado.nextLine();
        System.out.print("Informe o endereco: ");
        String endereco = teclado.nextLine();
        System.out.print("Informe o telefone fixo: ");
        String telefoneFixo = teclado.nextLine();
        System.out.print("Informe o celular: ");
        String  telefoneCelular = teclado.nextLine();
        System.out.print("Informe o email: ");
        String email = teclado.nextLine();

        if (nome.isEmpty() || endereco.isEmpty() || telefoneFixo.isEmpty() || telefoneCelular.isEmpty() || email.isEmpty()) {
            System.out.print("Preencha todas as informacoes!");
        } else if (telefoneFixo.equals(telefoneCelular)){
            System.out.print("Telefone fixo igual ao celular! Responda novamente.");
        } else if (!email.contains("@") || !email.contains(".com")){
            System.out.print("Email invalido! Responda novamente.");
        } else{
            System.out.print("Cadastro efetuado com sucesso!");
        };
    }
}
