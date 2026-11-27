package Aula14.Exercicio18;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Produto> produtos = new ArrayList();
        Scanner teclado = new Scanner(System.in);
        boolean continua;

        do {
            System.out.print("MENU:" +
                    "\n1 - Cadastrar produto" +
                    "\n2 - Pesquisar produto" +
                    "\n3 - Mostrar todos" +
                    "\n4 - Verificar preco do produto" +
                    "\n5 - Encerrar" +
                    "\n>>> ");

            int menu = teclado.nextInt();

            switch (menu) {
                case 1:
                    // cadastrar
                    cadastrarProduto(produtos, teclado);
                    continua = true;
                    break;
                case 2:
                    // pesquisar
                    pesquisarProduto(produtos, teclado);
                    continua = true;
                    break;
                case 3:
                    // mostrar todos
                    mostrarTodos(produtos);
                    continua = true;
                    break;
                case 4:
                    // verificar preco
                    verificarPreco(produtos, teclado);
                    continua = true;
                    break;
                case 5:
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

    private static void mostrarTodos(ArrayList<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
        } else {
            for (Produto produtoTemp : produtos) {
                System.out.println(produtoTemp);
                System.out.println("--------------");
            }
        }
    }

    private static void pesquisarProduto(ArrayList<Produto> produtos, Scanner teclado) {
        System.out.print("Informe o codigo do produto: ");
        int codigo = teclado.nextInt();

        boolean encontrado = false;

        for (Produto produtoTemp : produtos) {
            if (produtoTemp.getCodigo() == codigo) {
                System.out.println("\nProduto encontrado!");
                System.out.println(produtoTemp);
                System.out.println("--------------");

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum produto encontrado com esse codigo!");
        }
    }

    private static void verificarPreco(ArrayList<Produto> produtos, Scanner teclado) {
        System.out.print("Informe o codigo do produto: ");
        int codigo = teclado.nextInt();

        boolean encontrado = false;

        for (Produto produtoTemp : produtos) {
            if (produtoTemp.getCodigo() == codigo) {

                System.out.print("Informe o dia da semana:" +
                        "\n1 - Domingo" +
                        "\n2 - Segunda-feira" +
                        "\n3 - Terca-feira" +
                        "\n4 - Quarta-feira" +
                        "\n5 - Quinta-feira" +
                        "\n6 - Sexta-feira" +
                        "\n7 - Sabado" +
                        "\n>>> ");

                int diaSemana = teclado.nextInt();

                if (diaSemana >= 1 && diaSemana <= 7) {
                    System.out.println("\nProduto: " + produtoTemp.getNome());
                    System.out.println("Preco base: R$ " + produtoTemp.getPrecoBase());
                    System.out.println("Preco final: R$ " + produtoTemp.calcularPrecoFinal(diaSemana));
                } else {
                    System.out.println("Dia da semana invalido!");
                }

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum produto encontrado com esse codigo!");
        }
    }

    private static void cadastrarProduto(ArrayList<Produto> produtos, Scanner teclado) {

        // gerar codigo automaticamente
        int codigo = 1;

        for (Produto produtoTemp : produtos) {
            if (produtoTemp.getCodigo() >= codigo) {
                codigo = produtoTemp.getCodigo() + 1;
            }
        }

        System.out.print("Informe o nome do produto: ");
        teclado.nextLine();
        String nome = teclado.nextLine();

        System.out.print("Informe o preco base: ");
        double precoBase = teclado.nextDouble();

        System.out.print("Informe a quantidade em estoque: ");
        int qtdEstoque = teclado.nextInt();

        System.out.print("Informe o tipo de produto:" +
                "\n1 - Alimenticio" +
                "\n2 - Limpeza" +
                "\n>>> ");

        int tipo = teclado.nextInt();

        if (tipo == 1) {
            // produto alimenticio

            teclado.nextLine();

            System.out.print("Informe a data de validade: ");
            String dataValidade = teclado.nextLine();

            System.out.print("Necessita de refrigeracao?" +
                    "\n1 - Sim" +
                    "\n2 - Nao" +
                    "\n>>> ");

            int refrigeracao = teclado.nextInt();

            ProdutoAlimenticio produtoAlimenticio;

            if (refrigeracao == 1) {
                produtoAlimenticio = new ProdutoAlimenticio(codigo, nome, precoBase, qtdEstoque, dataValidade, true);
            } else {
                produtoAlimenticio = new ProdutoAlimenticio(codigo, nome, precoBase, qtdEstoque, dataValidade, false);
            }

            produtos.add(produtoAlimenticio);

            System.out.println("Produto alimenticio cadastrado! Codigo: " + codigo);

        } else if (tipo == 2) {
            // produto de limpeza

            System.out.print("Informe o volume em ML: ");
            double volumeML = teclado.nextDouble();

            System.out.print("O produto e inflamavel?" +
                    "\n1 - Sim" +
                    "\n2 - Nao" +
                    "\n>>> ");

            int inflamavel = teclado.nextInt();

            ProdutoLimpeza produtoLimpeza;

            if (inflamavel == 1) {
                produtoLimpeza = new ProdutoLimpeza(codigo, nome, precoBase, qtdEstoque, volumeML, true);
            } else {
                produtoLimpeza = new ProdutoLimpeza(codigo, nome, precoBase, qtdEstoque, volumeML, false);
            }

            produtos.add(produtoLimpeza);

            System.out.println("Produto de limpeza cadastrado! Codigo: " + codigo);

        } else {
            System.out.println("Tipo de produto invalido!");
        }
    }
}
