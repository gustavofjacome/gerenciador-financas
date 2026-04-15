import java.util.Scanner;

public class SistemaCLI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciadorMovimentacoes transacoes = new GerenciadorMovimentacoes();

        int contadorId = 1;

        while (true) {
            System.out.println("\n--- CONTROLE FINANCEIRO ---");
            System.out.println("1. Adicionar Movimentação");
            System.out.println("2. Listar Movimentações");
            System.out.println("3. Ver Resumo/Saldo");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n-- NOVA MOVIMENTAÇÃO --");

                    System.out.print("Tipo (RECEITA ou DESPESA): ");
                    TipoMovimentacao tipo = TipoMovimentacao.valueOf(sc.nextLine().toUpperCase());

                    String origemDestino;
                    if (tipo == TipoMovimentacao.DESPESA) {
                        System.out.print("Onde você gastou? (ex: Mercado, Uber, Boleto): ");
                        origemDestino = sc.nextLine();
                    } else {
                        System.out.print("De onde veio esse dinheiro? (ex: Salário, Cliente, Venda): ");
                        origemDestino = sc.nextLine();
                    }

                    System.out.print("Descrição: ");
                    String descricao = sc.nextLine();

                    System.out.print("Valor: R$ ");
                    double valor = sc.nextDouble();

                    System.out.print("Dia: ");
                    short dia = sc.nextShort();

                    System.out.print("Mês: ");
                    short mes = sc.nextShort();

                    System.out.print("Ano: ");
                    short ano = sc.nextShort();
                    sc.nextLine();

                    Movimentacao novaMov = new Movimentacao(contadorId, descricao, origemDestino, valor, dia, mes, ano, tipo);
                    transacoes.adicionarMovimentacao(novaMov);

                    System.out.println("Movimentação adicionada com sucesso!");
                    contadorId++;
                    break;

                case 2:
                    System.out.println("\n-- LISTA DE MOVIMENTAÇÕES --");
                    transacoes.listarMovimentacoes();
                    break;

                case 3:

                    System.out.println("Ver Resumo/Saldo");
                    System.out.println("Receitas: R$" + transacoes.calcularTotalReceitas());
                    System.out.println("Despesas: R$" + transacoes.calcularTotalDespesas());
                    System.out.println("Saldo Final: R$" + transacoes.calcularSaldoFinal());
                    break;


                case 4:
                    System.out.println("Salvando seus dados...");

                    RepositorioArquivo repo = new RepositorioArquivo();
                    repo.gerarExtrato(transacoes.getTodasMovimentacoes());

                    System.out.println("Encerrando programa.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}