package SistemaDeFolhaDePagamento;

import java.math.BigDecimal;

public class Horista extends Funcionario {
    private BigDecimal valorDaHoraTrabalhada;
    private BigDecimal totalEmHorasTrabalhadas;

    public BigDecimal getValorDaHoraTrabalhada() {
        return valorDaHoraTrabalhada;
    }

    public void setValorDaHoraTrabalhada(BigDecimal valorDaHoraTrabalhada) {
        if (valorDaHoraTrabalhada == null || valorDaHoraTrabalhada.compareTo(BigDecimal.ZERO) < 0) {
            this.valorDaHoraTrabalhada = BigDecimal.ZERO;
        } else {
            this.valorDaHoraTrabalhada = valorDaHoraTrabalhada;
        }
    }

    public BigDecimal getTotalEmHorasTrabalhadas() {
        return totalEmHorasTrabalhadas;
    }

    public void setTotalEmHorasTrabalhadas(BigDecimal totalEmHorasTrabalhadas) {
        if (totalEmHorasTrabalhadas == null || totalEmHorasTrabalhadas.compareTo(BigDecimal.ZERO) < 0) {
            this.totalEmHorasTrabalhadas = BigDecimal.ZERO;
        } else {
            this.totalEmHorasTrabalhadas = totalEmHorasTrabalhadas;
        }
    }

    public Horista(String nome, Cargo cargoInfo, BigDecimal valorDaHoraTrabalhada, BigDecimal totalEmHorasTrabalhadas) {
        super(nome, cargoInfo);
        setValorDaHoraTrabalhada(valorDaHoraTrabalhada);
        setTotalEmHorasTrabalhadas(totalEmHorasTrabalhadas);
    }

    @Override
    public BigDecimal calcularPagamento() {
        return this.valorDaHoraTrabalhada.multiply(this.totalEmHorasTrabalhadas);
    }
}
