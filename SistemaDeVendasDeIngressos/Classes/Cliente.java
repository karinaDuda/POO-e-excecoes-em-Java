package SistemaDeVendasDeIngressos.Classes;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Cliente {
    protected String nome;
    protected String cpf;
    protected String dataDeNascimento;
    protected String numeroCarteirinha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            this.nome = "Nome nao informado!";
        } else {
            this.nome = nome;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.isBlank()) {
            this.cpf = "CPF nao informado!";
        } else if (cpf.length() < 11) {
            this.cpf = "CPF invalido!";
        } else {
            this.cpf = cpf;
        }
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataLimite = LocalDate.of(1925, 1, 1);
        DateTimeFormatter modelo = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNasc = LocalDate.parse(dataDeNascimento, modelo);
        if (dataNasc.isAfter(dataAtual) || dataNasc.isBefore(dataLimite)) {
            this.dataDeNascimento = "Data invalida!";
        } else {
            this.dataDeNascimento = dataDeNascimento;
        }
    }

    public String getNumeroCarteirinha() {
        return numeroCarteirinha;
    }

    public void setNumeroCarteirinha(String numeroCarteirinha) {
        if (numeroCarteirinha == null || numeroCarteirinha.isBlank()) {
            this.numeroCarteirinha = null;
        } else {
            this.numeroCarteirinha = numeroCarteirinha;
        }
    }

    public Cliente(String nome, String cpf, String dataDeNascimento) {
        setNome(nome);
        setCpf(cpf);
        setDataDeNascimento(dataDeNascimento);
    }

    public Cliente(String nome, String cpf, String dataDeNascimento, String numeroCarteirinha) {
        setNome(nome);
        setCpf(cpf);
        setDataDeNascimento(dataDeNascimento);
        setNumeroCarteirinha(numeroCarteirinha);
    }

    public int calcularIdade(String dataDeNascimento) {
        if (dataDeNascimento.equals("Data invalida!")) {
            return 0;
        }

        DateTimeFormatter modelo = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNasc = LocalDate.parse(dataDeNascimento, modelo);
        LocalDate dataAtual = LocalDate.now();
        return Period.between(dataNasc, dataAtual).getYears();
    }

    public void exibirInformacoesCliente() {
        System.out.println("================== Informacoes cliente ==================");
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Data de nascimento: " + this.dataDeNascimento);
        System.out.println("Idade: " + calcularIdade(this.dataDeNascimento) + " anos");
        System.out.println("Numero da carteirinha: " + this.numeroCarteirinha);
    }
}
