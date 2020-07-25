import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ahorcado extends JPanel implements ActionListener{
	
	private Image monito; 
	private JLabel fondo;
	private int intentos;
	
	private JTextField campo;
	private JButton boton1;
	private char letra; 
	
	private JLabel etiqueta;
	
	public Ahorcado() {
		this.setLayout(null);
		this.setVisible(true);
		
		intentos = 1;
		char[] palabra = {'t','a','n','g','a','m','a','n','d','a','p','i','o'};
		char[] palabraCp = {'_','_','_','_','_','m','_','_','_','_','_','_','_'};
		
		fondo = new JLabel();
		fondo.setBounds(50, 30, 400, 370);
		this.add(fondo);
		
		try {
			monito = ImageIO.read(new File("src/estados/1.jpg"));
			fondo.setIcon(new ImageIcon(monito));
		} catch (IOException e) { 
			e.printStackTrace();
		}
		
		campo = new JTextField();
		campo.setBounds(50, 450, 200, 30);
		this.add(campo);
		
		boton1 = new JButton("Buscar");
		boton1.setBounds(270, 450, 100, 30);
		boton1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean error = true;
				
				letra =  campo.getText().charAt(0);
				campo.setText("");
				for (int i = 0; i < palabra.length; i++) {
					if(palabra[i] == letra ) {
						palabraCp[i] = letra;
						error = false;
					}
				}
				
				if(error) {
					intentos++;
					if(intentos<=8) {
						try {
							monito = ImageIO.read(new File("src/estados/"+intentos+".jpg"));
							fondo.setIcon(new ImageIcon(monito));
						} catch (IOException e) { 
							e.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Ha perdido el juego");
						boton1.setEnabled(false);
					}
					
				}
				
				etiqueta.setText(Arrays.toString(palabraCp));
				
				boolean win = true;
				for (int j = 0; j < palabraCp.length; j++) {
					if(palabra[j] != palabraCp[j]) {
						win = false;
					}
				}
				if(win) {
					JOptionPane.showMessageDialog(null, "Ha ganado el juego");
					boton1.setEnabled(false);
				}
			} 
		});
		this.add(boton1);
		
		etiqueta = new JLabel(Arrays.toString(palabraCp));
		etiqueta.setBounds(150, 410, 200, 30);
		this.add(etiqueta);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
