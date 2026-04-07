package SistemaDeOperacoesBancarias;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaInvestimento extends ContaBancaria {
    private BigDecimal taxaSelic;

    public BigDecimal getTaxaSelic() {
        return taxaSelic;
    }

    public void setTaxaSelic(BigDecimal taxaSelic) {
        if (taxaSelic == null || taxaSelic.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Valor invalido!");
        } else {
            this.taxaSelic = taxaSelic;
        }
    }

    public ContaInvestimento(BigDecimal saldo, String cliente, BigDecimal taxaSelic) {
        super(saldo, cliente);
        setTaxaSelic(taxaSelic);
    }

    @Override
    void sacar(BigDecimal valor) {
        System.out.println("------------------ Informacoes de saque -------------------");
        System.out.println("Saldo anterior: R$" + String.format("%.2f", getSaldo()));
        BigDecimal taxaIOF = calcularTaxaDeSaque().multiply(valor);

        System.out.println("Taxa IOF: R$" + String.format("%.2f", taxaIOF));

        BigDecimal valorComTaxa = valor.add(taxaIOF);

        System.out.println("Valor do saque: R$" + String.format("%.2f", valorComTaxa));
        if (getSaldo().compareTo(valorComTaxa) >= 0) {
            setSaldo(getSaldo().subtract(valorComTaxa));
        } else {
            System.out.println("Saldo insuficiente!");
        }

        System.out.println("Saldo atual: R$" + String.format("%.2f", getSaldo()));
    }

    @Override
    public BigDecimal projetarSaldoMensal() {
        BigDecimal taxaPorCento = this.taxaSelic.divide(new BigDecimal("100"), 4, RoundingMode.HALF_UP);
        BigDecimal rendimento = getSaldo().multiply(taxaPorCento);
        BigDecimal novoSaldo = getSaldo().add(rendimento);
        setSaldo(novoSaldo);
        return novoSaldo;
    }

    @Override
    public BigDecimal calcularTaxaDeSaque() {
        return new BigDecimal ("0.0038");
    }

    public void exibirSaldoMensal() {
        System.out.println("------------ Informacoes do saldo mensal ----------------");
        System.out.println("Saldo mensal: R$" + String.format("%.2f", projetarSaldoMensal()));
    }
}
