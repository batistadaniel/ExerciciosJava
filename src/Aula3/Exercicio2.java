package Aula3;

import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        String nome;
        String tipoCliente;
        String formaPagamento;
        double valorCompra;
        double desconto = 0;
        double valorFinal;

        System.out.print("Digite o nome do cliente: ");
        nome = teclado.nextLine();

        System.out.print("Digite o tipo de cliente (Comum ou Premium): ");
        tipoCliente = teclado.nextLine();

        System.out.print("Digite a forma de pagamento (Pix, Cartao ou Boleto): ");
        formaPagamento = teclado.nextLine();

        System.out.print("Digite o valor da compra: R$ ");
        valorCompra = teclado.nextDouble();

        if (tipoCliente.equalsIgnoreCase("Premium")) {

            if (formaPagamento.equalsIgnoreCase("Pix")) {
                desconto = 20;
            } else {
                desconto = 10;
            }

        } else if (tipoCliente.equalsIgnoreCase("Comum")) {

            if (formaPagamento.equalsIgnoreCase("Pix") && valorCompra >= 200) {
                desconto = 10;
            } else if ((formaPagamento.equalsIgnoreCase("Cartao")
                    || formaPagamento.equalsIgnoreCase("Boleto"))
                    && valorCompra >= 500) {
                desconto = 5;
            }
        }

        valorFinal = valorCompra - (valorCompra * desconto / 100);

        System.out.println("\n--- RESULTADO DA COMPRA ---");
        System.out.println("Nome do cliente: " + nome);
        System.out.println("Percentual de desconto: " + desconto + "%");
        System.out.printf("Valor original: R$ %.2f%n", valorCompra);
        System.out.printf("Valor final: R$ %.2f%n", valorFinal);

        if (desconto > 0) {
            System.out.println("Compra com desconto");
        } else {
            System.out.println("Compra sem desconto");
        }
        
        teclado.close();
    }
}
