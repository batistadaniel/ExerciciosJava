package Aula6;

import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String[] nomesClientes = new String[100];
        String[] tipoSala = new String[100];
        int[] quantidadeIngressos = new int[100];
        double[] valorPago = new double[100];
        String[] parceria = new String[100];

        int qtdVendas = 0;
        double totalArrecadado = 0;
        boolean continua = true;

        System.out.println("----- Sistema de Venda de Ingressos ----- ");

        while (continua && qtdVendas < 100) {

            System.out.print("Informe o nome do cliente: ");
            nomesClientes[qtdVendas] = teclado.nextLine();

            System.out.print("Informe o tipo de sala: \n1 - Convencional \n2 - VIP\n \n>>> ");
            int opcaoSala = teclado.nextInt();

            teclado.nextLine();

            if (opcaoSala == 1) {
                tipoSala[qtdVendas] = "Convencional";
            } else {
                tipoSala[qtdVendas] = "VIP";
            }

            System.out.print("Informe a quantidade de ingressos: ");
            quantidadeIngressos[qtdVendas] = teclado.nextInt();

            teclado.nextLine();

            double valorIngresso;

            if (opcaoSala == 1) {
                valorIngresso = 30;
            } else {
                valorIngresso = 50;
            }

            valorPago[qtdVendas] = valorIngresso * quantidadeIngressos[qtdVendas];

            System.out.print("Possui parceria? \n1 - Sim \n2 - Nao\n \n>>> ");
            int possuiParceria = teclado.nextInt();

            teclado.nextLine();

            if (possuiParceria == 1) {
                System.out.print("Informe o nome da empresa parceira: ");
                parceria[qtdVendas] = teclado.nextLine();

                if (parceria[qtdVendas].equalsIgnoreCase("SENAC")
                        || parceria[qtdVendas].equalsIgnoreCase("SESC")
                        || parceria[qtdVendas].equalsIgnoreCase("CNI")) {

                    valorPago[qtdVendas] = valorPago[qtdVendas] * 0.90;

                } else {
                    System.out.println("Empresa parceira informada nao e valida.");
                }
            }

            System.out.printf("Valor a pagar: R$ %.2f%n", valorPago[qtdVendas]);

            totalArrecadado = totalArrecadado + valorPago[qtdVendas];

            System.out.print("Deseja receber o comprovante? \n1 - Sim \n2 - Nao\n \n>>> ");
            int desejaComprovante = teclado.nextInt();

            teclado.nextLine();

            if (desejaComprovante == 1) {
                System.out.println("----- Comprovante -----");
                System.out.println("Nome do cliente: " + nomesClientes[qtdVendas]);
                System.out.println("Tipo de sala: " + tipoSala[qtdVendas]);
                System.out.println("Quantidade de ingressos: " + quantidadeIngressos[qtdVendas]);
                System.out.printf("Valor pago: R$ %.2f%n", valorPago[qtdVendas]);
                System.out.println("-----------------------");
            }

            qtdVendas++;

            System.out.print("Deseja registrar uma nova venda? \n1 - Sim \n2 - Nao\n \n>>> ");
            int opcao = teclado.nextInt();

            teclado.nextLine();

            if (opcao == 2) {
                continua = false;
            }
        }

        System.out.println("----- Sistema encerrado! -----");
        System.out.println("Quantidade de vendas: " + qtdVendas);
        System.out.printf("Valor total arrecadado: R$ %.2f%n", totalArrecadado);

        teclado.close();
    }
}
