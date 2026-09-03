package Aula4;

import java.util.Scanner;

public class AulaFor {
    public static void main(String[] args) {
        //sistema de lancamento de notas
        //deve ser lancadas 7 notas para cada aluno - eu preciso informar se quero continuar

        Scanner teclado = new Scanner(System.in);
        boolean continua = true;

        System.out.println("Sistema de cadastro de notas");
        do {
            double notaTotal = 0;
            for (int i = 1; i < 8; i++){
                System.out.println("Informe a nota " + i + ": ");
                notaTotal += teclado.nextDouble();
            }
            System.out.println("A nota total do alunno foi : " + notaTotal);

            System.out.println("Deseja continuar? " +
                    "\n1-Sim" +
                    "\n2-Nao");
            int opcao;
            opcao = teclado.nextInt();
            if (opcao == 2) {
                continua = false;
                System.out.println("--- ENCERRADO ---");
            }
        } while (continua);

    }
}
