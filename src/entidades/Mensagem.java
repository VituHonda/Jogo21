package entidades;

public class Mensagem {

	private String nome;
	private String emailTelefone;
	private int motivo;
	private String mensagem;
	
	// construtores
	public Mensagem(String emailTelefone, int motivo, String mensagem) {
		this.nome = "Anonimo";
		this.emailTelefone = emailTelefone;
		this.motivo = motivo;
		this.mensagem = mensagem;
	}
	
	public Mensagem(String nome, String emailTelefone, int motivo, String mensagem) {
		if(nome == "a") {
			this.nome = "Anonimo";
		} else {
			this.nome = nome;
		}
		this.emailTelefone = emailTelefone;
		this.motivo = motivo;
		this.mensagem = mensagem;
	}

	//to String
	public String toString() {
		return ("Nome: " + this.nome +
				"\nEmail/Telefone: " + this.emailTelefone +
				"\nMotivo: " + this.motivo +
				"\nMensagem: " + this.mensagem				
				);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmailTelefone() {
		return emailTelefone;
	}

	public void setEmailTelefone(String emailTelefone) {
		this.emailTelefone = emailTelefone;
	}

	public int getMotivo() {
		return motivo;
	}

	public void setMotivo(int motivo) {
		this.motivo = motivo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
