
package Aula14.Exercicio18;

public class ProdutoLimpeza extends Produto {
    private double volumeML;
    private boolean inflamavel;

    public ProdutoLimpeza(int codigo, String nome, double precoBase, int qtdEstoque, double volumeML, boolean inflamavel) {
        super(codigo, nome, precoBase, qtdEstoque);
        this.volumeML = volumeML;
        this.inflamavel = inflamavel;
    }

    @Override
    public double calcularPrecoFinal(int diaSemana) {
        switch (diaSemana) {
            case 2: // segunda
            case 3: // terca
                return getPrecoBase() * 1.1;
            case 4: // quarta
            case 5: // quinta
            case 6: // sexta
                return getPrecoBase() * 0.8;
            default: // sabado e domingo
                return getPrecoBase();
        }
    }

    @Override
    public String toString() {
        if (inflamavel) {
            return super.toString() + "\nVolume: " + volumeML + "\nProduto inflamavel!";
        }
        return super.toString() + "\nVolume: " + volumeML + "\nProduto nao inflamavel!";
    }

    public double getVolumeML() {
        return volumeML;
    }

    public void setVolumeML(double volumeML) {
        this.volumeML = volumeML;
    }

    public boolean isInflamavel() {
        return inflamavel;
    }

    public void setInflamavel(boolean inflamavel) {
        this.inflamavel = inflamavel;
    }
}
