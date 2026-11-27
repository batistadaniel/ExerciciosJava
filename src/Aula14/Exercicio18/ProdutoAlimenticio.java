package Aula14.Exercicio18;

public class ProdutoAlimenticio extends Produto {
    private String dataValidade;
    private boolean refrigeracao;

    public ProdutoAlimenticio(int codigo, String nome, double precoBase, int qtdEstoque, String dataValidade, boolean refrigeracao) {
        super(codigo, nome, precoBase, qtdEstoque);
        this.dataValidade = dataValidade;
        this.refrigeracao = refrigeracao;
    }

    @Override
    public String toString() {
        if (refrigeracao) {
            return super.toString() + "\nData de validade: " + dataValidade + "\nNecessita de refrigeracao!";
        }
        return super.toString() + "\nData de validade: " + dataValidade + "\nNao necessita de refrigeracao!";
    }

    @Override
    public double calcularPrecoFinal(int diaSemana) {
        switch (diaSemana) {
            case 1: // domingo
            case 7: // sabado
                return getPrecoBase() * 1.1;
            case 2: // segunda
            case 3: // terca
            case 4: // quarta
                return getPrecoBase() * 0.85;
            default: // quinta e sexta
                return getPrecoBase();
        }
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public boolean isRefrigeracao() {
        return refrigeracao;
    }

    public void setRefrigeracao(boolean refrigeracao) {
        this.refrigeracao = refrigeracao;
    }
}
