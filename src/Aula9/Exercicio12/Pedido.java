package Aula9.Exercicio12;

public class Pedido {
    private String nomeCliente;
    private double valorProdutos;
    private double distancia;
    private String tipoEntrega;
    private String formaPagamento;

    @Override
    public String toString() {
        return "Cliente: " + nomeCliente +
                " | Distancia: " + distancia + " km" +
                " | Entrega: " + tipoEntrega +
                " | Pagamento: " + formaPagamento;
    }

    public boolean validarPedido() {
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            System.out.println("Nome do cliente invalido!");
            return false;
        } else if (valorProdutos <= 0) {
            System.out.println("Valor dos produtos invalido!");
            return false;
        } else if (distancia <= 0) {
            System.out.println("Distancia invalida!");
            return false;
        } else if (!tipoEntrega.equalsIgnoreCase("Normal") &&
                !tipoEntrega.equalsIgnoreCase("Expressa")) {
            System.out.println("Tipo de entrega invalido!");
            return false;
        } else if (!formaPagamento.equalsIgnoreCase("Pix") &&
                !formaPagamento.equalsIgnoreCase("Cartao") &&
                !formaPagamento.equalsIgnoreCase("Cartão") &&
                !formaPagamento.equalsIgnoreCase("Dinheiro")) {
            System.out.println("Forma de pagamento invalida!");
            return false;
        } else {
            return true;
        }
    }

    public double calcularTaxaEntrega() {
        double taxa = 0;

        if (tipoEntrega.equalsIgnoreCase("Normal")) {
            taxa = 5;

            if (distancia > 5) {
                taxa += (distancia - 5) * 2;
            }
        } else if (tipoEntrega.equalsIgnoreCase("Expressa")) {
            taxa = 10;

            if (distancia > 5) {
                taxa += (distancia - 5) * 3;
            }
        }

        return taxa;
    }

    public double calcularDesconto() {
        if (valorProdutos >= 150 &&
                formaPagamento.equalsIgnoreCase("Pix")) {
            return valorProdutos * 0.10;
        } else {
            return 0;
        }
    }

    public double calcularValorFinal() {
        return valorProdutos - calcularDesconto() + calcularTaxaEntrega();
    }

    // encapsulamento
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getValorProdutos() {
        return valorProdutos;
    }

    public void setValorProdutos(double valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
