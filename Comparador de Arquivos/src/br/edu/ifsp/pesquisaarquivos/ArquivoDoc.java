package br.edu.ifsp.pesquisaarquivos;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class ArquivoDoc extends Arquivo{

	public ArquivoDoc(String c) {
		super(c);
		// TODO Auto-generated constructor stub
		this.setCaminho(c);
	}

	@Override
	public void lerArquivos() {
				
		String texto = "";
		try {
			
			
			if (this.getCaminho().endsWith("x")){
				XWPFDocument fs = new XWPFDocument(new FileInputStream (this.getCaminho()));
				XWPFWordExtractor word = new XWPFWordExtractor(fs);				
				texto = word.getText();
				word.close();
			}else{
				POIFSFileSystem fs = null;
				fs = new POIFSFileSystem (new FileInputStream (this.getCaminho()));
				HWPFDocument document = new HWPFDocument(fs);
				WordExtractor word = new WordExtractor(document);
				texto = word.getText();
				word.close();
			}
			
			texto = texto.replace(";", " ");
			texto = texto.replace(".", " ");
			
			//System.out.println(texto);
			// A partir daqui preenche mapa
			String[] palavras = texto.split(" ");
			
			this.mapa = new HashMap<String, Integer>();
			
			for (int i = 0; i < palavras.length; i++) {
				palavras[i].trim();				
				
				if (this.mapa.containsKey(palavras[i])){
					this.mapa.put(palavras[i], this.mapa.get(palavras[i]) + 1);
				}else{
					this.mapa.put(palavras[i], new Integer(1));
				}	
			}
			/*System.out.println("Arquivo: "+this.getCaminho());
			System.out.println("===================================================================================");
			for (String key: this.mapa.keySet()) {
				System.out.println("'"+key +"' <valor> "+ this.mapa.get(key));
			}*/

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
