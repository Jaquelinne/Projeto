package p_imagens;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class Tela extends JFrame {

	private JPanel painelPrincipal;
	File imagem1 = null;
	File imagem2 = null;
	
	//OperaçõesMatematicas om = new OperaçõesMatematicas();
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
		setBounds(100, 100, 1100, 700);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painel1 = new JPanel();
		painel1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		painel1.setBounds(45, 38, 303, 256);
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
				
				// if para verificar se o arquivo selecionado veio do botão  Abrir
				if (img.showOpenDialog(btAbrirImagem1) == JFileChooser.APPROVE_OPTION){
					imagem1 = img.getSelectedFile(); // Método para passar imagem que foi selecionada
					lbl_imagem1.setIcon(new ImageIcon(imagem1.toString()));
					lbl_imagem1.setHorizontalAlignment(JLabel.CENTER);
				}
			}
		});
		btAbrirImagem1.setBounds(133, 305, 131, 33);
		painelPrincipal.add(btAbrirImagem1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(45, 349, 303, 256);
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
		btAbrirImagem2.setBounds(133, 617, 131, 33);
		painelPrincipal.add(btAbrirImagem2);
		
		JPanel painel_Resultado = new JPanel();
		painel_Resultado.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		painel_Resultado.setBounds(717, 38, 256, 256);
		painelPrincipal.add(painel_Resultado);
		painel_Resultado.setLayout(null);
		
		JLabel lbl_resultado = new JLabel("");
		lbl_resultado.setBounds(10, 11, 236, 234);
		painel_Resultado.add(lbl_resultado);
		
		JLabel lblNewLabel = new JLabel("Imagem Resultado");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(783, 307, 163, 24);
		painelPrincipal.add(lblNewLabel);
		
		JComboBox box_opcoes = new JComboBox();
		box_opcoes.setModel(new DefaultComboBoxModel(new String[] {"Aplica\u00E7\u00F5es", "Soma", "Subtra\u00E7\u00E3o", "Multiplica\u00E7\u00E3o", "Divis\u00E3o", "Or", "And", "Xor"}));
		box_opcoes.setBounds(431, 117, 203, 24);
		painelPrincipal.add(box_opcoes);
		
		JButton bt_Operacao = new JButton("Aplicar Opera\u00E7\u00E3o");
		bt_Operacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (String.valueOf(box_opcoes.getSelectedItem())  == "Aplica\u00E7\u00F5es"){
					JOptionPane.showMessageDialog(null, "ok");
				}
				if (String.valueOf(box_opcoes.getSelectedItem())  == "Soma"){
					JOptionPane.showMessageDialog(null, "ok");
				//	BufferedImage imagemResultado = om.soma(imagem1, imagem2);
					//lbl_resultado.setIcon(new ImageIcon(imagemResultado.toString()));
					//lbl_resultado.setHorizontalAlignment(JLabel.CENTER);
					
				}
				if (String.valueOf(box_opcoes.getSelectedItem())  == "Subtra\u00E7\u00E3o"){
					JOptionPane.showMessageDialog(null, "ok");
				}
				if (String.valueOf(box_opcoes.getSelectedItem())  == "Multiplica\u00E7\u00E3o"){
					JOptionPane.showMessageDialog(null, "ok");
				}
				if (String.valueOf(box_opcoes.getSelectedItem())  == "Divis\u00E3o"){
					JOptionPane.showMessageDialog(null, "ok");
				}
				if (String.valueOf(box_opcoes.getSelectedItem())  == "Or"){
					JOptionPane.showMessageDialog(null, "ok");
				}
				if (String.valueOf(box_opcoes.getSelectedItem())  == "And"){
					JOptionPane.showMessageDialog(null, "ok");
				}
				if (String.valueOf(box_opcoes.getSelectedItem())  == "Xor"){
					JOptionPane.showMessageDialog(null, "ok");
				}
			}
		});
		bt_Operacao.setBounds(469, 191, 140, 23);
		painelPrincipal.add(bt_Operacao);
		
		
		
		
		
		
	}
}
