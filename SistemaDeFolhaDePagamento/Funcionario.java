package SistemaDeFolhaDePagamento;

import java.math.BigDecimal;

public abstract class Funcionario implements Pagamento{
    protected String nome;
    protected Cargo cargo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            this.nome = "Sem nome!";
        } else {
            this.nome = nome;
        }
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        if (cargo == null) {
            this.cargo = new Cargo("Cargo nao informado!", "Cargo sem decricao!");
        } else {
            this.cargo = cargo;
        }
    }

    public Funcionario(String nome, Cargo cargo) {
        setNome(nome);
        setCargo(cargo);
    }

    @Override
    abstract public BigDecimal calcularPagamento();

    public void exibirInformacoes() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("O funcionario(a) " + getNome() +
                " com cargo " + this.cargo.getNome() + " devera receber R$"
                + String.format("%.2f", this.calcularPagamento()) + ".");
    }
}
