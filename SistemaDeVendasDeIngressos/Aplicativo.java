package SistemaDeVendasDeIngressos;

import java.util.Scanner;
import SistemaDeVendasDeIngressos.Classes.Bilheteria;
import SistemaDeVendasDeIngressos.Classes.Cliente;
import SistemaDeVendasDeIngressos.Classes.Evento;
import SistemaDeVendasDeIngressos.Classes.SetoresDoEvento;
import SistemaDeVendasDeIngressos.Excecoes.*;

public class Aplicativo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bilheteria bilheteria = new Bilheteria();

        Evento evento = new Evento("Rock in Rio", 18,
                1, 0, 0);
        bilheteria.adicionarEvento(evento);
        evento.exibirInformacaoDoEvento();

        System.out.println("======================= Cliente =======================");
        System.out.println("Nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.println("Informe o CPF: ");
        String cpf = scanner.nextLine();

        System.out.println("Data de nascimento (dd/mm/aaaa): ");
        String data = scanner.nextLine();

        System.out.println("Informe o numero da carteirinha para meia entrada (ou enter parar pular): ");
        String numCarteirinha = scanner.nextLine();
        if (numCarteirinha.isBlank()) {
            numCarteirinha = null;
        }

        Cliente cliente = new Cliente(nome, cpf, data,numCarteirinha);
        bilheteria.adicionarCliente(cliente);
        cliente.exibirInformacoesCliente();

        System.out.println("======================= Setores =======================");
        System.out.println("Escolha o setor desejado digitando o numero correspondente:");
        System.out.println("1 - " + SetoresDoEvento.PISTA.getDescricao() + " (R$ " + SetoresDoEvento.PISTA.getValorIngresso() + ")");
        System.out.println("2 - " + SetoresDoEvento.VIP.getDescricao() + " (R$ " + SetoresDoEvento.VIP.getValorIngresso() + ")");
        System.out.println("3 - " + SetoresDoEvento.CAMAROTE.getDescricao() + " (R$ " + SetoresDoEvento.CAMAROTE.getValorIngresso() + ")");
        int opcaoSetor = scanner.nextInt();
        SetoresDoEvento setorEscolhido;
        if (opcaoSetor == 1) {
            setorEscolhido = SetoresDoEvento.PISTA;
        } else if (opcaoSetor == 2) {
            setorEscolhido = SetoresDoEvento.VIP;
        } else {
            setorEscolhido = SetoresDoEvento.CAMAROTE;
        }

        System.out.println("======================== Venda ========================");
        System.out.println("O ingresso meia-entrada: (S/N)");
        boolean isMeia = scanner.next().equalsIgnoreCase("s");
        System.out.println("\nProcessando a compra...\n");

        try {
            bilheteria.comprarIngresso(cliente, evento, setorEscolhido, isMeia);
            System.out.println("Compra realizada com sucesso!");
        } catch (IdadeInvalidaException | SemVagasException |  SemCarteirinhaException exception) {
            System.out.println("Compra nao autorizada! " + exception.getMessage());
        } catch (Exception exception) {
            System.out.println("Erro inesperado no sistema! " + exception.getMessage());
        } finally {
            System.out.println("Atendimento encerrado!");
        }
    }
}
