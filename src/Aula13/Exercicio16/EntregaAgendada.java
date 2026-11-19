package Aula13.Exercicio16;

public class EntregaAgendada extends Entrega {
    private String dataRecebimento;

    public EntregaAgendada(int codigo, String nomeDestinatario, double distancia, String dataRecebimento) {
        super(codigo, nomeDestinatario, distancia);
        this.dataRecebimento = dataRecebimento;
    }

    @Override
    public double calcularValorFinal() {
        return super.calcularValorFinal() * 1.1;
    }

    @Override
    public String getCondicaoRecebimento() {
        return "Data agendada: " + dataRecebimento;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTipo: Entrega agendada" +
                "\nData de recebimento: " + dataRecebimento;
    }

    public String getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }
}