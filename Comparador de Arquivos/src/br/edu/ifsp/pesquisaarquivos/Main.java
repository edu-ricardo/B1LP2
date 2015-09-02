package br.edu.ifsp.pesquisaarquivos;

import java.util.*;

public class Main {
	public static List<Extensao> exs = new ArrayList<Extensao>();
	public static Set<Pasta> pastas = new HashSet<Pasta>();
	
	public static void main(String[] args) {	
		criaPastas();
		
	}

	
	public void criarExtensoes(){
		
	}
	
	public static void criaPastas(){
		exs.add(new Extensao(".docx", true));
		exs.add(new Extensao(".txt", true));
		
		//pastas.add(new Pasta("d:\\documentos",arrayToExtensao(exs)));
		//pastas.add(new Pasta("d:\\angular+MongoDB",arrayToExtensao(exs)));
		pastas.add(new Pasta("d:\\",arrayToExtensao(exs)));
		pastas.add(new Pasta("c:\\",arrayToExtensao(exs)));
		
		for (Pasta p : pastas){
			p.obterArquivos();
		}
		
		
		while ( Pasta.getnDreds() > 0 ){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
