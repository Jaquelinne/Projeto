package modelo;

import java.awt.image.BufferedImage;

import javax.swing.text.html.HTMLEditorKit.Parser;

public class Op_Logicas {
	
	public Op_Logicas(){
		
	}

	public BufferedImage logica_or(BufferedImage imagem1,  BufferedImage imagem2){
		
		BufferedImage imagem_or = new BufferedImage(imagem1.getHeight(), imagem1.getWidth(), BufferedImage.TYPE_INT_RGB);
		
		int valor1 = imagem1.getRGB(0, 0);
		int valor2 = imagem2.getRGB(0, 0);
		System.out.println(valor1 + " - " + valor2);
		String numero_binario1 = Integer.toBinaryString(valor1);
		String numero_binario2 = Integer.toBinaryString(valor1);
		
		System.out.println(numero_binario1 + " - " + numero_binario2);
		
		/*for (int y = 0; y < imagem1.getHeight(); y++) {
			for (int x = 0; x < imagem1.getWidth(); x++) {
				
				int valor1 = imagem1.getRGB(y, x);
				int valor2 = imagem2.getRGB(y, x);
				System.out.println(valor1 + " - " + valor2);
				String numero_binario1 = Integer.toBinaryString(valor1);
				String numero_binario2 = Integer.toBinaryString(valor1);
				
				System.out.println(numero_binario1 + " - " + numero_binario2);
			}
		}*/
		
		
		return imagem_or; 
	}
}
