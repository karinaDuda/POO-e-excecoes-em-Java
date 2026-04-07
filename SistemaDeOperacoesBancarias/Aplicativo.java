package SistemaDeOperacoesBancarias;

import java.math.BigDecimal;

public class Aplicativo {
    public static void main(String[] args) {
        System.out.println("\nConta corrente");
        ContaCorrente conta1 = new ContaCorrente(new BigDecimal("1200.50"), "Maria Silva");
        conta1.depositarCheque(new BigDecimal("55.10"));
        conta1.depositarDinheiro(new BigDecimal("100"));
        conta1.sacar(new BigDecimal("200.00"));
        conta1.exibirSaldoMensal();

        System.out.println("\nConta poupanca");
        ContaPoupanca conta2 = new ContaPoupanca(new BigDecimal("2500.00"), "Joao Silva");
        conta2.depositarCheque(new BigDecimal("60.50"));
        conta2.depositarDinheiro(new BigDecimal("500"));
        conta2.sacar(new BigDecimal("10500.00"));
        conta2.exibirSaldoMensal();

        System.out.println("\nConta investimento");
        ContaInvestimento conta3 = new ContaInvestimento(new BigDecimal("5000.00"), "Jose Silva",
                new BigDecimal("2.8"));
        conta3.depositarCheque(new BigDecimal("580.00"));
        conta3.depositarDinheiro(new BigDecimal("800"));
        conta3.sacar(new BigDecimal("400.00"));
        conta3.exibirSaldoMensal();
    }
}
