package modelo;

import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.Tela_Resultado;

public class Efeitos {
	
	Tela_Resultado exibir;
	public Efeitos(){
		
	}
	
	public BufferedImage Negativo (BufferedImage imagem){
		//Criar uma imagem de Buffer para receber manipulações
		
		BufferedImage imagem_negativa = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		for (int y = 0; y < imagem.getHeight(); y++) {
			for (int x = 0; x < imagem.getWidth(); x++) {
				// pega o nivel de cor de um pixel
				// retornará o inverso do valor do pixel
				int nivel_cinza = 255 - (int) imagem.getRGB(y, x);
				// chama função gera nivel de cinza que faz deslocamento de bits
				//nivel_cinza = geraNivelCinza(nivel_cinza);
				
				imagem_negativa.setRGB(y, x, nivel_cinza);	
				
			}
			
		}
		//exibir = new Tela_Resultado(imagem_negativa, "Imagem Negativa");
		return imagem_negativa;
	}

	private int geraNivelCinza(int valor) {
		// TODO Auto-generated method stub
		return valor | valor << 8 | valor << 16; // Faz deslocamento de bits
	}
	
	public BufferedImage media (BufferedImage imagem, int mascarar){
		
		BufferedImage imagem_auxiliar = new BufferedImage(imagem.getWidth()+2, imagem.getHeight()+2, BufferedImage.TYPE_INT_RGB);
		BufferedImage imagem_media = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		
		// inclui em uma imagem auxilar mais uma linha de "zeros" em todas as laterais
		for (int i = 1 ; i < imagem_auxiliar.getHeight()-1; i++) {
			for (int j = 1; j < imagem_auxiliar.getWidth()-1; j++) {
				
				imagem_auxiliar.setRGB(i, j, imagem.getRGB(i-1, j-1));
			}
		}
		//exibir = new Tela_Resultado(imagem_auxiliar, "Imagem Média");
		
		for (int y = 1; y < imagem_auxiliar.getHeight()-1; y++) {
			for (int x = 1; x < imagem_auxiliar.getWidth()-1; x++) {
				
				int media = imagem_auxiliar.getRGB(y-1, x-1) + imagem_auxiliar.getRGB(y-1, x) + imagem_auxiliar.getRGB(y-1, x+1) + imagem_auxiliar.getRGB(y, x+1) + imagem_auxiliar.getRGB(y, x) + imagem_auxiliar.getRGB(y+1, x+1) + imagem_auxiliar.getRGB(y+1, x) + imagem_auxiliar.getRGB(y, x-1)+imagem_auxiliar.getRGB(y+1, x-1);
				
				media = Math.round(media/9);	
				System.out.print(media);
				imagem_auxiliar.setRGB(y, x, media);		
				imagem_media.setRGB(y-1, x-1, media);	
				
			}
			System.out.println();
		}
		
		//exibir = new Tela_Resultado(imagem_media, "Imagem Média");
		return imagem_media;
	}

	public BufferedImage mediana (BufferedImage imagem, int mascarar){
		
		BufferedImage imagem_auxiliar = new BufferedImage(imagem.getWidth()+2, imagem.getHeight()+2, BufferedImage.TYPE_INT_RGB);
		BufferedImage imagem_mediana = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		
		
		// inclui em uma imagem auxilar mais uma linha de "zeros" em todas as laterais
		for (int i = 1 ; i < imagem_auxiliar.getHeight()-1; i++) {
			for (int j = 1; j < imagem_auxiliar.getWidth()-1; j++) {
				
				imagem_auxiliar.setRGB(i, j, imagem.getRGB(i-1, j-1));
			}
		}
		//exibir = new Tela_Resultado(imagem_auxiliar, "Imagem Média");
		
		for (int y = 1; y < imagem_auxiliar.getHeight()-1; y++) {
			for (int x = 1; x < imagem_auxiliar.getWidth()-1; x++) {
				
				int[] mascara = {imagem_auxiliar.getRGB(y-1, x-1), imagem_auxiliar.getRGB(y-1, x), imagem_auxiliar.getRGB(y-1, x+1), imagem_auxiliar.getRGB(y, x+1), imagem_auxiliar.getRGB(y, x), imagem_auxiliar.getRGB(y+1, x+1), imagem_auxiliar.getRGB(y+1, x), imagem_auxiliar.getRGB(y, x-1), imagem_auxiliar.getRGB(y+1, x-1)};
				
				Arrays.sort(mascara);
				int mediana = mascara[4];
				imagem_auxiliar.setRGB(y, x, mediana);		
				imagem_mediana.setRGB(y-1, x-1, mediana);	
				
			}
			System.out.println();
		}
		
		//exibir = new Tela_Resultado(imagem_mediana, "Imagem Mediana");
		return imagem_mediana;
	}
	
	public BufferedImage passa_alta (BufferedImage imagem){
	
		BufferedImage imagem_auxiliar = new BufferedImage(imagem.getWidth()+2, imagem.getHeight()+2, BufferedImage.TYPE_INT_RGB);
		BufferedImage imagem_passa_alta = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		
		// inclui em uma imagem auxilar mais uma linha de "zeros" em todas as laterais
		for (int i = 1 ; i < imagem_auxiliar.getHeight()-1; i++) {
			for (int j = 1; j < imagem_auxiliar.getWidth()-1; j++) {
				
				imagem_auxiliar.setRGB(i, j, imagem.getRGB(i-1, j-1));
			}
		}
		//exibir = new Tela_Resultado(imagem_auxiliar, "Imagem Média");
		
		for (int y = 1; y < imagem_auxiliar.getHeight()-1; y++) {
			for (int x = 1; x < imagem_auxiliar.getWidth()-1; x++) {
				
				int passa_alta = - imagem_auxiliar.getRGB(y-1, x-1) - imagem_auxiliar.getRGB(y-1, x) - imagem_auxiliar.getRGB(y-1, x+1) - imagem_auxiliar.getRGB(y, x+1) +(8 * imagem_auxiliar.getRGB(y, x)) - imagem_auxiliar.getRGB(y+1, x+1) - imagem_auxiliar.getRGB(y+1, x) - imagem_auxiliar.getRGB(y, x-1)- imagem_auxiliar.getRGB(y+1, x-1);
								
				//imagem_auxiliar.setRGB(y, x, passa_alta);		
				imagem_passa_alta.setRGB(y-1, x-1, passa_alta);	
				
			}
			System.out.println();
		}
		
		return imagem_passa_alta;
	}

	public BufferedImage passa_baixo (BufferedImage imagem, float a){
		
		BufferedImage imagem_auxiliar = new BufferedImage(imagem.getWidth()+2, imagem.getHeight()+2, BufferedImage.TYPE_INT_RGB);
		BufferedImage imagem_passa_baixo = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		float w = (9*a)-1;
		
		// inclui em uma imagem auxilar mais uma linha de "zeros" em todas as laterais
		for (int i = 1 ; i < imagem_auxiliar.getHeight()-1; i++) {
			for (int j = 1; j < imagem_auxiliar.getWidth()-1; j++) {
				
				imagem_auxiliar.setRGB(i, j, imagem.getRGB(i-1, j-1));
			}
		}
		//exibir = new Tela_Resultado(imagem_auxiliar, "Imagem Média");
		
		for (int y = 1; y < imagem_auxiliar.getHeight()-1; y++) {
			for (int x = 1; x < imagem_auxiliar.getWidth()-1; x++) {
				
				float passa_baixo = - imagem_auxiliar.getRGB(y-1, x-1) - imagem_auxiliar.getRGB(y-1, x) - imagem_auxiliar.getRGB(y-1, x+1) - imagem_auxiliar.getRGB(y, x+1) +(w * imagem_auxiliar.getRGB(y, x)) - imagem_auxiliar.getRGB(y+1, x+1) - imagem_auxiliar.getRGB(y+1, x) - imagem_auxiliar.getRGB(y, x-1)- imagem_auxiliar.getRGB(y+1, x-1);
				int passa_baixo_aux = Math.round(passa_baixo);				
				//imagem_auxiliar.setRGB(y, x, passa_alta);		
				imagem_passa_baixo.setRGB(y-1, x-1, passa_baixo_aux);	
				
			}
			System.out.println();
		}
		
		return imagem_passa_baixo;
	}
	
	public BufferedImage prewitt(BufferedImage imagem){
		
		BufferedImage imagem_auxiliar = new BufferedImage(imagem.getWidth()+2, imagem.getHeight()+2, BufferedImage.TYPE_INT_RGB);
		BufferedImage imagem_prewitt = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_RGB);
		
				
		// inclui em uma imagem auxilar mais uma linha de "zeros" em todas as laterais
		for (int i = 1 ; i < imagem_auxiliar.getHeight()-1; i++) {
			for (int j = 1; j < imagem_auxiliar.getWidth()-1; j++) {
				
				imagem_auxiliar.setRGB(i, j, imagem.getRGB(i-1, j-1));
			}
		}
		//exibir = new Tela_Resultado(imagem_auxiliar, "Imagem Média");
		
		for (int y = 1; y < imagem_auxiliar.getHeight()-1; y++) {
			for (int x = 1; x < imagem_auxiliar.getWidth()-1; x++) {
				
				int funcao1 = (imagem_auxiliar.getRGB(y+1, x-1) + imagem_auxiliar.getRGB(y+1, x) + imagem_auxiliar.getRGB(y+1, x+1)) - ( imagem_auxiliar.getRGB(y-1, x-1) + imagem_auxiliar.getRGB(y-1, x)+ imagem_auxiliar.getRGB(y-1, x+1));
				int funcao2 = (imagem_auxiliar.getRGB(y-1, x+1) + imagem_auxiliar.getRGB(y, x+1) + imagem_auxiliar.getRGB(y+1, x+1)) - ( imagem_auxiliar.getRGB(y-1, x-1) + imagem_auxiliar.getRGB(y, x-1) + imagem_auxiliar.getRGB(y+1, x-1));
				int prewitt = Math.abs(funcao1)+Math.abs(funcao2); 
								
				imagem_auxiliar.setRGB(y, x, prewitt);		
				imagem_prewitt.setRGB(y-1, x-1, prewitt);	
				
			}
			System.out.println();
		}
		
		return imagem_prewitt;
	}
	
	public BufferedImage sobel(BufferedImage imagem){
		
		BufferedImage imagem_auxiliar = new BufferedImage(imagem.getWidth()+2, imagem.getHeight()+2, BufferedImage.TYPE_INT_RGB);
		BufferedImage imagem_sobel = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_RGB);
		
				
		// inclui em uma imagem auxilar mais uma linha de "zeros" em todas as laterais
		for (int i = 1 ; i < imagem_auxiliar.getHeight()-1; i++) {
			for (int j = 1; j < imagem_auxiliar.getWidth()-1; j++) {
				
				imagem_auxiliar.setRGB(i, j, imagem.getRGB(i-1, j-1));
			}
		}
		//exibir = new Tela_Resultado(imagem_auxiliar, "Imagem Média");
		
		for (int y = 1; y < imagem_auxiliar.getHeight()-1; y++) {
			for (int x = 1; x < imagem_auxiliar.getWidth()-1; x++) {
				
				int funcao1 = (imagem_auxiliar.getRGB(y+1, x-1) + (2*imagem_auxiliar.getRGB(y+1, x)) + imagem_auxiliar.getRGB(y+1, x+1)) - ( imagem_auxiliar.getRGB(y-1, x-1) + (2*imagem_auxiliar.getRGB(y-1, x))+ imagem_auxiliar.getRGB(y-1, x+1));
				int funcao2 = (imagem_auxiliar.getRGB(y-1, x+1) + (2*imagem_auxiliar.getRGB(y, x+1)) + imagem_auxiliar.getRGB(y+1, x+1)) - ( imagem_auxiliar.getRGB(y-1, x-1) + (2*imagem_auxiliar.getRGB(y, x-1)) + imagem_auxiliar.getRGB(y+1, x-1));
				
				double sobel_aux = Math.pow(funcao1, 2.0) + Math.pow(funcao2, 2.0);
				int sobel = (int) Math.sqrt(sobel_aux);
								
				imagem_auxiliar.setRGB(y, x, sobel);		
				imagem_sobel.setRGB(y-1, x-1, sobel);	
				
			}
			System.out.println();
		}
		
		return imagem_sobel;
	}
}
