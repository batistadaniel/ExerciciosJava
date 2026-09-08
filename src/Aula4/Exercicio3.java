package Aula4;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String nome;
        int idade;
        String tipoIngresso;
        boolean possuiDocumento = true;
        int opcaoIngreso;
        boolean continua = true;

        System.out.println("----- Sistema de entrada de participantes -----");

        while (continua) {
            System.out.print("Informe o nome: ");
            nome = teclado.nextLine();

            System.out.print("Informe a idade: ");
            idade = teclado.nextInt();

            System.out.println("Informe o tipo de ingresso: " +
                    "\n1 - Comum" +
                    "\n2 - Vip" +
                    "\n3 - Meia" +
                    "\nIngresso: ");
            opcaoIngreso = teclado.nextInt();
            if (opcaoIngreso == 1) {
                tipoIngresso = "Comum";
            } else if (opcaoIngreso == 2) {
                tipoIngresso = "Vip";
            } else
            nome = teclado.nextLine();
        }
    }
}
