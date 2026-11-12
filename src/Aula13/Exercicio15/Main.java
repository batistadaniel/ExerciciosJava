package Aula13.Exercicio15;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        IngressoVip ingresso = new IngressoVip(1, "PALESTRA", "Daniel", true);
//        System.out.print(ingresso);

        ArrayList<Ingresso> ingressos = new ArrayList();
        Scanner teclado = new Scanner(System.in);
        boolean continua;

        do {
            System.out.print("MENU:" +
                            "\n1 - Cadastrar" +
                            "\n2 - Pesquisar" +
                            "\n3 - Mostrar todos" +
                            "\n4 - Encerrar" +
                            ">>> ");
            int menu = teclado.nextInt();
            switch (menu) {
                case 1:
                    // todo - cadastrar
                    cadastrarIngresso(ingressos, teclado);
                    continua = true;
                    break;
                case 2:
                    // todo - pesquisar
                    pesquisarIngresso(ingressos, teclado);
                    continua = true;
                    break;
                case 3:
                    // todo - mostrar todos
                    mostrarTodos(ingressos);
                    continua = true;
                    break;
                case 4:
                    System.out.println("Encerrando!!!");
                    continua = false;
                    break;
                default:
                    System.out.println();
                    continua = false;
                    break;
            }
        } while (continua);
        teclado.close();
    }

    private static void mostrarTodos(ArrayList<Ingresso> ingressos) {
        for(Ingresso ingressoTemp: ingressos) {
            System.out.println(ingressoTemp + "Valor final: " + ingressoTemp.calcularValorFinal());
        }
    }

    private static void pesquisarIngresso(ArrayList<Ingresso> ingressos, Scanner teclado) {
    }

    private static void cadastrarIngresso(ArrayList<Ingresso> ingressos, Scanner teclado) {
        System.out.print("Informe o codigo: ");
        int codigo = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Informe o nome: ");
        String nome = teclado.nextLine();
        System.out.print("Informe o evento: ");
        String evento = teclado.nextLine();
        System.out.print("Informe o tipo de ingresso: " +
                        "\n1 - Estudante" +
                        "\n2 - Vip");
        int tipo = teclado.nextInt();
        if (tipo == 1) {
            // todo - estudante
            teclado.nextLine();
            System.out.println("Informe a instituicao: ");
            String instituicao = teclado.nextLine();
            System.out.println("Informe a carteirinha: ");
            String carteirinha = teclado.nextLine();

            IngressoEstudante ingressoEstudante = new IngressoEstudante(codigo, nome, evento, instituicao, carteirinha);
            ingressos.add(ingressoEstudante);
        } else {
            // todo - vip
            teclado.nextLine();
            System.out.println();
            System.out.print("Informe se tera acesso ao Backstage: " +
                    "\n1 - Sim" +
                    "\n2 - Nao");
            int backstage = teclado.nextInt();
            IngressoVip ingressoVip;
            if (backstage == 1) {
                // todo - com backstage
                ingressoVip = new IngressoVip(codigo, nome, evento, true);
            } else {
                ingressoVip = new IngressoVip(codigo, nome, evento, false);
            }
            ingressos.add(ingressoVip);
        }

    }
}