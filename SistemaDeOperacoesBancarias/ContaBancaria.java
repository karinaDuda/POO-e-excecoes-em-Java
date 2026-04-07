package SistemaDeOperacoesBancarias;

import java.math.BigDecimal;

public abstract class ContaBancaria implements AtualizaSaldo, TaxaOperacao {
    private BigDecimal saldo;
    private String cliente;

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        if (saldo == null || saldo.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Saldo invalido! Valor definido: R$ 0,00.");
            this.saldo = BigDecimal.ZERO;
        } else {
            this.saldo = saldo;
        }
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        if (cliente == null || cliente.isBlank()) {
            this.cliente = "Nome do cliente nao informado!";
        } else {
            this.cliente = cliente;
        }
    }

    public ContaBancaria(BigDecimal saldo, String cliente) {
        setSaldo(saldo);
        setCliente(cliente);
    }

    public void depositarCheque(BigDecimal valor) {
        System.out.println("------------------- Deposito cheque --------------------");
        System.out.println("Valor do cheque depositado: R$" + String.format("%.2f", valor));
        System.out.println("Saldo anterior: R$" + String.format("%.2f", getSaldo()));
        setSaldo(valor.add(getSaldo()));
        System.out.println("Valor atual: R$" + String.format("%.2f", getSaldo()));
    }

    public void depositarDinheiro(BigDecimal valor) {
        System.out.println("---------------- Deposito em dinheiro ------------------");
        System.out.println("Valor do deposito: R$" + valor);
        System.out.println("Saldo anterior: R$" + getSaldo());
        setSaldo(valor.add(getSaldo()));
        System.out.println("Saldo atual: R$" + getSaldo());
    }

    @Override
    public abstract BigDecimal projetarSaldoMensal();

    @Override
    public abstract BigDecimal calcularTaxaDeSaque();

    abstract void sacar(BigDecimal valor);
}
