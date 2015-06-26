package modelo;

import java.awt.Color;
import java.awt.image.BufferedImage;

import view.Tela_Resultado;

public class Op_Matematicas {
	
	Tela_Resultado exibir;
	public Op_Matematicas(){
		
	}
	
	public BufferedImage soma(BufferedImage imagem1, BufferedImage imagem2){
		
		BufferedImage soma = new BufferedImage(imagem1.getHeight(), imagem1.getWidth(), BufferedImage.TYPE_INT_RGB);
		
		for (int y = 0; y < soma.getHeight(); y++) {
			for (int x = 0; x < soma.getWidth(); x++) {
				/*
				int valor1 = imagem1.getRGB(y, x);
				int valor2 = imagem2.getRGB(y, x);
				
				int soma_pixel = valor1 + valor2;
				
				soma.setRGB(y, x, soma_pixel);*/
				
				/*Pixel1 = bfi1.getRGB (i, j);  
                pixel2 = bfi2.getRGB (i, j);  
                Color1 color = new Color (Pixel1);  
                Color2 color = new Color (pixel2);  
  
                int red = (color1.getRed () + color2.getRed ())% 256 ;  
                int verde = (color1.getGreen () + color2.getGreen ())% 256 ;  
                int azul = (color1.getBlue () + color2.getBlue ())% 256 ;  
                  
                Cor color3 = new cores (vermelho, verde, azul);  
                bfi3.setRGB (i, j, color3.getRGB ());  */
				
				int valor1 = imagem1.getRGB(y, x);
				int valor2 = imagem2.getRGB(y, x);
				
				Color color1 = new Color (valor1);  
                Color color2 = new Color (valor2); 
                
                int red = (color1.getRed () + color2.getRed ())% 256 ;  
                int verde = (color1.getGreen () + color2.getGreen ())% 256 ;  
                int azul = (color1.getBlue () + color2.getBlue ())% 256 ; 
                
                Color cores = new Color (red, verde, azul);
                soma.setRGB(y, x, cores.getRGB());
			}
			
		}
		
		//exibir = new Tela_Resultado(soma, "Imagem Soma");
		return soma;
	}
	
	public BufferedImage subtracao(BufferedImage imagem1, BufferedImage imagem2){
		
		BufferedImage subtracao = new BufferedImage(imagem1.getHeight(), imagem1.getWidth(), BufferedImage.TYPE_INT_RGB);
		
		for (int y = 0; y < subtracao.getHeight(); y++) {
			for (int x = 0; x < subtracao.getWidth(); x++) {
				
				int valor1 = imagem1.getRGB(y, x);
				int valor2 = imagem2.getRGB(y, x);
				
				int subtracao_pixel = valor1 - valor2;
				
				subtracao.setRGB(y, x, subtracao_pixel);
				
			}
			
		}
		
		//exibir = new Tela_Resultado(subtracao, "Imagem Subtração");
		return subtracao;
	}
	
	public BufferedImage multiplicacao(BufferedImage imagem1, BufferedImage imagem2){
		
		BufferedImage multiplicacao = new BufferedImage(imagem1.getHeight(), imagem1.getWidth(), BufferedImage.TYPE_INT_RGB);
		
		for (int y = 0; y < multiplicacao.getHeight(); y++) {
			for (int x = 0; x < multiplicacao.getWidth(); x++) {
				
				int valor1 = imagem1.getRGB(y, x);
				int valor2 = imagem2.getRGB(y, x);
				
				int multiplicacao_pixel = valor1 * valor2;
				
				multiplicacao.setRGB(y, x, multiplicacao_pixel);
				
			}
			
		}
		
		//exibir = new Tela_Resultado(multiplicacao, "Imagem Multiplicação");
		return multiplicacao;
	}
	
	public BufferedImage divisao(BufferedImage imagem1, BufferedImage imagem2){
		
		BufferedImage divisao = new BufferedImage(imagem1.getHeight(), imagem1.getWidth(), BufferedImage.TYPE_BYTE_GRAY);
		
		for (int y = 0; y < divisao.getHeight(); y++) {
			for (int x = 0; x < divisao.getWidth(); x++) {
				
				int valor1 = imagem1.getRGB(y, x);
				int valor2 = imagem2.getRGB(y, x);
				
				int divisao_pixel = Math.round(valor1 / valor2);
				
				divisao.setRGB(y, x, divisao_pixel);
				
			/*	int valor1 = imagem1.getRGB(y, x);
				int valor2 = imagem2.getRGB(y, x);
				
				Color color1 = new Color (valor1);  
                Color color2 = new Color (valor2); 
                
                int red = (color1.getRed () / color2.getRed ()) ;  
                int verde = (color1.getGreen () / color2.getGreen ());  
                int azul = (color1.getBlue () / color2.getBlue ()); 
                
                Color cores = new Color (red, verde, azul);
                divisao.setRGB(y, x, cores.getRGB());*/
				
			}
			
		}
		
		//exibir = new Tela_Resultado(divisao, "Imagem Divisão");
		return divisao;
	}
}
