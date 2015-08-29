package br.edu.ifsp.pesquisaarquivos;

import java.util.*;

public class Main {
	public static List<Extensao> exs = new ArrayList<Extensao>();
	public static Set<Pasta> pastas = new HashSet<Pasta>();
	
	public static void main(String[] args) {	
		for(;;){
			
		}
		//criaPastas();
		
	}

	
	public void criarExtensoes(){
		
	}
	
	public static void criaPastas(){
		exs.add(new Extensao(".docx", true));
		exs.add(new Extensao(".txt", true));
		
		pastas.add(new Pasta("d:\\documentos",arrayToExtensao(exs)));
		pastas.add(new Pasta("d:\\angular+MongoDB",arrayToExtensao(exs)));
		
		for (Pasta p : pastas){
			p.obterArquivos();
		}		
	}
	
	public void obterArquivos(){
		
	}
	
	public static Extensao[] arrayToExtensao(List<Extensao> extLocal){
		int i;
		Extensao[] retExt = new Extensao[extLocal.size()];
		for (i=0;i < extLocal.size(); i++){
			retExt[i] = extLocal.get(i);
		}
		
		return retExt;
	}
}
