package Aula14.Exercicio18;

public abstract class Produto {
    // 1 - ATRIBUTOS PRIVADOS
    // 2 - GETTERS E SETTERS
    // 3 - CONSTRUTOR
    // 4 - toString
    private int codigo;
    private String nome;
    private double precoBase;
    private int qtdEstoque;

    public abstract double calcularPrecoFinal(int diaSemana);

    public Produto(int codigo, String nome, double precoBase, int qtdEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoBase = precoBase;
        this.qtdEstoque = qtdEstoque;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", precoBase=" + precoBase +
                ", qtdEstoque=" + qtdEstoque +
                '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
