package SistemaDeFolhaDePagamento;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Comissionado extends Funcionario {
    private BigDecimal comissao;
    private BigDecimal totalEmVendas;

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        if (comissao == null) {
            this.comissao = BigDecimal.ZERO;
        } else {
            this.comissao = comissao;
        }
    }

    public BigDecimal getTotalEmVendas() {
        return totalEmVendas;
    }

    public void setTotalEmVendas(BigDecimal totalEmVendas) {
        if (totalEmVendas == null || totalEmVendas.compareTo(BigDecimal.ZERO) < 0) {
            this.totalEmVendas = BigDecimal.ZERO;
        } else {
            this.totalEmVendas = totalEmVendas;
        }
    }

    public Comissionado(String nome, Cargo cargoInfo, BigDecimal comissao, BigDecimal totalEmVendas) {
        super(nome, cargoInfo);
        setComissao(comissao);
        setTotalEmVendas(totalEmVendas);
    }

    @Override
    public BigDecimal calcularPagamento() {
        BigDecimal taxaPorCento = this.comissao.divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
        return this.totalEmVendas.multiply(taxaPorCento);
    }
}

