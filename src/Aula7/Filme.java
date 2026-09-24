package Aula7;

public class Filme {
    String nomeFilme;
    int codigo;
    int duracaoMinutos;
    int classificacao;
    String genero;

    public String exibirInformacoesFilme() {
        return "Nome: " + nomeFilme +
                "\nCodigo: " + codigo +
                "\nDuracao: " + duracaoMinutos +
                "\nClassificacao: " + classificacao +
                "\nGenero: " + genero;
    }
}
