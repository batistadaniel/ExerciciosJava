package Aula5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String[] nomes = new String[30];
        String[] cpfs = new String[30];
        int[] poltronas = new int[30];
        System.out.println("----- Sistema de check-in");

        for (int i = 0; i < nomes.length; i++) {
            System.out.print("Informe o nome do passageiro " + (i + 1) + ": ");
            nomes[i] = teclado.nextLine();

            System.out.print("Informe o cpf do passageiro " + (i + 1) + ": ");
            cpfs[i] = teclado.nextLine();

            System.out.print("Informe a poltrona do passageiro " + (i + 1) + ": ");
            poltronas[i] = teclado.nextInt();

            teclado.nextLine();

            System.out.println("Check-in para o passageiro " + nomes[i] + " realizado com sucesso!");

            System.out.println("Deseja realizar um novo check-in? \n1 - Sim \n2 - Nao");
            int opcao = teclado.nextInt();

            if (opcao == 2){
                System.out.println("Sistema encerrado!");
                break;
            }
        }
    }
}
