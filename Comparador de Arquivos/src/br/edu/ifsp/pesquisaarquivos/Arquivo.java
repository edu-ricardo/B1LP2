package br.edu.ifsp.pesquisaarquivos;

import java.util.Map;

public abstract class Arquivo {
	private String caminho;
	private Map<String, Integer> mapa;
	
	
	public abstract void lerArquivos();
	
	public Arquivo(String c) {
	}
	
	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String nome) {
		this.caminho = nome;
	}

	public Map<String, Integer> getMapa() {
		return mapa;
	}

	public void setMapa(Map<String, Integer> mapa) {
		this.mapa = mapa;
	}
	
	
}
