import java.util.ArrayList;
import java.util.List;

public class GerenciadorMovimentacoes {
    private List<Movimentacao> movimentacoes = new ArrayList<>();


    public List<Movimentacao> getTodasMovimentacoes() {
        return movimentacoes;
    }

    public void adicionarMovimentacao(Movimentacao m) {
        movimentacoes.add(m);
    }

    public void listarMovimentacoes(){
        if (movimentacoes.isEmpty()){
            System.out.println("Nenhuma movimentação registrada ainda.");
            return;
        }

        for (int i = 0; i < movimentacoes.size(); i++) {
            System.out.println(movimentacoes.get(i));
        }
    }

    public double calcularTotalReceitas(){
        double soma = 0.0;
        for (int i = 0; i < movimentacoes.size(); i++) {
            if (movimentacoes.get(i).getTipo() == TipoMovimentacao.RECEITA) {
                soma += movimentacoes.get(i).getValor();
            }
        }
        return soma;
    }

    public double calcularTotalDespesas(){
        double soma = 0.0;
        for (int i = 0; i < movimentacoes.size(); i++) {
            if (movimentacoes.get(i).getTipo() == TipoMovimentacao.DESPESA) {
                soma += movimentacoes.get(i).getValor();
            }
        }
        return soma;
    }

    public double calcularSaldoFinal(){
        return calcularTotalReceitas() - calcularTotalDespesas();
    }
}
