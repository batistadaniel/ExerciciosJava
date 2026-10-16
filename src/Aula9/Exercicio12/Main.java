package Aula9.Exercicio12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Pedido pedido1 = new Pedido();

        System.out.println("---------- Sistema de Pedido de Delivery ----------");

        System.out.print("Informe o nome do cliente: ");
        pedido1.setNomeCliente(teclado.nextLine());

        try {
            System.out.print("Informe o valor dos produtos: ");
            pedido1.setValorProdutos(Double.parseDouble(teclado.nextLine()));

            System.out.print("Informe a distancia da entrega em km: ");
            pedido1.setDistancia(Double.parseDouble(teclado.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("Valor informado invalido!");
            return;
        }

        System.out.print("Informe o tipo de entrega (Normal ou Expressa): ");
        pedido1.setTipoEntrega(teclado.nextLine());

        System.out.print("Informe a forma de pagamento (Pix, Cartao ou Dinheiro): ");
        pedido1.setFormaPagamento(teclado.nextLine());

        if (pedido1.validarPedido()) {
            System.out.println("\n---------- Dados do Pedido ----------");
            System.out.println(pedido1.toString());

            System.out.printf("Valor dos produtos: R$ %.2f%n", pedido1.getValorProdutos());
            System.out.printf("Taxa de entrega: R$ %.2f%n", pedido1.calcularTaxaEntrega());
            System.out.printf("Valor do desconto: R$ %.2f%n", pedido1.calcularDesconto());
            System.out.printf("Valor final do pedido: R$ %.2f%n", pedido1.calcularValorFinal());
        } else {
            System.out.println("Dados invalidos! Nao foi possivel calcular o pedido.");
        }

        teclado.close();
    }
}
