package br.edu.ifsp.pesquisaarquivos;

public class Extensao {
	private String nome;
	private boolean caseSensitive;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isCaseSensitive() {
		return caseSensitive;
	}
	public void setCaseSensitive(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}
	
	public Extensao(String nome, boolean caseSensitive) {
		super();
		this.nome = nome;
		this.caseSensitive = caseSensitive;
	}
	
	
}
