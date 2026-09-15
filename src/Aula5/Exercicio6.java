package Aula5;

import java.util.Arrays;
import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String[] nomes = new String[10];
        String[] cpfs = new String[10];
        int clienteOk = 0;
        boolean continua = true;

        int qtdQuartos = 10;
        int[] qtdNoitesReserva = new int[10];

        System.out.println("----- Sistema de Reservas de Hotel -----");

        for (int i = 0; i < qtdQuartos; i++) {

            System.out.println("Todos os dados sao obrigatorios!");

            System.out.print("Informe o nome  do hóspede responsável pela reserva: ");
            nomes[i] = teclado.nextLine();

            while (nomes[i].isEmpty()) {
                System.out.print("Nome nao pode estar em branco, digite novamente: ");
                nomes[i] = teclado.nextLine();
                if (!nomes[i].isEmpty()) {
                    break;
                }
            }

            System.out.print("Informe o CPF do hóspede responsável pela reserva: ");
            cpfs[i] = teclado.nextLine();

            while (cpfs[i].isEmpty()) {
                System.out.print("CPF nao pode estar em branco, digite novamente: ");
                cpfs[i] = teclado.nextLine();
                if (!cpfs[i].isEmpty()) {
                    break;
                }
            }

            System.out.print("Quantidade de noites da hospedagem: ");
            qtdNoitesReserva[i] = teclado.nextInt();

            while (qtdNoitesReserva[i] == 0) {
                System.out.print("Quantidade de noites da hospedagem nao pode ser 0, digite novamente: ");
                qtdNoitesReserva[i] = teclado.nextInt();
                if (qtdNoitesReserva[i] > 0) {
                    break;
                }
            }

            System.out.print("Deseja continuar?" +
                    "\n1 - Sim" +
                    "\n2 - Nao" +
                    "\n>>>: ");

            int opcao = teclado.nextInt();

            teclado.nextLine();

            if (opcao == 2) {
                System.out.println("Sistema encerrado!");
                break;
            }
            clienteOk++;

        }

        for (int i = 0; i < clienteOk + 1; i++) {
            System.out.println("----------------------------------------");
            System.out.println("Quarto nº " + (i + 1));
            System.out.println("Nome do hospede: " + nomes[i]);
            System.out.println("CPF:" + cpfs[i]);
            System.out.println("Quantidade de noites reservadoas: " + qtdNoitesReserva[i]);
        }
        System.out.println("----------------------------------------");

        // achei esse stream para manipular array na internet
        int somaDasNoites = Arrays.stream(qtdNoitesReserva).sum();
        System.out.println();

        System.out.println("Quantidade total de noites reservadas no hotel: " + somaDasNoites);
        System.out.println("----------------------------------------");
        //todo
        //2. Exibir a quantidade total de noites reservadas no hotel;
        //3. Exibir o nome do hóspede que permanecerá mais noites;
        //4. Exibir a quantidade de noites da maior hospedagem.

    }
}