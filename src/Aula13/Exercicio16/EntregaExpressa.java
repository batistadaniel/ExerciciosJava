package Aula13.Exercicio16;

public class EntregaExpressa extends Entrega {
    private boolean mesmoDia;

    public EntregaExpressa(int codigo, String nomeDestinatario, double distancia, boolean mesmoDia) {
        super(codigo, nomeDestinatario, distancia);
        this.mesmoDia = mesmoDia;
    }

    @Override
    public double calcularValorFinal() {
        if (mesmoDia) {
            return super.calcularValorFinal() * 2 + 20;
        }

        return super.calcularValorFinal() * 2;
    }

    @Override
    public String getCondicaoRecebimento() {
        if (mesmoDia) {
            return "Entrega no mesmo dia";
        }

        return "Entrega em ate 2 dias uteis";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTipo: Entrega expressa" +
                "\nMesmo dia: " + (mesmoDia ? "Sim" : "Nao") +
                "\nPrazo: " + getCondicaoRecebimento();
    }

    public boolean isMesmoDia() {
        return mesmoDia;
    }

    public void setMesmoDia(boolean mesmoDia) {
        this.mesmoDia = mesmoDia;
    }
}