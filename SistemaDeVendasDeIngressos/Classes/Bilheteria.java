package SistemaDeVendasDeIngressos.Classes;

import SistemaDeVendasDeIngressos.Excecoes.*;

import java.util.ArrayList;

public class Bilheteria {
    ArrayList<Cliente> listaDeClientes = new ArrayList<>();
    ArrayList<Evento> listaDeEventos = new ArrayList<>();

    public void adicionarCliente(Cliente c) {
        listaDeClientes.add(c);
    }

    public void adicionarEvento(Evento e) {
        listaDeEventos.add(e);
    }

    public void comprarIngresso(Cliente c, Evento e, SetoresDoEvento setor, boolean isMeiaEntrada)
            throws IdadeInvalidaException, SemVagasException, SemCarteirinhaException {

        if (c.calcularIdade(c.getDataDeNascimento()) < e.getClassificacaoDeIdade()) {
            throw new IdadeInvalidaException("Cliente menor que a classificacao indicativa do evento!");
        }

        if (!e.isSetorDisponivel(setor)) {
            throw new SemVagasException("Ingressos indisponiveis para o setor " + setor.getDescricao() + "!");
        }

        if (isMeiaEntrada && c.getNumeroCarteirinha() == null) {
            throw new SemCarteirinhaException("Cliente solicitou meia entrada, mas nao possui carteirinha cadastrada!");
        }

        e.consumirVaga(setor);
    }
}