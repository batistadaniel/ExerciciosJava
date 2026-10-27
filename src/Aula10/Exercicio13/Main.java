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
                    "\n5 - Exibir todas OS" +
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
                    System.out.print("Descricao do problema: ");
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
                    // DONE - REGISTRAR ORCAMENTO DA OS
                    System.out.print("Informe o ID da OS: ");
                    int idOrcamento = teclado.nextInt();
                    teclado.nextLine();

                    OrdemServico osOrcamento = pesquisarOS(idOrcamento, listaOS);

                    if (osOrcamento == null) {
                        System.out.println("Ordem de servico nao encontrada!");
                    } else {
                        System.out.print("Informe o valor do orcamento: R$ ");
                        double valor = teclado.nextDouble();
                        teclado.nextLine();

                        if (valor > 0) {
                            osOrcamento.setValorOrcamento(valor);
                            System.out.println("Orcamento registrado com sucesso!");
                        } else {
                            System.out.println("Valor invalido de orcamento!");
                        }
                    }

                    continua = true;
                    break;

                case 4:
                    // DONE - PESQUISAR OS PELO ID
                    System.out.print("Informe o ID da OS: ");
                    int idPesquisa = teclado.nextInt();
                    teclado.nextLine();

                    OrdemServico osPesquisada = pesquisarOS(idPesquisa, listaOS);

                    if (osPesquisada == null) {
                        System.out.println("Ordem de servico nao encontrada!");
                    } else {
                        exibirOS(osPesquisada);
                    }

                    continua = true;
                    break;

                case 5:
                    // DONE - EXIBIR TODAS OS
                    if (listaOS.isEmpty()) {
                        System.out.println("Nenhuma ordem de servico registrada!");
                    } else {
                        for (OrdemServico ordemServicoAtual : listaOS) {
                            exibirOS(ordemServicoAtual);
                        }
                    }

                    continua = true;
                    break;

                case 6:
                    // DONE - ENCERRAR
                    System.out.println("Encerrando ...");
                    continua = false;
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    continua = true;
                    break;
            }
            System.out.println("---------- Sistema de Controle de Ordens de Serviço ----------");

        } while (continua);

        teclado.close();
    }

    public static OrdemServico pesquisarOS(int id, ArrayList<OrdemServico> listaOS) {
        // FOR EACH
        for (OrdemServico ordemServicoAtual : listaOS) {
            if (ordemServicoAtual.getId() == id) {
                return ordemServicoAtual;
            }
        }
        return null;
    }

    public static void alterarStatus(String status, OrdemServico os) {
        os.setStatus(status);
    }

    public static void exibirOS(OrdemServico os) {
        System.out.println("\n---------- Ordem de Servico ----------");
        System.out.println("ID: " + os.getId());
        System.out.println("Cliente: " + os.getNomeCliente());
        System.out.println("Equipamento: " + os.getEquipamento());
        System.out.println("Problema: " + os.getProblemaApresentado());
        System.out.println("Status: " + os.getStatus());

        if (os.getValorOrcamento() > 0) {
            System.out.println("Valor do orcamento: R$ " + os.getValorOrcamento());
        } else {
            System.out.println("Orcamento: Nao registrado");
        }

        System.out.println("--------------------------------------");
    }
}
