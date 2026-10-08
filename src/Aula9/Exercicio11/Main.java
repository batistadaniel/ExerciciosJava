// aula de encapsulamento
// protecao de acesso direto
// modificadores de acesso (public, private, protected, default)

// private = so pode ser acessado dentro da propria classe

package Aula9.Exercicio11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // clasee - variavel(objeto)
        Produto produto1 = new Produto();

        boolean continua = true;

//        produto1.codigo = 1;
//        produto1.nome = "Arroz";
//        produto1.preco = 30;
//        produto1.qtdEstoque = 15;

        // cadastro de produtos
        produto1.setCodigo(1);
        produto1.setNome("Arroz");
        produto1.setPreco(30);
        produto1.setQtdEstoque(30);

        System.out.println("---------- Gerenciamento de estoque ----------");

        do {
            System.out.print("Menu: " +
                    "\n1 - Exibir dados do produto" +
                    "\n2 - Registrar entrada" +
                    "\n3 - Registrar saida" +
                    "\n4 - Alterar preco" +
                    "\n5 - Encerrar" +
                    "\n>>> ");
            int menu = teclado.nextInt();

            switch (menu) {
                case 1 :
                    // done - exibir dados
//                    System.out.println(produto1.showProduto());
                    System.out.println(produto1.toString());
                    break;
                case 2 :
                    // done - registrar entrada
                    System.out.print("Informe a quantidade de entrada: ");
                    int qtdEntrada = teclado.nextInt();
                    produto1.registrarEntrada(qtdEntrada);
                    break;
                case 3 :
                    // done - registrar saida
                    System.out.print("Informe a quantidade de saida: ");
                    int qtdSaida = teclado.nextInt();
                    produto1.registrarSaida(qtdSaida);
                    break;
                case 4 :
                    // done - alterar preco
                    System.out.print("Informe o novo preco: ");
                    double preco = teclado.nextDouble();
                    produto1.setPreco(preco);
                    break;
                case 5 :
                    System.out.println("Encerrando sistema");
                    continua = false;
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while(continua);

//        System.out.println("O codigo do produto é :" + produto1.getCodigo());

    }
}
