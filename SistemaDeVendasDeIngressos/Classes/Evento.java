package SistemaDeVendasDeIngressos.Classes;

public class Evento {
    private String nomeDoEvento;
    private int classificacaoDeIdade;
    private int vagasPista;
    private int vagasVip;
    private int vagasCamarote;

    public String getNomeDoEvento() {
        return nomeDoEvento;
    }

    public void setNomeDoEvento(String nomeDoEvento) {
        if (nomeDoEvento == null || nomeDoEvento.isBlank()) {
            this.nomeDoEvento = "Evento nao informado";
        } else {
            this.nomeDoEvento = nomeDoEvento;
        }
    }

    public int getClassificacaoDeIdade() {
        return classificacaoDeIdade;
    }

    public void setClassificacaoDeIdade(int classificacaoDeIdade) {
        if (classificacaoDeIdade < 0) {
            this.classificacaoDeIdade = 0;
        } else {
            this.classificacaoDeIdade = classificacaoDeIdade;
        }
    }

    public int getVagasPista() {
        return vagasPista;
    }

    public void setVagasPista(int vagasPista) {
        if (vagasPista < 0) {
            this.vagasPista = 0;
        } else {
            this.vagasPista = vagasPista;
        }
    }

    public int getVagasVip() {
        return vagasVip;
    }

    public void setVagasVip(int vagasVip) {
        if (vagasVip < 0) {
            this.vagasVip = 0;
        } else {
            this.vagasVip = vagasVip;
        }
    }

    public int getVagasCamarote() {
        return vagasCamarote;
    }

    public void setVagasCamarote(int vagasCamarote) {
        if (vagasCamarote < 0) {
            this.vagasCamarote = 0;
        } else {
            this.vagasCamarote = vagasCamarote;
        }
    }

    public Evento(String nomeDoEvento, int classificacaoDeIdade, int vagasPista, int vagasVip, int vagasCamarote) {
        setNomeDoEvento(nomeDoEvento);
        setClassificacaoDeIdade(classificacaoDeIdade);
        setVagasPista(vagasPista);
        setVagasVip(vagasVip);
        setVagasCamarote(vagasCamarote);
    }

    public boolean isSetorDisponivel(SetoresDoEvento setor) {
        if (setor == SetoresDoEvento.PISTA) {
            return vagasPista > 0;
        } else if (setor == SetoresDoEvento.VIP) {
            return vagasVip > 0;
        } else if (setor == SetoresDoEvento.CAMAROTE) {
            return vagasCamarote > 0;
        } else {
            return false;
        }
    }

    public void consumirVaga(SetoresDoEvento setor) {
        if (setor == SetoresDoEvento.PISTA) {
            this.vagasPista--;
        } else if (setor == SetoresDoEvento.VIP) {
            this.vagasVip--;
        } else if (setor == SetoresDoEvento.CAMAROTE) {
            this.vagasCamarote--;
        }
    }

    public void exibirInformacaoDoEvento() {
        System.out.println("======================= Evento =======================");
        System.out.println("Evento: " + this.nomeDoEvento);
        System.out.println("Classificacao indicativa: : " + this.classificacaoDeIdade);
    }
}
