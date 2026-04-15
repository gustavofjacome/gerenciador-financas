import java.util.ArrayList;
import java.util.List;

public class GerenciadorMovimentacoes {
    private List<Movimentacao> movimentacoes = new ArrayList<>();


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
}
