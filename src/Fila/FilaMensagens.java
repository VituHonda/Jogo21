package Fila;

import entidades.Mensagem;

public class FilaMensagens {
	
	public final int N=3;
	int ini, fim, cont;
	Mensagem mensagens[] = new Mensagem[N];
	
	public void init() {
		ini = fim = 0;
		cont = 0;
	}

	public boolean isEmpty() {
		if (cont == 0)
			return true;
		else
			return false;
	}

	public boolean isFull() {
		if (cont == N)
			return true;
		else
			return false;
	}

	public void enqueue(Mensagem mensagem) {
		if (isFull())
			System.out.println("Fila cheia");
		else {
			mensagens[fim] = mensagem;
			fim = (fim + 1) % N;
			cont++;
		}
	}

	public Mensagem dequeue() {
		Mensagem mensagem = mensagens[ini];
		ini = (ini + 1) % N;
		cont--;
		return mensagem;
	}

	public Mensagem first() {
		return mensagens[ini];
	}

	public int getSize() {
		int tamanho = this.mensagens.length;
		return tamanho;
	}

	public Mensagem[] getMensagens() {
		return mensagens;
	}

	public void setMensagens(Mensagem[] mensagens) {
		this.mensagens = mensagens;
	}
	
}
