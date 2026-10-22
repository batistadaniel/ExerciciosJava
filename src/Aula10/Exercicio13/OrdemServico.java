package Aula10.Exercicio13;

public class OrdemServico {
    private int id;
    private String equipamento;
    private String problemaApresentado;
    private String nomeCliente;
    private String status;
    private double valorOrcamento;
    // botao direito / generate / constructor


    public OrdemServico(int id, String equipamento, String problemaApresentado, String nomeCliente) {
        this.id = id;
        this.equipamento = equipamento;
        this.problemaApresentado = problemaApresentado;
        this.nomeCliente = nomeCliente;
        this.status = "Recebido";
    }

    // botao direito / generate / getter and setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getProblemaApresentado() {
        return problemaApresentado;
    }

    public void setProblemaApresentado(String problemaApresentado) {
        this.problemaApresentado = problemaApresentado;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValorOrcamento() {
        return valorOrcamento;
    }

    public void setValorOrcamento(double valorOrcamento) {
        if (valorOrcamento <= 0) {
            System.out.println("Valor invalido de orcamento!");
        } else {
            this.valorOrcamento = valorOrcamento;
        }
    }

}
