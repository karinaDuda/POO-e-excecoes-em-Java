package SistemaDeFolhaDePagamento;

public class Cargo {
    protected String nome;
    protected String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()){
            this.nome = "Nome vazio!";
        } else {
            this.nome = nome;
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isBlank()) {
            this.descricao = "Sem descricao!";
        } else {
            this.descricao = descricao;
        }
    }

    public Cargo(String nome, String descricao) {
        setNome(nome);
        setDescricao(descricao);
    }
}
