package Aula10.Exercicio14;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean continua;
        ArrayList<Reserva> listaReservas = new ArrayList();

        System.out.println("---------- Sistema de Controle de Reservas de Salas ----------");

        do {
            System.out.print("MENU: " +
                    "\n1 - Registrar reserva" +
                    "\n2 - Informar sala, data e horario" +
                    "\n3 - Alterar status" +
                    "\n4 - Consultar reserva" +
                    "\n5 - Exibir todas as reservas" +
                    "\n6 - Encerrar" +
                    "\n>>> ");
            int menu = teclado.nextInt();
            teclado.nextLine();

            switch (menu) {
                case 1:
                    // DONE - REGISTRAR RESERVA
                    System.out.print("Informe o nome da pessoa responsavel: ");
                    String responsavel = teclado.nextLine();

                    if (responsavel.trim().isEmpty()) {
                        System.out.println("O nome do responsavel e obrigatorio!");
                    } else {
                        int numero = listaReservas.size() + 1;
                        Reserva reserva = new Reserva(numero, responsavel);
                        listaReservas.add(reserva);

                        System.out.println("Reserva registrada com sucesso!");
                        System.out.println("Numero da reserva: " + numero);
                    }

                    continua = true;
                    break;

                case 2:
                    // DONE - INFORMAR SALA, DATA E HORARIO
                    System.out.print("Informe o numero da reserva: ");
                    int numeroReserva = teclado.nextInt();
                    teclado.nextLine();

                    Reserva reservaSala = pesquisarReserva(numeroReserva, listaReservas);

                    if (reservaSala == null) {
                        System.out.println("Reserva nao encontrada!");
                    } else {
                        System.out.print("Informe a sala: ");
                        String sala = teclado.nextLine();

                        System.out.print("Informe a data: ");
                        String data = teclado.nextLine();

                        System.out.print("Informe o horario: ");
                        String horario = teclado.nextLine();

                        reservaSala.setSala(sala);
                        reservaSala.setData(data);
                        reservaSala.setHorario(horario);

                        System.out.println("Dados da reserva atualizados com sucesso!");
                    }

                    continua = true;
                    break;

                case 3:
                    // DONE - ALTERAR STATUS DA RESERVA
                    System.out.print("Informe o numero da reserva: ");
                    int numeroStatus = teclado.nextInt();
                    teclado.nextLine();

                    Reserva reservaStatus = pesquisarReserva(numeroStatus, listaReservas);

                    if (reservaStatus == null) {
                        System.out.println("Reserva nao encontrada!");
                    } else {
                        System.out.print("Informe o novo status: ");
                        String novoStatus = teclado.nextLine();

                        alterarStatus(novoStatus, reservaStatus);
                        System.out.println("Status alterado com sucesso!");
                    }

                    continua = true;
                    break;

                case 4:
                    // DONE - CONSULTAR RESERVA PELO NUMERO
                    System.out.print("Informe o numero da reserva: ");
                    int numeroPesquisa = teclado.nextInt();
                    teclado.nextLine();

                    Reserva reservaPesquisada = pesquisarReserva(numeroPesquisa, listaReservas);

                    if (reservaPesquisada == null) {
                        System.out.println("Reserva nao encontrada!");
                    } else {
                        exibirReserva(reservaPesquisada);
                    }

                    continua = true;
                    break;

                case 5:
                    // DONE - EXIBIR TODAS AS RESERVAS
                    if (listaReservas.isEmpty()) {
                        System.out.println("Nenhuma reserva cadastrada!");
                    } else {
                        for (Reserva reservaAtual : listaReservas) {
                            exibirReserva(reservaAtual);
                        }
                    }

                    continua = true;
                    break;

                case 6:
                    // DONE - ENCERRAR
                    System.out.println("Encerrando ...");
                    continua = false;
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    continua = true;
                    break;
            }

            if (continua) {
                System.out.println("---------- Sistema de Controle de Reservas de Salas ----------");
            }

        } while (continua);

        teclado.close();
    }

    public static Reserva pesquisarReserva(int numero, ArrayList<Reserva> listaReservas) {
        // FOR EACH
        for (Reserva reservaAtual : listaReservas) {
            if (reservaAtual.getNumero() == numero) {
                return reservaAtual;
            }
        }
        return null;
    }

    public static void alterarStatus(String status, Reserva reserva) {
        reserva.setStatus(status);
    }

    public static void exibirReserva(Reserva reserva) {
        System.out.println("\n---------- Reserva ----------");
        System.out.println("Numero: " + reserva.getNumero());
        System.out.println("Responsavel: " + reserva.getResponsavel());
        System.out.println("Sala: " + reserva.getSala());
        System.out.println("Data: " + reserva.getData());
        System.out.println("Horario: " + reserva.getHorario());
        System.out.println("Status: " + reserva.getStatus());
        System.out.println("-----------------------------");
    }
}
