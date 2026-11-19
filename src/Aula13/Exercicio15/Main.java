package Aula13.Exercicio15;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // IngressoVip ingresso = new IngressoVip(1, "PALESTRA", "Daniel", true);
        // System.out.print(ingresso);

        ArrayList<Ingresso> ingressos = new ArrayList();
        Scanner teclado = new Scanner(System.in);
        boolean continua;

        do {
            System.out.print("MENU:" +
                    "\n1 - Cadastrar" +
                    "\n2 - Pesquisar" +
                    "\n3 - Mostrar todos" +
                    "\n4 - Encerrar" +
                    "\n>>> ");
            int menu = teclado.nextInt();

            switch (menu) {
                case 1:
                    // cadastrar
                    cadastrarIngresso(ingressos, teclado);
                    continua = true;
                    break;
                case 2:
                    // pesquisar
                    pesquisarIngresso(ingressos, teclado);
                    continua = true;
                    break;
                case 3:
                    // mostrar todos
                    mostrarTodos(ingressos);
                    continua = true;
                    break;
                case 4:
                    System.out.println("Encerrando!!!");
                    continua = false;
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    continua = true;
                    break;
            }
        } while (continua);

        teclado.close();
    }

    private static void mostrarTodos(ArrayList<Ingresso> ingressos) {
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado!");
        } else {
            for (Ingresso ingressoTemp : ingressos) {
                System.out.println(ingressoTemp + "\nValor final: R$ " + ingressoTemp.calcularValorFinal());
                System.out.println("------------------------------");
            }
        }
    }

    private static void pesquisarIngresso(ArrayList<Ingresso> ingressos, Scanner teclado) {
        System.out.print("Informe o codigo do ingresso: ");
        int codigo = teclado.nextInt();

        boolean encontrado = false;

        for (Ingresso ingressoTemp : ingressos) {
            if (ingressoTemp.getCodigo() == codigo) {
                System.out.println("\nIngresso encontrado!");
                System.out.println(ingressoTemp);
                System.out.println("Valor final: R$ " + ingressoTemp.calcularValorFinal());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum ingresso encontrado com esse codigo!");
        }
    }

    private static void cadastrarIngresso(ArrayList<Ingresso> ingressos, Scanner teclado) {
        System.out.print("Informe o codigo: ");
        int codigo = teclado.nextInt();

        // verificar se o codigo ja existe
        for (Ingresso ingressoTemp : ingressos) {
            if (ingressoTemp.getCodigo() == codigo) {
                System.out.println("Ja existe um ingresso com esse codigo!");
                return;
            }
        }

        teclado.nextLine();

        System.out.print("Informe o nome: ");
        String nome = teclado.nextLine();

        System.out.print("Informe o evento: ");
        String evento = teclado.nextLine();

        System.out.print("Informe o tipo de ingresso: " +
                "\n1 - Estudante" +
                "\n2 - Vip" +
                "\n>>> ");
        int tipo = teclado.nextInt();

        if (tipo == 1) {
            // estudante
            teclado.nextLine();

            System.out.print("Informe a instituicao: ");
            String instituicao = teclado.nextLine();

            System.out.print("Informe a carteirinha: ");
            String carteirinha = teclado.nextLine();

            IngressoEstudante ingressoEstudante = new IngressoEstudante(codigo, evento, nome, instituicao, carteirinha);
            ingressos.add(ingressoEstudante);

            System.out.println("Ingresso de estudante cadastrado!");

        } else if (tipo == 2) {
            // vip
            System.out.print("Informe se tera acesso ao Backstage: " +
                    "\n1 - Sim" +
                    "\n2 - Nao" +
                    "\n>>> ");
            int backstage = teclado.nextInt();

            IngressoVip ingressoVip;

            if (backstage == 1) {
                // com backstage
                ingressoVip = new IngressoVip(codigo, evento, nome, true);
            } else {
                // sem backstage
                ingressoVip = new IngressoVip(codigo, evento, nome, false);
            }

            ingressos.add(ingressoVip);

            System.out.println("Ingresso VIP cadastrado!");

        } else {
            System.out.println("Tipo de ingresso invalido!");
        }
    }
}
