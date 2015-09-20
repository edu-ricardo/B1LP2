package br.edu.ifsp.pesquisaarquivos;

import java.io.IOException;
import java.util.HashMap;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class ArquivoPdf extends Arquivo{

	public ArquivoPdf(String c) {
		super(c);
		this.setCaminho(c);
	}

	public boolean canLoad(String s){
		try{
			PDDocument pdf = PDDocument.load(this.getCaminho());
			PDFTextStripper tPdf = new PDFTextStripper();
			tPdf.getText(pdf);
			pdf.close();
		}catch (IOException e){
			return false;
		}
		return true;
	}

	@Override
	public void lerArquivos() {
		PDDocument pdf = null;
		PDFTextStripper tPdf = null;
		String texto = null;
		String[] palavras;	
			
		try {
			pdf = PDDocument.load(this.getCaminho());
			tPdf = new PDFTextStripper();			
			
		} catch (IOException e) {
			//e.printStackTrace();
		}	
		
		if ((pdf == null) || (pdf.isEncrypted())){
			return;
		}
		
		try {			
			texto = tPdf.getText(pdf);
			
		} catch (IOException e1) {
			//e1.printStackTrace();
		}
		// A parir daqui conseguimos trabalhar com o texto dos arquivos pdf
		if (texto != null) {
			// trata o texto
			texto = normalize(texto);
			texto = texto.trim();			
			texto = texto.replace("\n", "");
			texto = texto.replace(";", " ");
			texto = texto.replace(".", " ");
			texto = texto.replace("\"", "");
			texto = texto.replace("\\", "");
			texto = texto.replace(",", " ");
			texto = texto.replace("(", " ");	
			texto = texto.replace(")", " ");	
			texto = texto.replace("'", "");
			texto = texto.replace("\t", "");
			texto = texto.replace("\b", "");
			texto = texto.replace(String.valueOf('\n'), "");

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
			
			for (String key: this.mapa.keySet()) {
				System.out.println("'"+key +"' <valor> "+ this.mapa.get(key));
			}
			
		}
	
		try {
			pdf.close();
		} catch (IOException e) {
			//e.printStackTrace();
		}
	
	}


	/** Para a normalização dos caracteres de 32 a 255, primeiro caracter */  
	private static final char[] FIRST_CHAR =  
	    (" !'#$%&'()*+\\-./0123456789:;<->?@ABCDEFGHIJKLMNOPQRSTUVWXYZ"  
	        + "[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ E ,f'.++^%S<O Z  ''''.-"  
	        + "-~Ts>o ZY !C#$Y|$'(a<--(_o+23'u .,1o>113?AAAAAAACEEEEIIIIDNOO"  
	        + "OOOXOUUUUyTsaaaaaaaceeeeiiiidnooooo/ouuuuyty")  
	        .toCharArray();  
	/** Para a normalização dos caracteres de 32 a 255, segundo caracter */  
	private static final char[] SECOND_CHAR =  
	    ("  '         ,                                               "  
	        + "\\                                   $  r'. + o  E      ''  "  
	        + "  M  e     #  =  'C.<  R .-..     ..>424     E E            "  
	        + "   E E     hs    e e         h     e e     h ")  
	        .toCharArray();  
	/** 
	* Efetua as seguintes normalizações para obtenção de certificados: 
	* - Elimina acentos e cedilhas dos nomes; 
	* - Converte aspas duplas em simples; 
	* - Converte algumas letras estrangeiras para seus equivalentes ASCII 
	* (como ß, convertido para ss)  
	* - Põe um "\" antes de vírgulas, permitindo nomes como 
	* "Verisign, Corp." e de "\", permitindo nomes como " a \ b "; 
	* - Converte os sinais de = para - 
	* - Alguns caracteres são removidos: 
	* -> os superiores a 255, 
	* mesmo que possam ser representados por letras latinas normais 
	* (como s, = U+015E = Latin Capital Letter S With Cedilla); 
	* -> os caracteres de controle (exceto tab, que é trocado por um espaço) 
	* @param str A string a normalizar. 
	* @return A string normalizada. 
	*/  
	public static String normalize(String str) {  
	    char[] chars = str.toCharArray();  
	    StringBuffer ret = new StringBuffer(chars.length * 2);  
	    for (int i = 0; i < chars.length; ++i) {  
	        char aChar = chars[i];  
	        if (aChar == ' ' || aChar == '\t') {  
	            ret.append(' '); // convertido para espaço  
	        } else if (aChar > ' ' && aChar < 256) {  
	            if (FIRST_CHAR[aChar - ' '] != ' ') {  
	                ret.append(FIRST_CHAR[aChar - ' ']); // 1 caracter  
	            }  
	            if (SECOND_CHAR[aChar - ' '] != ' ') {  
	                ret.append(SECOND_CHAR[aChar - ' ']); // 2 caracteres  
	            }  
	        }  
	    }  
	  
	    return ret.toString();  
	}

}
