package Aula10.Exercicio14;

public class Reserva {
    private int numero;
    private String responsavel;
    private String sala;
    private String data;
    private String horario;
    private String status;

    public Reserva(int numero, String responsavel) {
        this.numero = numero;
        this.responsavel = responsavel;
        this.status = "Agendada";
        this.sala = "Nao informada";
        this.data = "Nao informada";
        this.horario = "Nao informado";
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
