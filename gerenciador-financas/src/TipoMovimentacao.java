/**
 * Enumeração que representa os tipos possíveis de uma movimentação financeira.
 *
 * <p>Utilizada para classificar cada {@link Movimentacao} como uma entrada
 * (receita) ou saída (despesa) no sistema de controle financeiro.</p>
 */
public enum TipoMovimentacao {

    /**
     * Representa uma entrada de dinheiro (ex: salário, venda, transferência recebida).
     */
    RECEITA,

    /**
     * Representa uma saída de dinheiro (ex: conta, compra, pagamento de serviço).
     */
    DESPESA
}