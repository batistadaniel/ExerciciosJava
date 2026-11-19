package Aula13.Exercicio17;

public class Pedido {
    /* 4 CARACTERISTICAS
     * 1 - ATRIBUTOS PRIVADOS
     * 2 - GET E SET
     * 3 - CONSTRUTOR
     * 4 - toString
     * */

    private int numero;
    private String nomeCliente;
    private double valorItens;

    public double calcularValorFinal() {
        return valorItens;
    }

    public String getCondicaoAtendimento() {
        return "";
    }

    public Pedido(int numero, String nomeCliente, double valorItens) {
        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.valorItens = valorItens;
    }

    @Override
    public String toString() {
        return "--------------" +
                "\nNumero: " + numero +
                "\nNome do cliente: " + nomeCliente +
                "\nValor dos itens: R$ " + valorItens;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getValorItens() {
        return valorItens;
    }

    public void setValorItens(double valorItens) {
        this.valorItens = valorItens;
    }
}