package Aula13.Exercicio17;

public class PedidoLocal extends Pedido {
    private boolean areaReservada;

    public PedidoLocal(int numero, String nomeCliente, double valorItens, boolean areaReservada) {
        super(numero, nomeCliente, valorItens);
        this.areaReservada = areaReservada;
    }

    @Override
    public double calcularValorFinal() {
        if (areaReservada) {
            return super.calcularValorFinal() + 15;
        }

        return super.calcularValorFinal();
    }

    @Override
    public String getCondicaoAtendimento() {
        if (areaReservada) {
            return "Atendimento em area reservada";
        }

        return "Atendimento em area comum";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTipo: Pedido no local" +
                "\nArea reservada: " + (areaReservada ? "Sim" : "Nao");
    }

    public boolean isAreaReservada() {
        return areaReservada;
    }

    public void setAreaReservada(boolean areaReservada) {
        this.areaReservada = areaReservada;
    }
}