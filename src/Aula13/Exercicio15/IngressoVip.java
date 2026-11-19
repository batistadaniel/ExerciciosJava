package Aula13.Exercicio15;

public class IngressoVip extends Ingresso{
    private boolean temBackstage;

    public IngressoVip(int codigo, String nomeEvento, String nomeCliente, boolean temBackstage) {
        super(codigo, nomeEvento, nomeCliente);
        this.temBackstage = temBackstage;
    }

    @Override
    public double calcularValorFinal() {
        if (temBackstage) {
            return super.calcularValorFinal() * 1.5 * 1.6 ;
        }

        return super.calcularValorFinal() * 1.5;
    }

    @Override
    public String toString() {
        if (temBackstage) {
            return super.toString() + "\nIngresso Vip COM BACKSTAGE";
        } else {
            return super.toString() + "\nIngresso Vip SEM BACKSTAGE";
        }

    }

    public boolean isTemBackstage() {
        return temBackstage;
    }

    public void setTemBackstage(boolean temBackstage) {
        this.temBackstage = temBackstage;
    }
}
