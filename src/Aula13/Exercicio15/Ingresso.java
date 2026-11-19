package Aula13.Exercicio15;

public class Ingresso {
    /* 4 CARACTERISTICAS
    * 1 - ATRIBUTOS PRIVADOS
    * 2 - GET E SET
    * 3 - CONSTRUTOR
    * 4 - toString
    * */
    private int codigo;
    private String nomeCliente;
    private String nomeEvento;
    private final double valorBase = 100;

    public double calcularValorFinal() {
        return valorBase;
    }

    public Ingresso(int codigo, String nomeEvento, String nomeCliente) {
        this.codigo = codigo;
        this.nomeEvento = nomeEvento;
        this.nomeCliente = nomeCliente;
    }

    @Override
    public String toString() {
        return "------------------------------" +
            "\nCodigo: " + codigo +
            "\nNome do cliente: " + nomeCliente +
            "\nNome do evento: " + nomeEvento +
            "\nValor base: R$ " + valorBase;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }
}
