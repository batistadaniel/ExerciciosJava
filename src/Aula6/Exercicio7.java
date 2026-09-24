package Aula6;

import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String[] placasVeiculo = new String[100];
        String[] tipoVeiculoPessoa = new String[100];
        int[] horasEstacionado = new int[100];
        double[] valorPago = new double[100];
        String[] convenio = new String[100];

        int qtdVeiculos = 0;
        double totalArrecadado = 0;
        boolean continua = true;

        System.out.println("----- Sistema de Estacionamento ----- ");

        while (continua && qtdVeiculos < 100) {

            System.out.print("Informe a placa do veículo: ");
            placasVeiculo[qtdVeiculos] = teclado.nextLine();

            System.out.print("Informe o tipo do veículo: \n1 - Carro \n2 - Moto\n \n>>> ");
            int opcaoVeiculo = teclado.nextInt();

            teclado.nextLine();

            if (opcaoVeiculo == 1) {
                tipoVeiculoPessoa[qtdVeiculos] = "Carro";
            } else {
                tipoVeiculoPessoa[qtdVeiculos] = "Moto";
            }

            System.out.print("Informe a quantidade de horas estacionado: ");
            horasEstacionado[qtdVeiculos] = teclado.nextInt();

            teclado.nextLine();

            double valorHora;

            if (opcaoVeiculo == 1) {
                valorHora = 8;
            } else {
                valorHora = 5;
            }

            valorPago[qtdVeiculos] = valorHora * horasEstacionado[qtdVeiculos];

            System.out.print("Possui convenio? \n1 - Sim \n2 - Nao\n \n>>> ");
            int possuiConvenio = teclado.nextInt();

            teclado.nextLine();

            boolean convenioValido = false;

            if (possuiConvenio == 1) {
                System.out.print("Informe o nome da empresa conveniada: ");
                convenio[qtdVeiculos] = teclado.nextLine();

                if (convenio[qtdVeiculos].equalsIgnoreCase("SENAC")
                        || convenio[qtdVeiculos].equalsIgnoreCase("SESC")
                        || convenio[qtdVeiculos].equalsIgnoreCase("CNI")) {

                    convenioValido = true;
                    valorPago[qtdVeiculos] = valorPago[qtdVeiculos] * 0.90;

                } else {
                    System.out.println("Convenio informado nao e valido.");
                }
            }

            System.out.printf("Valor a pagar: R$ %.2f%n", valorPago[qtdVeiculos]);

            totalArrecadado = totalArrecadado + valorPago[qtdVeiculos];

            System.out.print("Deseja receber o recibo? \n1 - Sim \n2 - Nao\n \n>>> ");
            int desejaRecibo = teclado.nextInt();

            teclado.nextLine();

            if (desejaRecibo == 1) {
                System.out.println("----- Recibo -----");
                System.out.println("Placa: " + placasVeiculo[qtdVeiculos]);
                System.out.println("Tipo do veiculo: " + tipoVeiculoPessoa[qtdVeiculos]);
                System.out.println("Horas estacionado: " + horasEstacionado[qtdVeiculos]);
                System.out.printf("Valor pago: R$ %.2f%n", valorPago[qtdVeiculos]);
                System.out.println("------------------");
            }

            qtdVeiculos++;

            System.out.print("Deseja registrar a saida de outro veiculo? \n1 - Sim \n2 - Nao\n \n>>> ");
            int opcao = teclado.nextInt();

            teclado.nextLine();

            if (opcao == 2) {
                continua = false;
            }
        }

        System.out.println("----- Sistema encerrado! -----");
        System.out.println("Quantidade de veiculos atendidos: " + qtdVeiculos);
        System.out.printf("Valor total arrecadado: R$ %.2f%n", totalArrecadado);

        teclado.close();
    }
          }
