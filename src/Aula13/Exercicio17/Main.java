package Aula13.Exercicio17;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Pedido> pedidos = new ArrayList();
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
                    cadastrarPedido(pedidos, teclado);
                    continua = true;
                    break;
                case 2:
                    // pesquisar
                    pesquisarPedido(pedidos, teclado);
                    continua = true;
                    break;
                case 3:
                    // mostrar todos
                    mostrarTodos(pedidos);
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

    private static void mostrarTodos(ArrayList<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado!");
        } else {
            for (Pedido pedidoTemp : pedidos) {
                System.out.println(pedidoTemp);
                System.out.println("Condicao de atendimento: " + pedidoTemp.getCondicaoAtendimento());
                System.out.println("Valor final: R$ " + pedidoTemp.calcularValorFinal());
                System.out.println("--------------");
            }
        }
    }

    private static void pesquisarPedido(ArrayList<Pedido> pedidos, Scanner teclado) {
        System.out.print("Informe o numero do pedido: ");
        int numero = teclado.nextInt();

        boolean encontrado = false;

        for (Pedido pedidoTemp : pedidos) {
            if (pedidoTemp.getNumero() == numero) {
                System.out.println("\nPedido encontrado!");
                System.out.println(pedidoTemp);
                System.out.println("Condicao de atendimento: " + pedidoTemp.getCondicaoAtendimento());
                System.out.println("Valor final: R$ " + pedidoTemp.calcularValorFinal());
                System.out.println("--------------");

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum pedido encontrado com esse numero!");
        }
    }

    private static void cadastrarPedido(ArrayList<Pedido> pedidos, Scanner teclado) {
        System.out.print("Informe o numero do pedido: ");
        int numero = teclado.nextInt();

        // verificar se o numero ja existe
        for (Pedido pedidoTemp : pedidos) {
            if (pedidoTemp.getNumero() == numero) {
                System.out.println("Ja existe um pedido com esse numero!");
                return;
            }
        }

        teclado.nextLine();

        System.out.print("Informe o nome do cliente: ");
        String nome = teclado.nextLine();

        System.out.print("Informe o valor dos itens: ");
        double valorItens = teclado.nextDouble();

        System.out.print("Informe o tipo de pedido: " +
                "\n1 - No local" +
                "\n2 - Para entrega" +
                "\n3 - Para retirada" +
                "\n>>> ");

        int tipo = teclado.nextInt();

        if (tipo == 1) {
            // pedido no local

            System.out.print("Informe se deseja atendimento em area reservada: " +
                    "\n1 - Sim" +
                    "\n2 - Nao" +
                    "\n>>> ");

            int reservada = teclado.nextInt();

            PedidoLocal pedidoLocal;

            if (reservada == 1) {
                // com area reservada
                pedidoLocal = new PedidoLocal(numero, nome, valorItens, true);
            } else {
                // sem area reservada
                pedidoLocal = new PedidoLocal(numero, nome, valorItens, false);
            }

            pedidos.add(pedidoLocal);

            System.out.println("Pedido no local cadastrado!");

        } else if (tipo == 2) {
            // pedido para entrega

            System.out.print("Informe se deseja entrega prioritaria: " +
                    "\n1 - Sim" +
                    "\n2 - Nao" +
                    "\n>>> ");

            int prioritaria = teclado.nextInt();

            PedidoEntrega pedidoEntrega;

            if (prioritaria == 1) {
                // entrega prioritaria
                pedidoEntrega = new PedidoEntrega(numero, nome, valorItens, true);
            } else {
                // entrega normal
                pedidoEntrega = new PedidoEntrega(numero, nome, valorItens, false);
            }

            pedidos.add(pedidoEntrega);

            System.out.println("Pedido para entrega cadastrado!");

        } else if (tipo == 3) {
            // pedido para retirada

            teclado.nextLine();

            System.out.print("Informe o horario previsto para retirada: ");
            String horario = teclado.nextLine();

            PedidoRetirada pedidoRetirada = new PedidoRetirada(numero, nome, valorItens, horario);

            pedidos.add(pedidoRetirada);

            System.out.println("Pedido para retirada cadastrado!");

        } else {
            System.out.println("Tipo de pedido invalido!");
        }
    }
}