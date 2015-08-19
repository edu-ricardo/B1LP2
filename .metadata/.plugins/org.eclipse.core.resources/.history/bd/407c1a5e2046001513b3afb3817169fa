package br.edu.ifsp.pesquisaarquivos;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Pasta {
	private String caminho;
	private Extensao extensoes[];
	private List<String> caminhoArquivos;
	
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	public Extensao[] getExtensoes() {
		return extensoes;
	}
	public void setExtensoes(Extensao[] extensoes) {
		this.extensoes = extensoes;
	}
	public List<String> getCaminhoArquivos() {
		return caminhoArquivos;
	}
	public void setCaminhoArquivos(List<String> caminhoArquivos) {
		this.caminhoArquivos = caminhoArquivos;
	}
	
	public Pasta(String caminho, Extensao[] extensoes) {
		super();
		this.caminho = caminho;
		this.extensoes = extensoes;
	}

	public void obterArquivos(){
		List<String> listaPastas = new ArrayList<String>();
		
		listaPastas.add(caminho);
		int contador = 0, contDoc = 0;
		do{
			File f = new File(listaPastas.get(0));
			for (int i = 0; i < f.listFiles().length; i++) {
				//System.out.println(f.listFiles()[i].getAbsolutePath());
				File altFile = new File(f.listFiles()[i].getAbsolutePath());
				if(altFile.isDirectory()){
					listaPastas.add(f.listFiles()[i].getAbsolutePath());
				}else{
					if (this.extensoes.length != 0){
						for(Extensao ext: this.extensoes){
							if( f.listFiles()[i].getAbsolutePath().endsWith(ext.getNome()) ){
								
							}
						}
					}
				}
			}
			if(f.isFile()){
				System.out.println("É um arquivo: " + f.getAbsolutePath());
			}else{
				System.out.println("Não é um arquivo: " + f.getAbsolutePath());
			}
			listaPastas.remove(0);
			contador++;
		}while(listaPastas.size()>0);
		System.out.println(contador);
		System.out.println("Número de .doc: " + contDoc);
	}
	
}
