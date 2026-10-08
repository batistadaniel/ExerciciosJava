// aula de encapsulamento
// protecao de acesso direto
// modificadores de acesso (public, private, protected, default)

// private = so pode ser acessado dentro da propria classe

package Aula9.Exercicio11;

public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private int qtdEstoque;

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", qtdEstoque=" + qtdEstoque +
                '}';
    }

    public String showProduto() {
        return "Codigo: " + codigo + " | Nome: " + nome + " | Preco: " + preco + " | Quantidade: " + qtdEstoque;
    }

    public void registrarEntrada(int qtd) {
        if (qtd <= 0) {
            System.out.println("Quantidade invalida!");
        } else {
            System.out.println("Entrada de " + qtd + " registrada!");
            qtdEstoque += qtd;
        }
    }

    public void registrarSaida(int qtd) {
        // regra para nao permitir que a quantidade fique negativa
        if (qtd <= 0 && ((qtdEstoque - qtd) < 0)) {
            System.out.println("Quantidade invalida!");
        } else {
            System.out.println("Saida de " + qtd + " registrada!");
            qtdEstoque -= qtd;
        }
    }

    // encapsulamento
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if ( preco <= 0 ) {
            System.out.println("Preco invalido!");
        } else {
            this.preco = preco;
        }
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
}
