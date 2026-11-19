package Aula13.Exercicio16;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Entrega> entregas = new ArrayList();
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
                    cadastrarEntrega(entregas, teclado);
                    continua = true;
                    break;
                case 2:
                    // pesquisar
                    pesquisarEntrega(entregas, teclado);
                    continua = true;
                    break;
                case 3:
                    // mostrar todos
                    mostrarTodos(entregas);
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

    private static void mostrarTodos(ArrayList<Entrega> entregas) {
        if (entregas.isEmpty()) {
            System.out.println("Nenhuma entrega cadastrada!");
        } else {
            for (Entrega entregaTemp : entregas) {
                System.out.println(entregaTemp);
                System.out.println("Condicao de recebimento: " + entregaTemp.getCondicaoRecebimento());
                System.out.println("Valor final: R$ " + entregaTemp.calcularValorFinal());
                System.out.println("--------------");
            }
        }
    }

    private static void pesquisarEntrega(ArrayList<Entrega> entregas, Scanner teclado) {
        System.out.print("Informe o codigo da entrega: ");
        int codigo = teclado.nextInt();

        boolean encontrado = false;

        for (Entrega entregaTemp : entregas) {
            if (entregaTemp.getCodigo() == codigo) {
                System.out.println("\nEntrega encontrada!");
                System.out.println(entregaTemp);
                System.out.println("Condicao de recebimento: " + entregaTemp.getCondicaoRecebimento());
                System.out.println("Valor final: R$ " + entregaTemp.calcularValorFinal());
                System.out.println("--------------");

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhuma entrega encontrada com esse codigo!");
        }
    }

    private static void cadastrarEntrega(ArrayList<Entrega> entregas, Scanner teclado) {
        System.out.print("Informe o codigo: ");
        int codigo = teclado.nextInt();

        // verificar se o codigo ja existe
        for (Entrega entregaTemp : entregas) {
            if (entregaTemp.getCodigo() == codigo) {
                System.out.println("Ja existe uma entrega com esse codigo!");
                return;
            }
        }

        teclado.nextLine();

        System.out.print("Informe o nome do destinatario: ");
        String nome = teclado.nextLine();

        System.out.print("Informe a distancia em KM: ");
        double distancia = teclado.nextDouble();

        System.out.print("Informe o tipo de entrega: " +
                "\n1 - Comum" +
                "\n2 - Expressa" +
                "\n3 - Agendada" +
                "\n>>> ");

        int tipo = teclado.nextInt();

        if (tipo == 1) {
            // entrega comum

            System.out.print("Informe a forma de recebimento: " +
                    "\n1 - Retirar em ponto parceiro" +
                    "\n2 - Receber em casa" +
                    "\n>>> ");

            int retirada = teclado.nextInt();

            EntregaComum entregaComum;

            if (retirada == 1) {
                // retirar em ponto parceiro
                entregaComum = new EntregaComum(codigo, nome, distancia, true);
            } else {
                // receber em casa
                entregaComum = new EntregaComum(codigo, nome, distancia, false);
            }

            entregas.add(entregaComum);

            System.out.println("Entrega comum cadastrada!");

        } else if (tipo == 2) {
            // entrega expressa

            System.out.print("Informe a forma de entrega: " +
                    "\n1 - Mesmo dia" +
                    "\n2 - Ate 2 dias uteis" +
                    "\n>>> ");

            int prazo = teclado.nextInt();

            EntregaExpressa entregaExpressa;

            if (prazo == 1) {
                // mesmo dia
                entregaExpressa = new EntregaExpressa(codigo, nome, distancia, true);
            } else {
                // ate 2 dias uteis
                entregaExpressa = new EntregaExpressa(codigo, nome, distancia, false);
            }

            entregas.add(entregaExpressa);

            System.out.println("Entrega expressa cadastrada!");

        } else if (tipo == 3) {
            // entrega agendada

            teclado.nextLine();

            System.out.print("Informe a data de recebimento: ");
            String data = teclado.nextLine();

            EntregaAgendada entregaAgendada = new EntregaAgendada(codigo, nome, distancia, data);

            entregas.add(entregaAgendada);

            System.out.println("Entrega agendada cadastrada!");

        } else {
            System.out.println("Tipo de entrega invalido!");
        }
    }
}