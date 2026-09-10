package Aula4;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String nome;
        int idade;
        String tipoIngresso = "Comum";
        boolean possuiDocumento = true;
        boolean reponsavelPresente = true;
        int opcaoIngreso;
        int opcaoDocumento;
        int opcaoResponsavel;
        boolean continua = true;
        int qtdEntrou = 0;
        int qtdNaoEntrou = 0;

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
            } else if (opcaoIngreso == 3) {
                tipoIngresso = "Meia";
            } else {
                System.out.print("Opcao invalida!");
            }

            System.out.println("Possui documento com foto? " +
                    "\n1 - Sim" +
                    "\n2 - Nao");

            opcaoDocumento = teclado.nextInt();
            if (opcaoDocumento == 1) {
                possuiDocumento = true;
            } else if (opcaoDocumento == 2) {
                possuiDocumento = false;
            } else {
                System.out.print("Opcao invalida!");
            }

            if (idade < 16) {
                System.out.println("Participantes menores de 16 anos somente podem entrar acompanhados.");
                System.out.println("Possui responsavel presente? " +
                        "\n1 - Sim" +
                        "\n2 - Nao");
                opcaoResponsavel = teclado.nextInt();
                if (opcaoResponsavel == 1) {
                    reponsavelPresente = true;
                } else if (opcaoResponsavel == 2) {
                    reponsavelPresente = false;
                    qtdNaoEntrou++;
                } else {
                    System.out.print("Opcao invalida!");
                }
            } else if (tipoIngresso.equalsIgnoreCase("meia") && possuiDocumento) {
                System.out.println("Participantes com ingresso 'meia' devem apresentar documento com foto.");
                qtdEntrou++;
            } else if (idade >= 16 && (tipoIngresso.equalsIgnoreCase("meia") || tipoIngresso.equalsIgnoreCase("vip"))) {
                System.out.println("Participantes com ingresso \"comum\" ou \"vip\" podem entrar normalmente");
                qtdEntrou++;
            } else {
                System.out.println("Entrada recusada!");
                qtdNaoEntrou++;
            }

            System.out.println("Deseja continuar? \n1 - Sim \n2 - Nao");
            int opcao = teclado.nextInt();
            if (opcao == 2) {
                continua = false;
            }
            teclado.nextLine();
        }

        System.out.println("Entraram " + qtdEntrou + " pessoas.");
        System.out.println("Nao entraram " + qtdNaoEntrou + " pessoas.");
    }
}
