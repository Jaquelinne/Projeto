package view;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tela_Resultado {
	
	public Tela_Resultado(BufferedImage imagem, String titulo){
		
		JFrame j = new JFrame();
		j.setVisible(true);
		j.setSize(300, 300);
		j.setTitle(titulo);
		JPanel p = new JPanel();
		j.add(p);
		p.setSize(300, 300);
		JLabel l = new JLabel();
		p.add(l);
		l.setSize(300, 300);
		l.setIcon(new ImageIcon(imagem));
		
	}

}
