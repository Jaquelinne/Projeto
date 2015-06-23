package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.IconView;

import java.awt.Color;

import javax.swing.JButton;

import modelo.Efeitos;
import modelo.Imagem;

import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RGBImageFilter;
import java.awt.Font;

public class Tela extends JFrame {

	private JPanel painelPrincipal;
	File imagem1 = null;
	File imagem2 = null;
	BufferedImage im1 = null;
	BufferedImage im2 = null;
	
	Efeitos efeitos = new Efeitos();
	Imagem imag = new Imagem();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 609);
		
		JLabel lbl_resultado = new JLabel("");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenu mnEfeitos = new JMenu("Efeitos");
		menuBar.add(mnEfeitos);
		
		JMenuItem mntmNegativo = new JMenuItem("Negativo");
		mnEfeitos.add(mntmNegativo);
		mntmNegativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
							
				efeitos.Negativo(imag.getIm1());
							
			}
			
		});
		
		JMenuItem media = new JMenuItem("M\u00E9dia");
		mnEfeitos.add(media);
		
		JMenuItem mediana = new JMenuItem("Mediana");
		mnEfeitos.add(mediana);
		
		JMenuItem passa_alta = new JMenuItem("Passa alta");
		mnEfeitos.add(passa_alta);
		
		JMenuItem passa_baixa = new JMenuItem("Passa baixa");
		mnEfeitos.add(passa_baixa);
		
		JMenuItem prewitt = new JMenuItem("Prewitt");
		mnEfeitos.add(prewitt);
		
		JMenuItem sobel = new JMenuItem("Sobel");
		mnEfeitos.add(sobel);
		
		JMenuItem gradiente = new JMenuItem("Gradiente");
		mnEfeitos.add(gradiente);
		
		JMenuItem mntmGradienteCruzado = new JMenuItem("Gradiente Cruzado");
		mnEfeitos.add(mntmGradienteCruzado);
		
		JMenu mnOperaesMatemticas = new JMenu("Opera\u00E7\u00F5es Matem\u00E1ticas");
		menuBar.add(mnOperaesMatemticas);
		
		JMenuItem soma = new JMenuItem("Soma");
		mnOperaesMatemticas.add(soma);
		
		JMenuItem subtracao = new JMenuItem("Subtra\u00E7\u00E3o");
		mnOperaesMatemticas.add(subtracao);
		
		JMenuItem multiplicacao = new JMenuItem("Multiplica\u00E7\u00E3o");
		mnOperaesMatemticas.add(multiplicacao);
		
		JMenuItem mntmDiviso = new JMenuItem("Divis\u00E3o");
		mnOperaesMatemticas.add(mntmDiviso);
		
		JMenu mnOperaesLgicas = new JMenu("Opera\u00E7\u00F5es L\u00F3gicas");
		menuBar.add(mnOperaesLgicas);
		
		JMenuItem and = new JMenuItem("And");
		mnOperaesLgicas.add(and);
		
		JMenuItem or = new JMenuItem("Or");
		mnOperaesLgicas.add(or);
		
		JMenuItem xor = new JMenuItem("Xor");
		mnOperaesLgicas.add(xor);
		
		JMenu mnOperaesGeomtricas = new JMenu("Opera\u00E7\u00F5es Geom\u00E9tricas");
		menuBar.add(mnOperaesGeomtricas);
		
		JMenuItem escala_mais = new JMenuItem("Escala +");
		mnOperaesGeomtricas.add(escala_mais);
		
		JMenuItem escala_menos = new JMenuItem("Escala -");
		mnOperaesGeomtricas.add(escala_menos);
		
		JMenuItem rotacao_direita = new JMenuItem("Rota\u00E7\u00E3o \u00E0 direita");
		mnOperaesGeomtricas.add(rotacao_direita);
		
		JMenuItem rotacao_esquerda = new JMenuItem("Rota\u00E7\u00E3o \u00E0 Esquerda");
		mnOperaesGeomtricas.add(rotacao_esquerda);
		
		JMenuItem cisalhamento = new JMenuItem("Cisalhamento");
		mnOperaesGeomtricas.add(cisalhamento);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painel1 = new JPanel();
		painel1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		painel1.setBounds(42, 122, 303, 256);
		painelPrincipal.add(painel1);
		painel1.setLayout(null);
		
		JLabel lbl_imagem1 = new JLabel("");
		lbl_imagem1.setBackground(Color.WHITE);
		lbl_imagem1.setBounds(10, 11, 283, 234);
		painel1.add(lbl_imagem1);
		
		
		JButton btAbrirImagem1 = new JButton("Abrir Imagem");
		btAbrirImagem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser img = new JFileChooser(); // Recebe imagem
				
				// if para verificar se o arquivo selecionado veio do botão  Abrir imagem 1
				if (img.showOpenDialog(btAbrirImagem1) == JFileChooser.APPROVE_OPTION){
					
					imagem1 = img.getSelectedFile(); // Método para passar imagem que foi selecionada
					im1 = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
					//String caminho = imagem1.toString();
					//imagem1 = new File (caminho);
					//System.out.println(caminho);
					try{
						im1 = ImageIO.read(imagem1);
						System.out.println("ok");
						
					}catch(Exception e){
						System.out.println("Erro");
					}
					imag.setIm1(im1); //Guarda imagem
													
					lbl_imagem1.setIcon(new ImageIcon(imagem1.toString()));
					lbl_imagem1.setHorizontalAlignment(JLabel.CENTER);
				}
			}
		});
		btAbrirImagem1.setBounds(117, 403, 131, 33);
		painelPrincipal.add(btAbrirImagem1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(384, 122, 303, 256);
		painelPrincipal.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_imagem2 = new JLabel("");
		lbl_imagem2.setBounds(10, 11, 271, 234);
		panel.add(lbl_imagem2);
		
		
		JButton btAbrirImagem2 = new JButton("Abrir Imagem");
		btAbrirImagem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser img2 = new JFileChooser(); // Recebe imagem
				
				// if para verificar se o arquivo selecionado veio do botão  Abrir
				if (img2.showOpenDialog(btAbrirImagem2) == JFileChooser.APPROVE_OPTION){
					imagem2 = img2.getSelectedFile(); // Método para passar imagem que foi selecionada
					lbl_imagem2.setIcon(new ImageIcon(imagem2.toString()));
					lbl_imagem2.setHorizontalAlignment(JLabel.CENTER);
				}
			}
		});
		btAbrirImagem2.setBounds(481, 403, 131, 33);
		painelPrincipal.add(btAbrirImagem2);
		
		JPanel painel_Resultado = new JPanel();
		painel_Resultado.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		painel_Resultado.setBounds(729, 122, 303, 256);
		painelPrincipal.add(painel_Resultado);
		painel_Resultado.setLayout(null);
		
		//lbl_resultado = new JLabel("");
		lbl_resultado.setBounds(10, 11, 236, 234);
		painel_Resultado.add(lbl_resultado);
		
		
				
		JLabel lblNewLabel = new JLabel("Imagem Resultado");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(820, 405, 163, 24);
		painelPrincipal.add(lblNewLabel);
		
		
		
		
		
		
	}
}
