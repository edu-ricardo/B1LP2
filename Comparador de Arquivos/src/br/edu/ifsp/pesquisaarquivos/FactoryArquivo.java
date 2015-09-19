package br.edu.ifsp.pesquisaarquivos;

public class FactoryArquivo {
	public static Arquivo criaArquivo(String c){
		if (c.endsWith(".doc") || c.endsWith(".docx")){
			return new ArquivoDoc(c);
		}else if (c.endsWith(".pdf")){
			return new ArquivoPdf(c);
		}else{
			return new ArquivoTxt(c);
		}
	}
}
