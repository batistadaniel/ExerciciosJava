package Aula4;

import java.util.Scanner;

public class AulaWhile {
    public static void main(String[] args) {
        // sistema de votacao bola de ouro
        Scanner teclado = new Scanner(System.in);

        int qtdVotosMessi = 0;
        int qtdVotosCristiano = 0;
        int qtdVotosClemente = 0;
        int qtdVotosTotal = 0;
        boolean continua = true;

        while (continua){
            System.out.println("Insira o seu voto: " +
                    "\n1-Messi" +
                    "\n2-Cristiano" +
                    "\n3-Clemente" );

            int voto = teclado.nextInt();

            if (voto == 1) {
                System.out.println("Voto computado pro Messi!");
                qtdVotosMessi++;
                qtdVotosTotal++;
            } else if (voto == 2) {
                System.out.println("Voto computado pro Cristiano!");
                qtdVotosCristiano++;
                qtdVotosTotal++;
            } else if (voto == 3) {
                System.out.println("Voto computado pro Clemente!");
                    qtdVotosClemente++;
                qtdVotosTotal++;
            } else {
                System.out.println("Votacao encerrada!");
                continua = false;
            }
        }

        System.out.println("Total de votos computados: " + qtdVotosTotal);

        if (qtdVotosMessi > qtdVotosCristiano && qtdVotosMessi > qtdVotosClemente) {
            System.out.println("Messi foi o vencedor!");
        } else if (qtdVotosCristiano > qtdVotosMessi && qtdVotosCristiano > qtdVotosClemente) {
            System.out.println("Cristiano foi o vencedor!");
        } else if (qtdVotosClemente > qtdVotosMessi && qtdVotosClemente > qtdVotosCristiano) {
            System.out.println("Clemente foi o vencedor!");
        } else {
            System.out.println("Empate!");
        }
    }
}
