package Aula13.Exercicio17;

public class PedidoEntrega extends Pedido {
private boolean entregaPrioritaria;

public PedidoEntrega(int numero, String nomeCliente, double valorItens, boolean entregaPrioritaria) {
    super(numero, nomeCliente, valorItens);
    this.entregaPrioritaria = entregaPrioritaria;
}

@Override
public double calcularValorFinal() {
    double valor = super.calcularValorFinal() * 1.1;

    if (entregaPrioritaria) {
        return valor + 20;
    }

    return valor;
}

@Override
public String getCondicaoAtendimento() {
    if (entregaPrioritaria) {
        return "Entrega prioritaria";
    }

    return "Entrega normal";
}

@Override
public String toString() {
    return super.toString() +
            "\nTipo: Pedido para entrega" +
            "\nEntrega prioritaria: " + (entregaPrioritaria ? "Sim" : "Nao");
}

public boolean isEntregaPrioritaria() {
    return entregaPrioritaria;
}

public void setEntregaPrioritaria(boolean entregaPrioritaria) {
    this.entregaPrioritaria = entregaPrioritaria;
}
}