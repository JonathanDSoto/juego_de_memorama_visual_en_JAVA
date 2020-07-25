import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Login extends JPanel implements ActionListener{
		
	private JButton botonLogin; 
	private JButton botonRegistro;
	private JLabel  titulo;
	private JTextField nombre;
	private JPasswordField pwd;
	private JCheckBox jcb;
	private JRadioButton radio1,radio2;
	private ButtonGroup serviciosDisponibles;
	private JComboBox <String> ciudades;
	private Image background;
	private JButton fondo;
	private JLabel fondo2;
	private Carta botonFake;
	//private String[] elementos;
	
	public Login() {
		this.setLayout(null);
		//this.setLayout(new FlowLayout());
		//this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		//this.setLayout(new GridLayout());
		//this.setLayout(new BorderLayout()); 
		this.setVisible(true);
		
		botonFake = new Carta("s",0);
		botonFake.setText("Carta1");
		botonFake.setBounds(0, 0, 100, 100);
		//botonFake.addActionListener(new ActionListener());
		this.add(botonFake);
		
		titulo = new JLabel("Programa");
		titulo.setSize(100, 20);
		//titulo.setBounds(150, 0, 100, 20); 
		this.add(titulo,BorderLayout.CENTER);
		
		nombre = new JTextField("Example");
		nombre.setBounds(250, 0, 100, 20); 
		this.add(nombre);
		
		botonLogin = new JButton("Acceder"); 
		botonLogin.setBounds(50, 50, 150, 30);  
		botonLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String temporal = nombre.getText();
				temporal+=" xdDDD";
				nombre.setText(temporal);
				System.out.println("Hola");
				
			}
			
		});
		this.add(botonLogin);
		
		botonRegistro = new JButton("Regístrarme"); 
		botonRegistro.setBounds(200, 50, 150, 30);  
		botonRegistro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, nombre.getText()); 
			}
			
		});
		this.add(botonRegistro);
		
		pwd = new JPasswordField();
		pwd.setBounds(50, 100, 70, 40);
		this.add(pwd);
		
		jcb = new JCheckBox("peperoni");
		jcb.setBounds(200, 100, 100, 35);
		jcb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("hola");
				JCheckBox tm = (JCheckBox) arg0.getSource();
				System.out.println(tm.isSelected());
				tm.setText("Hola");
			}
			
		});
		this.add(jcb);
		
		radio1 = new JRadioButton("Desayuno");
		radio1.setBounds(50, 150, 100, 35);
		this.add(radio1);
		
		radio2 = new JRadioButton("Cena");
		radio2.setBounds(150, 150, 100, 35);
		this.add(radio2);
		
		serviciosDisponibles = new ButtonGroup();
		serviciosDisponibles.add(radio1);
		serviciosDisponibles.add(radio2);
		
		String[] elementos = {"La Paz","Los Cabos","Mazatlan","Durango"};
		ciudades = new JComboBox <String> (elementos);
		ciudades.setBounds(50, 200, 100, 20);
		ciudades.setSelectedIndex(3);
		this.add(ciudades);
		
		background = null;
		try {
			background = ImageIO.read(new File("src/img/coin.png"));
		} catch (IOException e1) { 
			e1.printStackTrace();
			System.out.println("Error");
		}
		
		fondo = new JButton(new ImageIcon(background));
		fondo.setBounds(50, 300, 100, 50);
		fondo.setEnabled(true);
		fondo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					background = ImageIO.read(new File("src/img/coin2.png"));
					fondo2.setIcon(new ImageIcon(background));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
			}
			
		});
		this.add(fondo);
		
		fondo2 = new JLabel(new ImageIcon(background));
		fondo2.setBounds(200, 300, 120, 120);
		this.add(fondo2);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) { 
		
		JButton btn = (JButton) arg0.getSource();
		
		System.out.println(btn.getText());
		JOptionPane.showMessageDialog(this, btn.getText()); 
	}

}
