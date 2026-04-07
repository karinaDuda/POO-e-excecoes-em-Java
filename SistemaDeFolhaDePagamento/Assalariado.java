package SistemaDeFolhaDePagamento;

import java.math.BigDecimal;

public class Assalariado extends Funcionario implements Pagamento {
    private BigDecimal salarioMensal;

    public BigDecimal getSalarioMensal() {
        return salarioMensal;
    }

        public void setSalarioMensal(BigDecimal salarioMensal) {
        if (salarioMensal == null || salarioMensal.compareTo(BigDecimal.ZERO) < 0) {
            this.salarioMensal = BigDecimal.ZERO;
        } else {
            this.salarioMensal = salarioMensal;
        }
    }

    public Assalariado(String nome, Cargo cargoInfo, BigDecimal salarioMensal) {
        super(nome, cargoInfo);
        setSalarioMensal(salarioMensal);
    }

    @Override
    public BigDecimal calcularPagamento() {
        return this.salarioMensal;
    }

}
