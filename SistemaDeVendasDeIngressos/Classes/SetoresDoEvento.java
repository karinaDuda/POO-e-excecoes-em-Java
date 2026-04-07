package SistemaDeVendasDeIngressos.Classes;

import java.math.BigDecimal;

public enum SetoresDoEvento {
    PISTA("Pista comum", new BigDecimal("450.00")),
    VIP("Pista VIP", new BigDecimal("850.00")),
    CAMAROTE("Camarote premium", new BigDecimal("1200.00"));

    private String descricao;
    private BigDecimal valorIngresso;

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValorIngresso() {
        return valorIngresso;
    }

    SetoresDoEvento(String descricao, BigDecimal valorIngresso) {
        this.descricao = descricao;
        this.valorIngresso = valorIngresso;
    }
}
