import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;

/**
 * Responsável pela exportação das movimentações financeiras para arquivo.
 *
 * <p>Gera um extrato formatado em {@code extrato_financeiro.txt} no diretório
 * de execução do programa, contendo histórico de transações e resumo financeiro.</p>
 *
 * @see Movimentacao
 * @see TipoMovimentacao
 */
public class RepositorioArquivo {

    /**
     * Gera um extrato financeiro formatado e salva em {@code extrato_financeiro.txt}.
     *
     * <p>O extrato contém:</p>
     * <ul>
     *   <li>Uma linha por movimentação com data, tipo, origem/destino e valor</li>
     *   <li>Total de receitas, total de despesas e saldo final no rodapé</li>
     * </ul>
     *
     * <p>Exibe no console uma confirmação com o saldo final ao concluir,
     * ou a mensagem de erro em caso de falha de I/O.</p>
     *
     * @param movimentacoes lista de {@link Movimentacao} a ser incluída no extrato;
     *                      pode ser vazia, gerando um extrato sem registros
     */
    public void gerarExtrato(List<Movimentacao> movimentacoes) {
        Path caminhoArquivo = Paths.get("extrato_financeiro.txt");
        StringBuilder conteudo = new StringBuilder();

        conteudo.append("========================================================================\n");
        conteudo.append("                         EXTRATO FINANCEIRO                             \n");
        conteudo.append("========================================================================\n");
        conteudo.append(String.format("%-12s | %-10s | %-20s | %s\n", "DATA", "TIPO", "ORIGEM/DESTINO", "VALOR"));
        conteudo.append("------------------------------------------------------------------------\n");

        double totalReceitas = 0.0;
        double totalDespesas = 0.0;

        for (int i = 0; i < movimentacoes.size(); i++) {
            Movimentacao m = movimentacoes.get(i);

            if (m.getTipo() == TipoMovimentacao.RECEITA) {
                totalReceitas += m.getValor();
            } else {
                totalDespesas += m.getValor();
            }

            String linha = String.format("%-12s | %-10s | %-20s | R$ %8.2f\n",
                    m.formatarData(),
                    m.getTipo(),
                    m.getOrigemDestino(),
                    m.getValor());

            conteudo.append(linha);
        }

        double saldoFinal = totalReceitas - totalDespesas;

        conteudo.append("========================================================================\n");
        conteudo.append(String.format("TOTAL DE RECEITAS: R$ %.2f\n", totalReceitas));
        conteudo.append(String.format("TOTAL DE DESPESAS: R$ %.2f\n", totalDespesas));
        conteudo.append("------------------------------------------------------------------------\n");
        conteudo.append(String.format("SALDO FINAL:       R$ %.2f\n", saldoFinal));
        conteudo.append("========================================================================\n");

        try {
            Files.write(caminhoArquivo, conteudo.toString().getBytes());
            System.out.println("Extrato gerado com sucesso!");
            System.out.println("-> Resumo: Você ficou com um saldo de R$ " + saldoFinal);
        } catch (IOException e) {
            System.out.println("Erro ao gerar o extrato: " + e.getMessage());
        }
    }
}