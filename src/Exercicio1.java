// Aluno: Daniel Batista
// ADS-MAT 3A

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("---------- Cadastro ----------");

        System.out.print("Digite seu nome: ");
        String nome = teclado.nextLine();
        System.out.print("Digite seu endereco: ");
        String endereco = teclado.nextLine();
        System.out.print("Digite seu telefone fixo: ");
        String telefoneFixo = teclado.nextLine();
        System.out.print("Digite seu telefone celular: ");
        String  telefoneCelular = teclado.nextLine();
        System.out.print("Digite seu email: ");
        String email = teclado.nextLine();

        if (nome.isEmpty() || endereco.isEmpty() || telefoneFixo.isEmpty() || telefoneCelular.isEmpty() || email.isEmpty()) {
            System.out.print("Algum campo esta vazio! Responda novamente.");
        } else if (telefoneFixo.equals(telefoneCelular)){
            System.out.print("Telefone fixo igual ao celular! Responda novamente.");
        } else if (!email.contains("@") || !email.contains(".com")){
            System.out.print("Email invalido! Responda novamente.");
        } else{
            System.out.print("Cadastro efetuado com sucesso!");
        };
    }
}