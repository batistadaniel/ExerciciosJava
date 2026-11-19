package Aula13.Exercicio16;

public class EntregaComum extends Entrega {
    private boolean retirarPontoParceiro;

    public EntregaComum(int codigo, String nomeDestinatario, double distancia, boolean retirarPontoParceiro) {
        super(codigo, nomeDestinatario, distancia);
        this.retirarPontoParceiro = retirarPontoParceiro;
    }

    @Override
    public double calcularValorFinal() {
        if (retirarPontoParceiro) {
            return super.calcularValorFinal();
        }

        return super.calcularValorFinal() + 10;
    }

    @Override
    public String getCondicaoRecebimento() {
        if (retirarPontoParceiro) {
            return "Retirada em ponto parceiro - Prazo: 7 dias uteis";
        }

        return "Entrega em casa - Prazo: 7 dias uteis";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTipo: Entrega comum" +
                "\nRetirada em ponto parceiro: " + (retirarPontoParceiro ? "Sim" : "Nao") +
                "\nPrazo: 7 dias uteis";
    }

    public boolean isRetirarPontoParceiro() {
        return retirarPontoParceiro;
    }

    public void setRetirarPontoParceiro(boolean retirarPontoParceiro) {
        this.retirarPontoParceiro = retirarPontoParceiro;
    }
}