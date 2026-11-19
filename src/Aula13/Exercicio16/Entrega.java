package Aula13.Exercicio16;

public class Entrega {
    /* 4 CARACTERISTICAS
     * 1 - ATRIBUTOS PRIVADOS
     * 2 - GET E SET
     * 3 - CONSTRUTOR
     * 4 - toString
     * */

    private int codigo;
    private String nomeDestinatario;
    private double distancia;

    public double calcularValorFinal() {
        return distancia;
    }

    public String getCondicaoRecebimento() {
        return "";
    }

    public Entrega(int codigo, String nomeDestinatario, double distancia) {
        this.codigo = codigo;
        this.nomeDestinatario = nomeDestinatario;
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "--------------" +
                "\nCodigo: " + codigo +
                "\nNome do destinatario: " + nomeDestinatario +
                "\nDistancia: " + distancia + " km";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
}