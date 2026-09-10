package Aula4;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nome;
        double valorCompra = 0;
        double valorFinal = 0;
        String formaPagamento = "Pix";
        int opcaoPagamento = 0;
        String tipoCliente = "Comum";
        int opcaoCliente = 0;
        boolean continua = true;
        int compraRealizada = 0;
        String tipoDesconto = "";

        System.out.println("----- Sistema de Controle de Vendas -----");

        while (continua) {
            System.out.print("Informe o nome do cliente: ");
            nome = teclado.nextLine();

            System.out.print("Informe o valor da compra R$ ");
            valorCompra = teclado.nextDouble();

            System.out.print("Informe a forma de pagamento: " +
                    "\n1 - Pix" +
                    "\n2 - Cartão" +
                    "\n3 - Dinheiro" +
                    "\nPagamento: ");
            opcaoPagamento = teclado.nextInt();
            if (opcaoPagamento == 1) {
                formaPagamento = "Pix";
            } else if (opcaoPagamento == 2) {
                formaPagamento = "Cartão";
            } else if (opcaoPagamento == 3) {
                formaPagamento = "Dinheiro";
            } else {
                System.out.print("Opcao invalida!");
            }

            System.out.print("Informe o tipo de cliente: " +
                    "\n1 - Comum" +
                    "\n2 - Fidelidade" +
                    "\nTipo: ");
            opcaoCliente = teclado.nextInt();
            if (opcaoCliente == 1) {
                tipoCliente = "Comum";
            } else if (opcaoCliente == 2) {
                tipoCliente = "Fidelidade";
            } else {
                System.out.print("Opcao invalida!");
            }

            if (tipoCliente.equalsIgnoreCase("fidelidade") && valorCompra >= 100) {
                valorFinal = (valorCompra * 0.9);
                tipoDesconto = "10%";
            } else if (tipoCliente.equalsIgnoreCase("comum") && valorCompra >= 200 && formaPagamento.equalsIgnoreCase("pix")) {
                valorFinal = (valorCompra * 0.95);
                tipoDesconto = "5%";
            } else {
                valorFinal = valorCompra;
                tipoDesconto = "Nao obteve!";
            }
            compraRealizada++;

            System.out.println("Nome da compra: " + nome);
            System.out.println("Valor original R$ " + valorCompra);
            System.out.println("Valor desconto: " + tipoDesconto);
            System.out.println("Valor com desconto R$ " + valorFinal);

            System.out.println("Deseja continuar? \n1 - Sim \n2 - Nao");
            int opcao = teclado.nextInt();
            if (opcao == 2) {
                continua = false;
            }
            teclado.nextLine();
        }
    }
}
