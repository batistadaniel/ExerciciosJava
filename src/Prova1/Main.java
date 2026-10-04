package Prova1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("----- Sistema de Reservas de Hotel -----");

        System.out.print("Informe a quantidade de reservas que deseja cadastrar: ");
        int quantidadeReservas = teclado.nextInt();

        Reserva[] reservas = new Reserva[quantidadeReservas];

        cadastrarReservas(reservas, teclado);

        boolean interromper = false;
        int menu;

        System.out.println("\n----- Sistema iniciado -----");

        do {
            System.out.print("\nMenu: " +
                    "\n1 - Listar Reservas" +
                    "\n2 - Consultar Reserva" +
                    "\n3 - Encerrar" +
                    "\n>>> ");

            menu = teclado.nextInt();

            switch (menu) {
                case 1:
                    listarReservas(reservas);
                    interromper = false;
                    break;

                case 2:
                    consultarReserva(reservas, teclado);
                    interromper = false;
                    break;

                case 3:
                    System.out.println("Encerrando sistema de reservas!");
                    interromper = true;
                    break;

                default:
                    System.out.println("Opcao invalida!!!");
                    interromper = false;
                    break;
            }

        } while (!interromper);
    }

    private static void cadastrarReservas(Reserva[] reservas, Scanner teclado) {

        for (int i = 0; i < reservas.length; i++) {

            Reserva reserva = new Reserva();

            System.out.println("\n----- Cadastro da reserva " + (i + 1) + " -----");

            System.out.print("Informe o codigo da reserva: ");
            reserva.codigo = teclado.nextInt();

            teclado.nextLine();

            System.out.print("Informe o nome completo do hospede: ");
            reserva.nomeHospede = teclado.nextLine();

            System.out.print("Informe o numero do quarto: ");
            reserva.numeroQuarto = teclado.nextInt();

            System.out.print("Informe a quantidade de noites: ");
            reserva.quantidadeNoites = teclado.nextInt();

            System.out.print("Informe o valor da diaria: ");
            reserva.valorDiaria = teclado.nextDouble();

            reservas[i] = reserva;
        }
    }

    private static void listarReservas(Reserva[] reservas) {

        System.out.println("\n----- Reservas cadastradas -----");

        for (int i = 0; i < reservas.length; i++) {
            System.out.println("Codigo: " + reservas[i].codigo);
            System.out.println("Nome do hospede: " + reservas[i].nomeHospede);
            System.out.println("--------------------------------");
        }
    }

    private static void consultarReserva(Reserva[] reservas, Scanner teclado) {

        System.out.print("\nDeseja consultar por:" +
                "\n1 - Codigo da reserva" +
                "\n2 - Nome completo do hospede" +
                "\n>>> ");

        int opcao = teclado.nextInt();

        teclado.nextLine();

        boolean encontrou = false;

        if (opcao == 1) {

            System.out.print("Informe o codigo da reserva: ");
            int codigoInformado = teclado.nextInt();

            for (Reserva reserva : reservas) {
                if (reserva.codigo == codigoInformado) {
                    System.out.println("\n--------------------------------");
                    System.out.println(reserva.exibirInformacoesReserva());
                    System.out.println("--------------------------------");

                    encontrou = true;
                    break;
                }
            }

        } else if (opcao == 2) {

            System.out.print("Informe o nome completo do hospede: ");
            String nomeInformado = teclado.nextLine();

            for (Reserva reserva : reservas) {
                if (reserva.nomeHospede.equalsIgnoreCase(nomeInformado)) {
                    System.out.println("\n--------------------------------");
                    System.out.println(reserva.exibirInformacoesReserva());
                    System.out.println("--------------------------------");

                    encontrou = true;
                    break;
                }
            }

        } else {
            System.out.println("Opcao invalida!!!");
            return;
        }

        if (!encontrou) {
            System.out.println("Reserva não encontrada!");
        }
    }
}
