package modelo;

import java.awt.image.BufferedImage;

import view.Tela_Resultado;

public class Op_Matematicas {
	
	Tela_Resultado exibir;
	public Op_Matematicas(){
		
	}
	
	public void soma(BufferedImage imagem1, BufferedImage imagem2){
		
		BufferedImage soma = new BufferedImage(imagem1.getHeight(), imagem1.getWidth(), BufferedImage.TYPE_INT_RGB);
		
		for (int y = 0; y < soma.getHeight(); y++) {
			for (int x = 0; x < soma.getWidth(); x++) {
				
				int valor1 = imagem1.getRGB(y, x);
				int valor2 = imagem2.getRGB(y, x);
				
				int soma_pixel = valor1 + valor2;
				
				soma.setRGB(y, x, soma_pixel);
				
			}
			
		}
		
		exibir = new Tela_Resultado(soma, "Imagem Soma");
	}
	
	public void subtracao(BufferedImage imagem1, BufferedImage imagem2){
		
		BufferedImage subtracao = new BufferedImage(imagem1.getHeight(), imagem1.getWidth(), BufferedImage.TYPE_INT_RGB);
		
		for (int y = 0; y < subtracao.getHeight(); y++) {
			for (int x = 0; x < subtracao.getWidth(); x++) {
				
				int valor1 = imagem1.getRGB(y, x);
				int valor2 = imagem2.getRGB(y, x);
				
				int subtracao_pixel = valor1 - valor2;
				
				subtracao.setRGB(y, x, subtracao_pixel);
				
			}
			
		}
		
		exibir = new Tela_Resultado(subtracao, "Imagem Subtração");
	}
	
	public void multiplicacao(BufferedImage imagem1, BufferedImage imagem2){
		
		BufferedImage multiplicacao = new BufferedImage(imagem1.getHeight(), imagem1.getWidth(), BufferedImage.TYPE_INT_RGB);
		
		for (int y = 0; y < multiplicacao.getHeight(); y++) {
			for (int x = 0; x < multiplicacao.getWidth(); x++) {
				
				int valor1 = imagem1.getRGB(y, x);
				int valor2 = imagem2.getRGB(y, x);
				
				int multiplicacao_pixel = valor1 * valor2;
				
				multiplicacao.setRGB(y, x, multiplicacao_pixel);
				
			}
			
		}
		
		exibir = new Tela_Resultado(multiplicacao, "Imagem Multiplicação");
	}
	
	public void divisao(BufferedImage imagem1, BufferedImage imagem2){
		
		BufferedImage divisao = new BufferedImage(imagem1.getHeight(), imagem1.getWidth(), BufferedImage.TYPE_BYTE_GRAY);
		
		for (int y = 0; y < divisao.getHeight(); y++) {
			for (int x = 0; x < divisao.getWidth(); x++) {
				
				int valor1 = imagem1.getRGB(y, x);
				int valor2 = imagem2.getRGB(y, x);
				
				int divisao_pixel = Math.round(valor1 / valor2);
				
				divisao.setRGB(y, x, divisao_pixel);
				
			}
			
		}
		
		exibir = new Tela_Resultado(divisao, "Imagem Divisão");
	}
}
