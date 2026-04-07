package SistemaDeFolhaDePagamento;

import java.util.List;
import java.util.ArrayList;

public class ListaDeFuncionarios {
    private List<Funcionario> listaDeFuncionarios = new ArrayList<>();
    public ListaDeFuncionarios() {
    }

    public void adicionarFuncionario(Funcionario f) {
        listaDeFuncionarios.add(f);
    }

    public void apresentarLista() {
        for (Funcionario f : listaDeFuncionarios){
            f.exibirInformacoes();
        }
    }
}
