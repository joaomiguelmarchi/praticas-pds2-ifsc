package model;

public class Pessoa {

	private String nome;
	private long cpf1;
	
	
	public Pessoa(String nome, long cpf) {
		super();
		this.nome = nome;
		cpf1 = cpf;
	}

	public final String getNome() {
		return nome;
	}

	public final void setNome(String nome) {
		this.nome = nome;
	}

	public final long getCpf() {
		return cpf1;
	}

	public final void setCpf(long cpf) {
		cpf1 = cpf;
	}
	

	
}