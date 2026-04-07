package SistemaDeFolhaDePagamento;

import java.math.BigDecimal;

public class Aplicativo {
    public static void main(String[] args) {
        ListaDeFuncionarios lista = new ListaDeFuncionarios();
        Funcionario funcionario1 = new Comissionado("Maria",
                new Cargo("vendedora", "por comissao"),
                new BigDecimal("5.5"), new BigDecimal("8500.25"));

        Funcionario funcionario2 = new Horista("Joao",
                new Cargo("gerente", "por hora"),
                new BigDecimal("12.00"), new BigDecimal("40"));

        Funcionario funcionario3 = new Assalariado("Pedro",
                new Cargo("diretor", "por mes"),
                new BigDecimal("1200.50"));

        lista.adicionarFuncionario(funcionario1);
        lista.adicionarFuncionario(funcionario2);
        lista.adicionarFuncionario(funcionario3);

        lista.apresentarLista();
    }
}
