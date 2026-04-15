/**
 * Representa uma movimentação financeira (receita ou despesa).
 *
 * <p>Armazena todos os dados de uma transação: identificador, descrição,
 * origem/destino, valor, data e tipo.</p>
 *
 * @see TipoMovimentacao
 */
public class Movimentacao {
    private int id;
    private String descricao;
    String origemDestino;
    private double valor;
    private short dia;
    private short mes;
    private short ano;
    /** Tipo da movimentação: {@link TipoMovimentacao#RECEITA} ou {@link TipoMovimentacao#DESPESA}. */
    private TipoMovimentacao tipo;

    /**
     * Construtor padrão sem argumentos.
     * Cria uma movimentação vazia para ser preenchida.
     */
    public Movimentacao() {
    }

    /**
     * Construtor completo que inicializa todos os campos da movimentação.
     *
     * @param id            identificador único da movimentação
     * @param descricao     descrição da movimentação
     * @param origemDestino origem ou destino do dinheiro
     * @param valor         valor monetário em reais (R$)
     * @param dia           dia do mês (1–31)
     * @param mes           mês (1–12)
     * @param ano           ano (ex: 2025)
     * @param tipo          tipo da movimentação, {@link TipoMovimentacao#RECEITA} ou {@link TipoMovimentacao#DESPESA}
     */
    public Movimentacao(int id, String descricao, String origemDestino, double valor, short dia, short mes, short ano, TipoMovimentacao tipo) {
        this.id = id;
        this.descricao = descricao;
        this.origemDestino = origemDestino;
        this.valor = valor;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.tipo = tipo;
    }

    /**
     * @return o ID da movimentação
     */
    public int getId() {
        return id;
    }

    /**
     * @param id o novo ID a ser atribuído
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return a descrição textual da movimentação
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao a nova descrição a ser atribuída
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return a string de origem/destino da movimentação
     */
    public String getOrigemDestino() {
        return origemDestino;
    }

    /**
     * @param origemDestino a nova origem/destino a ser atribuída
     */
    public void setOrigemDestino(String origemDestino) {
        this.origemDestino = origemDestino;
    }

    /**
     * @return o valor em reais (R$)
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor o novo valor em reais (R$)
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return o dia do mês (1–31)
     */
    public short getDia() {
        return dia;
    }

    /**
     * @param dia o novo dia (1–31)
     */
    public void setDia(short dia) {
        this.dia = dia;
    }

    /**
     * @return o mês (1–12)
     */
    public short getMes() {
        return mes;
    }

    /**
     * @param mes o novo mês (1–12)
     */
    public void setMes(short mes) {
        this.mes = mes;
    }

    /**
     * @return o ano (ex: 2025)
     */
    public short getAno() {
        return ano;
    }

    /**
     * @param ano o novo ano (ex: 2025)
     */
    public void setAno(short ano) {
        this.ano = ano;
    }

    /**
     * @return {@link TipoMovimentacao#RECEITA} ou {@link TipoMovimentacao#DESPESA}
     */
    public TipoMovimentacao getTipo() {
        return tipo;
    }

    /**
     * @param tipo o novo tipo da movimentação
     */
    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }

    /**
     * Formata a data da movimentação no padrão {@code dd/MM/yyyy}.
     *
     * @return a data formatada como String (ex: "25/12/2025")
     */
    public String formatarData() {
        return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);
    }

    /**
     * Retorna uma representação textual completa da movimentação.
     *
     * <p>Formato: {@code ID: X | Data: dd/MM/yyyy | Tipo: Y | Descrição: Z | Origem/Destino: W | Valor: R$ 0.00}</p>
     *
     * @return String com todos os dados da movimentação formatados
     */
    @Override
    public String toString() {
        return String.format("ID: %d | Data: %s | Tipo: %s | Descrição: %s | Origem/Destino: %s | Valor: R$ %.2f",
                this.id,
                this.formatarData(),
                this.tipo,
                this.descricao,
                this.origemDestino,
                this.valor);
    }
}