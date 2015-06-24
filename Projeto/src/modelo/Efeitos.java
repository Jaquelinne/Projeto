package modelo;

import java.awt.image.BufferedImage;
import java.lang.reflect.Array;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.Tela_Resultado;

public class Efeitos {
	
	Tela_Resultado exibir;
	public Efeitos(){
		
	}
	
	public void Negativo (BufferedImage imagem){
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
		exibir = new Tela_Resultado(imagem_negativa, "Imagem Negativa");
				
	}

	private int geraNivelCinza(int valor) {
		// TODO Auto-generated method stub
		return valor | valor << 8 | valor << 16; // Faz deslocamento de bits
	}
	
	public void media (BufferedImage imagem, int mascarar){
		
		BufferedImage imagem_media = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		float[][] mascara = new float [3][3];
		for (int i = 0; i < mascara.length; i++) {
			for (int j = 0; j < mascara.length; j++) {
				mascara [i][j] = 1 / 9;
			}
		}
		
		for (int y = 0; y < imagem.getHeight(); y++) {
			for (int x = 0; x < imagem.getWidth(); x++) {
				
				int media = ((1/9) * imagem.getRGB(y-1, x-1)) + ((1/9) * imagem.getRGB(y-1, x)) + ((1/9) *imagem.getRGB(y-1, x+1)) +((1/9) * imagem.getRGB(y, x+1))
						+ ((1/9) *imagem.getRGB(y, x)) +((1/9) * imagem.getRGB(y+1, x+1)) + ((1/9) *imagem.getRGB(y+1, x)) + ((1/9) *imagem.getRGB(y, x-1))+((1/9) * imagem.getRGB(y+1, x-1));
				
				media = Math.round(media);		
					
				imagem_media.setRGB(y, x, media);	
				
			}
			
		}
		
		exibir = new Tela_Resultado(imagem_media, "Imagem Média");
	}

}
