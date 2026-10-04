
package Aula7.Exercicio10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("----- Sistema de Parque de Diversoes -----");

        System.out.print("Informe a quantidade de atracoes: ");
        int quantidadeAtracoes = teclado.nextInt();

        Atracao[] atracoes = new Atracao[quantidadeAtracoes];

        cadastrarAtracoes(atracoes, teclado);

        boolean interromper = false;
        int menu;

        System.out.println("\n----- Sistema iniciado -----");

        do {
            System.out.print("\nMenu: " +
                    "\n1 - Exibir Atracoes" +
                    "\n2 - Escolher Atracao" +
                    "\n3 - Encerrar" +
                    "\n>>> ");

            menu = teclado.nextInt();

            switch (menu) {
                case 1:
                    exibirAtracoes(atracoes);
                    interromper = false;
                    break;

                case 2:
                    if (escolherAtracao(atracoes, teclado)) {
                        interromper = true;
                    } else {
                        interromper = false;
                    }
                    break;

                case 3:
                    System.out.println("Encerrando sistema do parque!");
                    interromper = true;
                    break;

                default:
                    System.out.println("Opcao invalida!!!");
                    interromper = false;
                    break;
            }

        } while (!interromper);
    }

    private static void cadastrarAtracoes(Atracao[] atracoes, Scanner teclado) {

        for (int i = 0; i < atracoes.length; i++) {

            Atracao atracao = new Atracao();

            System.out.println("\n----- Cadastro da atracao " + (i + 1) + " -----");

            System.out.print("Informe o codigo: ");
            atracao.codigo = teclado.nextInt();

            teclado.nextLine();

            System.out.print("Informe o nome da atracao: ");
            atracao.nomeAtracao = teclado.nextLine();

            System.out.print("Informe o tipo da atracao: ");
            atracao.tipoAtracao = teclado.nextLine();

            System.out.print("Informe a duracao em minutos: ");
            atracao.duracaoMinutos = teclado.nextInt();

            System.out.print("Informe a altura minima em metros: ");
            atracao.alturaMinima = teclado.nextDouble();

            atracoes[i] = atracao;
        }
    }

    private static void exibirAtracoes(Atracao[] atracoes) {

        System.out.println("\n----- Atracoes cadastradas -----");

        for (int i = 0; i < atracoes.length; i++) {
            System.out.println(atracoes[i].exibirInformacoesAtracao());
            System.out.println("--------------------------------");
        }
    }

    private static boolean escolherAtracao(Atracao[] atracoes, Scanner teclado) {

        System.out.print("Informe o codigo da atracao: ");
        int codigoInformado = teclado.nextInt();

        for (Atracao atracao : atracoes) {

            if (atracao.codigo == codigoInformado) {

                if (atracao.alturaMinima == 0) {
                    System.out.println("Atracao " + atracao.nomeAtracao + " liberada");
                    return true;
                } else {

                    System.out.print("Informe sua altura em metros: ");
                    double alturaInformada = teclado.nextDouble();

                    if (alturaInformada >= atracao.alturaMinima) {
                        System.out.println("Atracao " + atracao.nomeAtracao + " liberada");
                        return true;
                    } else {
                        System.out.println("Voce nao possui a altura necessaria para esta atracao!");
                        return false;
                    }
                }
            }
        }

        System.out.println("Atracao nao encontrada!");
        return false;
    }
}

