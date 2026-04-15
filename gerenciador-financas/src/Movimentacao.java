public class Movimentacao {
    private int id;
    private String descricao;
    private double valor;
    private short dia;
    private short mes;
    private short ano;
    private TipoMovimentacao tipo;

    public Movimentacao() {
    }

    public Movimentacao(int id, String descricao, double valor, short dia, short mes, short ano, TipoMovimentacao tipo) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public short getDia() {
        return dia;
    }

    public void setDia(short dia) {
        this.dia = dia;
    }

    public short getMes() {
        return mes;
    }

    public void setMes(short mes) {
        this.mes = mes;
    }

    public short getAno() {
        return ano;
    }

    public void setAno(short ano) {
        this.ano = ano;
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }

    public String formatarData() {
        return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Data: %s | Tipo: %s | Descrição: %s | Valor: R$ %.2f",
                this.id,
                this.formatarData(),
                this.tipo,
                this.descricao,
                this.valor);
    }
}
