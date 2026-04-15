import java.util.ArrayList;
import java.util.List;

/**
 * Gerencia a coleção de movimentações financeiras do sistema.
 *
 * <p>Responsável por armazenar, listar e calcular totais e saldo
 * a partir das movimentações registradas. Atua como camada de regra de negócio.</p>
 *
 * @see Movimentacao
 * @see TipoMovimentacao
 */
public class GerenciadorMovimentacoes {

    /** Lista interna que armazena todas as movimentações registradas. */
    private List<Movimentacao> movimentacoes = new ArrayList<>();

    /**
     * Retorna todas as movimentações registradas no sistema.
     *
     * @return {@link List} com todas as {@link Movimentacao} cadastradas
     */
    public List<Movimentacao> getTodasMovimentacoes() {
        return movimentacoes;
    }

    /**
     * Adiciona uma nova movimentação à lista.
     *
     * @param m a {@link Movimentacao} a ser adicionada
     */
    public void adicionarMovimentacao(Movimentacao m) {
        movimentacoes.add(m);
    }

    /**
     * Exibe no console todas as movimentações registradas.
     *
     * <p>Se a lista estiver vazia, exibe uma mensagem informativa.</p>
     */
    public void listarMovimentacoes(){
        if (movimentacoes.isEmpty()){
            System.out.println("Nenhuma movimentação registrada ainda.");
            return;
        }

        for (int i = 0; i < movimentacoes.size(); i++) {
            System.out.println(movimentacoes.get(i));
        }
    }

    /**
     * Calcula a soma de todas as movimentações do tipo {@link TipoMovimentacao#RECEITA}.
     *
     * @return total de receitas em reais (R$); {@code 0.0} se não houver receitas
     */
    public double calcularTotalReceitas(){
        double soma = 0.0;
        for (int i = 0; i < movimentacoes.size(); i++) {
            if (movimentacoes.get(i).getTipo() == TipoMovimentacao.RECEITA) {
                soma += movimentacoes.get(i).getValor();
            }
        }
        return soma;
    }

    /**
     * Calcula a soma de todas as movimentações do tipo {@link TipoMovimentacao#DESPESA}.
     *
     * @return total de despesas em reais (R$); {@code 0.0} se não houver despesas
     */
    public double calcularTotalDespesas(){
        double soma = 0.0;
        for (int i = 0; i < movimentacoes.size(); i++) {
            if (movimentacoes.get(i).getTipo() == TipoMovimentacao.DESPESA) {
                soma += movimentacoes.get(i).getValor();
            }
        }
        return soma;
    }

    /**
     * Calcula o saldo financeiro final.
     *
     * <p>Fórmula: {@code saldo = totalReceitas - totalDespesas}</p>
     *
     * @return saldo final em reais (R$); pode ser negativo se as despesas superarem as receitas
     */
    public double calcularSaldoFinal(){
        return calcularTotalReceitas() - calcularTotalDespesas();
    }
}