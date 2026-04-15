import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;

public class RepositorioArquivo {

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
        conteudo.append(String.format("SALDO FINAL:       R$ %.2f\n", saldoFinal)); // Aqui está o quanto você ficou!
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