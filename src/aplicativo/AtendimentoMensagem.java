package aplicativo;

import java.util.Scanner;

import Fila.FilaMensagens;
import entidades.Mensagem;

public class AtendimentoMensagem {

	public static void main(String[] args) {

		Scanner e = new Scanner(System.in);
		
		// tamanho da fila é 3
		FilaMensagens filaReclamacao = new FilaMensagens();
		FilaMensagens filaSugestao = new FilaMensagens();
		FilaMensagens filaResolucao = new FilaMensagens();
		filaReclamacao.init();
		filaSugestao.init();
		filaResolucao.init();

		int opcoes = 4;
		
		// teste rapido uma pergunta para cada tipo - msg1 resolucao, msg2 sugestao
		Mensagem msg1 = new Mensagem("a", "vitorutk@gmail.com", 1, "nao gostei");
		Mensagem msg2 = new Mensagem("vitor", "995007294", 2, "poderia melhorar");
		filaReclamacao.enqueue(msg1);
		filaSugestao.enqueue(msg2);

		while (opcoes != 0) {

			System.out.println("-----Menu-----" + "\n0 - Encerra o programa" + "\n1 - Recebimento de Mensagem"
					+ "\n2 - Atendimento de Mensagem" + "\n3 - Recebimento e Encaminhamento de Resolucao");

			opcoes = e.nextInt();

			switch (opcoes) {
			case 0:
				if (!filaReclamacao.isEmpty() || !filaSugestao.isEmpty() || !filaResolucao.isEmpty()) {
					System.out.println("Ainda existem mensagens em alguma fila resolva-as antes de encerrar.\n");
					opcoes = 4;
				} else {
					System.out.println("Encerrando...");
				}
				break;

			case 1:
				System.out.println("Digite o nome: (Opcional, se não quiser se identificar digite a)");
				String nome = e.next();

				System.out.println("Informe o email ou telefone para retornarmos a resposta: ");
				String emailTelefone = e.next();

				System.out.println("Informe o tipo da mensagem, digite: \n1 - Reclamacao \n2 - Sugestao");
				int motivo = e.nextInt();

				while (motivo < 1 || motivo > 2) {
					System.out.println(
							"Informe corretamente o tipo da mensagem, digite: \n1 - Reclamacao \n2 - Sugestao");
					motivo = e.nextInt();
				}

				System.out.println("Pronto, agora digite sua mensagem: ");
				String mensagem = e.next();

				Mensagem msg = new Mensagem(nome, emailTelefone, motivo, mensagem);

				if (motivo == 1) {
					filaReclamacao.enqueue(msg);
				} else {
					filaSugestao.enqueue(msg);
				}
				break;

			case 2:
				System.out.println(
						"Digite qual tipo de mensagem voce deseja atender, digite: \n1 - Reclamacao \n2 - Sugestao");
				motivo = e.nextInt();
				while (motivo < 1 || motivo > 2) {
					System.out.println(
							"Informe corretamente o tipo da mensagem, digite: \n1 - Reclamacao \n2 - Sugestao");
					motivo = e.nextInt();
				}
				if (motivo == 1) {
					if (filaReclamacao.isEmpty()) {
						System.out.println("A fila esta vazia, nao ha mensagens.\n");
					} else {
						System.out.println("Aqui esta a mensagem da fila reclamacao");
						System.out.println(filaReclamacao.first());
						System.out.println(
								"\nO que deseja fazer, digite: \n1 - Para responder a mensagem \n2 - Para reenviar a outro setor");
						motivo = e.nextInt();
						while (motivo < 1 || motivo > 2) {
							System.out.println(
									"Informe corretamente o tipo da mensagem, digite: \n1 - Reclamacao \n2 - Sugestao");
							motivo = e.nextInt();
						}
						if (motivo == 1) {
							System.out.println(
									"Enviada resposta para cliente: sua solicitacao ja foi resolvida. Obrigado!!!\n");
							filaReclamacao.dequeue();
						} else {
							System.out.println("Sua mensagem sera reenviada para o setor correto.\n");
							filaResolucao.enqueue(filaReclamacao.dequeue());
						}
					}
				} else {

					if (filaSugestao.isEmpty()) {
						System.out.println("A fila esta vazia, nao ha mensagens.\n");
					} else {
						System.out.println("Aqui esta a mensagem da fila sugestao");
						System.out.println(filaSugestao.first());
						System.out.println(
								"\nO que deseja fazer, digite: \n1 - Para responder a mensagem \n2 - Para reenviar a outro setor");
						motivo = e.nextInt();
						while (motivo < 1 || motivo > 2) {
							System.out.println(
									"Informe corretamente o tipo da mensagem, digite: \n1 - Reclamacao \n2 - Sugestao");
							motivo = e.nextInt();
						}
						if (motivo == 1) {
							System.out.println(
									"Enviada resposta para cliente: sua solicitacao ja foi resolvida. Obrigado!!!\n");
							filaSugestao.dequeue();
						} else {
							System.out.println("Sua mensagem sera reenviada para o setor correto.\n");
							filaResolucao.enqueue(filaSugestao.dequeue());
						}
					}
				}
				break;

			case 3:
				if (filaResolucao.isEmpty()) {
					System.out.println("A fila esta vazia, nao ha mensagens.\n");
				} else {
					System.out.println("Enviada resposta para cliente: sua solicitacao ja foi resolvida. Obrigado!!!\n");
					filaResolucao.dequeue();
				}
				break;

			default:
				System.out.println("Digite uma opcao valida!!!\n");
				break;
			}

		}

	}

}
