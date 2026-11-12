package Aula13.Exercicio15;

public class IngressoEstudante extends Ingresso{
    private String instituicao;
    private String carteirinha;


    public IngressoEstudante(int codigo, String nomeEvento, String nomeCliente, String instituicao, String carteirinha) {
        super(codigo, nomeEvento, nomeCliente);
        this.instituicao = instituicao;
        this.carteirinha = carteirinha;
    }

    @Override
    public double calcularValorFinal() {
        return super.calcularValorFinal() * 0.5;
    }

    @Override
    public String toString() {
        return super.toString() + "IngressoEstudante{" +
                "instituicao='" + instituicao + '\'' +
                ", carteirinha='" + carteirinha + '\'' +
                '}';
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getCarteirinha() {
        return carteirinha;
    }

    public void setCarteirinha(String carteirinha) {
        this.carteirinha = carteirinha;
    }
}
