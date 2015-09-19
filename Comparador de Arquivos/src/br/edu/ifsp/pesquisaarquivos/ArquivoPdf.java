package br.edu.ifsp.pesquisaarquivos;

import java.io.IOException;

import javax.swing.JOptionPane;

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
			texto = texto.trim();
			texto = texto.replace("\n", "");
			texto = texto.replace(";", "");
			texto = texto.replace(".", "");
			texto = texto.replace("\"", "");
			texto = texto.replace("'", "");
			texto = texto.replace("\t", "");
			texto = texto.replace(String.valueOf('\n'), "");

			palavras = texto.split(" ");
			
			for (int i = 0; i < palavras.length; i++) {
				System.out.println("(Arquivo: "+this.getCaminho()+") [palavra: "+i+"] :" + palavras[i]);	
			}
						
		}
	
		try {
			pdf.close();
		} catch (IOException e) {
			//e.printStackTrace();
		}
	
	}

}
