package Prova1;

public class Reserva {
    int codigo;
    String nomeHospede;
    int numeroQuarto;
    int quantidadeNoites;
    double valorDiaria;

    public double calcularValorTotal() {
        return quantidadeNoites * valorDiaria;
    }

    public String exibirInformacoesReserva() {
        return "Codigo da reserva: " + codigo +
                "\nNome do hospede: " + nomeHospede +
                "\nNumero do quarto: " + numeroQuarto +
                "\nQuantidade de noites: " + quantidadeNoites +
                "\nValor da diaria: R$ " + valorDiaria +
                "\nValor total da reserva: R$ " + calcularValorTotal();
    }
}

