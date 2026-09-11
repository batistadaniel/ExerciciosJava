package Aula5;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String[] nomes = new String[30];
        String[] cpfs = new String[30];
        int[] poltronas = new int[30];
        int qtdPassageiros = 0;
        boolean continua = true;

        System.out.println("----- Sistema de check-in");

        for (int i = 0; i < nomes.length; i++) {

            System.out.print("Informe o nome do passageiro " + (i + 1) + ": ");
            nomes[i] = teclado.nextLine();

            System.out.print("Informe o cpf do passageiro " + (i + 1) + ": ");
            cpfs[i] = teclado.nextLine();

            continua = true;

            while (continua) {
                System.out.print("Informe a poltrona do passageiro " + (i + 1) + ": ");
                poltronas[i] = teclado.nextInt();

                if (poltronas[i] <= 0 || poltronas[i] > 30) {
                    System.out.println("Poltrona deve ser um número entre 1 e 30");
                    continua = true;
                } else {
                    continua = false;
                }
            }

            teclado.nextLine();

            System.out.println("Check-in para o passageiro " + nomes[i] + " realizado com sucesso!");

            qtdPassageiros++;

            System.out.println("Deseja realizar um novo check-in? \n1 - Sim \n2 - Nao");
            int opcao = teclado.nextInt();

            teclado.nextLine();

            if (opcao == 2) {
                System.out.println("Sistema encerrado!");
                break;
            }
        }

        for (int i = 0; i < qtdPassageiros; i++) {
            System.out.println("Quantidade de passageiros: " + qtdPassageiros);
            System.out.println("Nome do passageiro " + (i + 1) + ": " + nomes[i]);
            System.out.println("CPF do passageiro " + (i + 1) + ": " + cpfs[i]);
            System.out.println("Poltrona do passageiro " + (i + 1) + ": " + poltronas[i]);
        }
    }
}