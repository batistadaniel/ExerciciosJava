package Aula7.Exercicio10;

public class Atracao {
    int codigo;
    String nomeAtracao;
    String tipoAtracao;
    int duracaoMinutos;
    double alturaMinima;

    public String exibirInformacoesAtracao() {
        return "Codigo: " + codigo +
                "\nNome: " + nomeAtracao +
                "\nTipo: " + tipoAtracao +
                "\nDuracao: " + duracaoMinutos + " minutos" +
                "\nAltura minima: " + alturaMinima + " metros";
    }
}
