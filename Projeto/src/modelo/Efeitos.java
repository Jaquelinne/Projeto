package modelo;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Efeitos {
	
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
		JFrame j = new JFrame();
		j.setVisible(true);
		j.setSize(300, 300);
		j.setTitle("Imagem Negativo");
		JPanel p = new JPanel();
		j.add(p);
		p.setSize(300, 300);
		JLabel l = new JLabel();
		p.add(l);
		l.setSize(300, 300);
		l.setIcon(new ImageIcon(imagem_negativa));
		return imagem_negativa;
	}

	private int geraNivelCinza(int valor) {
		// TODO Auto-generated method stub
		return valor | valor << 8 | valor << 16; // Faz deslocamento de bits
	}

}
