    package Aula7;

    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Filme[] filmes = new Filme[3];
            cadastrarFilmes();
            Scanner teclado = new Scanner(System.in);
            boolean interromper;
            int menu;
            System.out.println("----- Sistema de Streaming ----- ");

            do {
                System.out.print("Menu: " +
                        "\n1 - Exibir catalogo" +
                        "\n2 - Assistir filme" +
                        "\n3 - Encerrar" +
                        "\n>>> ");

                menu = teclado.nextInt();

                switch (menu) {
                    case 1:
                        exibirCatalogo(filmes);
                        interromper = false;
                        break;
                    case 2:
                        if (assistirFilme(filmes, teclado)) {
                            interromper = true;
                        } else {
                            interromper = true;
                        };
                        break;
                    case 3:
                        System.out.println("Encerrando Streaming");
                        interromper = true;
                        break;
                    default:
                        System.out.println("Opcao invalida!!!");
                        interromper = false;
                        break;
                }
            } while(!interromper);
        }

        private static boolean assistirFilme(Filme[] filmes, Scanner teclado) {
            System.out.println("Informe o codigo do filme: ");
            int codigoInformado = teclado.nextInt();

            for (Filme meuFilme : filmes) {
                if (meuFilme.codigo == codigoInformado) {
                    // o filme existe
                    if (meuFilme.classificacao == 0) {
                        // pode assistir
                        System.out.println("Iniciando " + meuFilme.nomeFilme);
                        return true;
                    } else {
                        System.out.println("Informe sua idade: ");
                        int idadeInformada = teclado.nextInt();
                        if (idadeInformada >= meuFilme.classificacao) {
                            //pode assistir
                            System.out.println("Iniciando " + meuFilme.nomeFilme);
                            return true;
                        } else {
                            //nao pode assistir
                            System.out.println("Iniciando " + meuFilme.nomeFilme);
                            return false;
                        }
                    }
                }
            }
            System.out.println("Filme nao encontrado!");
            return false;
        }

        private static void exibirCatalogo(Filme[] filmes) {
    //        for (Filme filme : filmes) {
    //            System.out.println(filmes[i].exibirInformacoesFilme());
    //        }
            for (int i = 0; i < filmes.length; i++) {
    //            System.out.println("Filme nº " + (i + 1));
                System.out.println(filmes[i].exibirInformacoesFilme());
            }
        }

        private static void cadastrarFilmes() {
            Filme meuFilme = new Filme();

            meuFilme.nomeFilme = "Filme 1";
            meuFilme.classificacao = 0;
            meuFilme.codigo = 1;
            meuFilme.genero = "nome genero";
            meuFilme.duracaoMinutos = 90;

            Filme filme2 = new Filme();

            filme2.nomeFilme = "Filme 2";
            filme2.classificacao = 12;
            filme2.codigo = 1;
            filme2.genero = "nome genero";
            filme2.duracaoMinutos = 90;

            Filme filme3 = new Filme();

            filme3.nomeFilme = "Filme 3";
            filme3.classificacao = 18;
            filme3.codigo = 1;
            filme3.genero = "nome genero";
            filme3.duracaoMinutos = 90;

            filmes[0] = meuFilme;
            filmes[1] = filme2;
            filmes[3] = filme3;

        }


    }
