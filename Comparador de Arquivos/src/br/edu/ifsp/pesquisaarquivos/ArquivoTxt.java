package br.edu.ifsp.pesquisaarquivos;

import java.io.*;
import java.util.HashMap;

public class ArquivoTxt extends Arquivo{

	public ArquivoTxt(String c) {
		super(c);
		// TODO Auto-generated constructor stub
		this.setCaminho(c);
	}

	@Override
	public void lerArquivos() {
		String texto = null;
		String linha;
		String palavras[];
		try{
			FileReader arq = new FileReader(this.getCaminho());
			BufferedReader bufferArq = new BufferedReader(arq);
			
			do {
				 linha = bufferArq.readLine();
				
				 texto += ' ' + linha;
			} while (linha != null);
			
			bufferArq.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		//trata texto
		texto = texto.replace(";", " ");
		texto = texto.replace(".", " ");
		
		// A partir daqui preenche mapa
		palavras = texto.split(" ");
		
		this.mapa = new HashMap<String, Integer>();
		
		for (int i = 0; i < palavras.length; i++) {
			palavras[i].trim();				
			
			if (this.mapa.containsKey(palavras[i])){
				this.mapa.put(palavras[i], this.mapa.get(palavras[i]) + 1);
			}else{
				this.mapa.put(palavras[i], new Integer(1));
			}
				
			
			//System.out.println(this.mapa.toString());	
		}
		
		/*System.out.println("Arquivo: "+this.getCaminho());
		System.out.println("===================================================================================");		
		for (String key: this.mapa.keySet()) {
			System.out.println("'"+key +"' <valor> "+ this.mapa.get(key));
		}*/
		
		
	}

}
