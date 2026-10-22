package Aula10.Exercicio13;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean continua;
        ArrayList<OrdemServico> listaOS = new ArrayList();

        System.out.println("---------- Sistema de Controle de Ordens de Serviço ----------");


        do {
            System.out.print("MENU: " +
                    "\n1 - Registrar OS" +
                    "\n2 - Alterar status" +
                    "\n3 - Registrar Orcamento" +
                    "\n4 - Pesquisar OS" +
                    "\n5 - Exibir todss OS" +
                    "\n6 - Encerrar" +
                    "\n>>> ");
            int menu = teclado.nextInt();
            teclado.nextLine();
            switch (menu) {
                case 1:
                    // DONE - REGISTRAR OS
                    System.out.print("Informe o nome do cliente: ");
                    String nome = teclado.nextLine();
                    System.out.print("Informe o equipamento: ");
                    String equipamento = teclado.nextLine();
                    System.out.println("Descricao do problema");
                    String descricao = teclado.nextLine();
                    int id = listaOS.size() + 1;
                    OrdemServico os = new OrdemServico(id, equipamento, descricao, nome);
                    listaOS.add(os);
                    System.out.println("Ordem de servico registrada com sucesso!");
                    continua = true;
                    break;
                case 2:
                    // DONE - ALTERAR STATUS DA OS
                    System.out.print("Informe o ID da OS: ");
                    int idOS = teclado.nextInt();
                    teclado.nextLine();
                    OrdemServico osASerAlterada = pesquisarOS(idOS, listaOS);
                    if (osASerAlterada == null) {
                        System.out.println("Ordem de servico nao encontrada!");
                    } else {
                        System.out.print("Informe o novo status: ");
                        String novoStatus = teclado.nextLine();
                        alterarStatus(novoStatus, osASerAlterada);
                        System.out.println("Status alterado com sucesso!");
                    }
                    continua = true;
                    break;
                case 3:
                    // TODO - REGISTRAR ORCAMENTO DA OS
                    continua = true;
                    break;
                case 4:
                    // TODO - PESQUISAR OS PELO ID
                    continua = true;
                    break;
                case 5:
                    // TODO - EXIBIR TODAS OS
                    continua = true;
                    break;
                case 6:
                    // TODO - ENCERRAR
                    System.out.println("Encerrando ...");
                    continua = false;
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while (continua);
    }
    
    public static OrdemServico pesquisarOS(int id, ArrayList<OrdemServico> listaOS){
//        for (int i = 0; i < listaOS.size(); i++) { }FOR CLASSICO
        
        for (OrdemServico ordemServicoAtual : listaOS) { // FOR EACH
            if (ordemServicoAtual.getId() == id) {
                return ordemServicoAtual;
            }
        }
        return null;
    }
    public static void alterarStatus(String status, OrdemServico os){
        os.setStatus(status);
    }
}
