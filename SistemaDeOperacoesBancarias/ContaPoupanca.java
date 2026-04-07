package SistemaDeOperacoesBancarias;

import java.math.BigDecimal;

public class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(BigDecimal saldo, String cliente) {
        super(saldo, cliente);
    }

    @Override
    public void sacar(BigDecimal valor) {
        System.out.println("----------------- Informacoes de saque ------------------");
        System.out.println("Saldo anterior: R$" + String.format("%.2f", getSaldo()));
        System.out.println("Valor do saque: R$" + String.format("%.2f", valor));
        BigDecimal comTaxa = valor.add(calcularTaxaDeSaque());

        System.out.println("Valor do saque com taxa: R$" + String.format("%.2f", comTaxa));

        if (getSaldo().compareTo(comTaxa) >= 0) {
            setSaldo(getSaldo().subtract(comTaxa));
        } else {
            System.out.println("Saldo insuficiente!");
        }

        System.out.println("Saldo atual: R$" + String.format("%.2f", getSaldo()));
    }

    @Override
    public BigDecimal projetarSaldoMensal() {
        BigDecimal novoSaldo = getSaldo().multiply(new BigDecimal("1.01"));
        setSaldo(novoSaldo);
        return novoSaldo;
    }

    @Override
    public BigDecimal calcularTaxaDeSaque() {
        return BigDecimal.ZERO;
    }

    public void exibirSaldoMensal() {
        BigDecimal saldoMensal = projetarSaldoMensal();
        System.out.println("------------ Informacoes do saldo mensal ----------------");
        System.out.println("Saldo mensal: R$" + String.format("%.2f", saldoMensal));
    }
}
