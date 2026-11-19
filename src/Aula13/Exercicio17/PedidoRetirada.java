package Aula13.Exercicio17;

public class PedidoRetirada extends Pedido {
    private String horarioRetirada;

    public PedidoRetirada(int numero, String nomeCliente, double valorItens, String horarioRetirada) {
        super(numero, nomeCliente, valorItens);
        this.horarioRetirada = horarioRetirada;
    }

    @Override
    public double calcularValorFinal() {
        return super.calcularValorFinal() * 0.9;
    }

    @Override
    public String getCondicaoAtendimento() {
        return "Horario previsto para retirada: " + horarioRetirada;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTipo: Pedido para retirada" +
                "\nHorario de retirada: " + horarioRetirada;
    }

    public String getHorarioRetirada() {
        return horarioRetirada;
    }

    public void setHorarioRetirada(String horarioRetirada) {
        this.horarioRetirada = horarioRetirada;
    }
}