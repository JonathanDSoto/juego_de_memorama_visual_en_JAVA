import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora extends JPanel implements ActionListener{
	
	ArrayList <JButton> botones; 
	
	private JButton btns;
	private JButton btnr;
	private JButton btne;
	
	private JTextField resultado;
	
	private int x,y;
	private int numUno,numDos;
	private boolean operacion;
	
	public Calculadora() {
		this.setLayout(null);
		this.setVisible(true);
		
		x=110;
		y=90;
		numUno = 0;
		numDos = 0;
		operacion = true;
		
		resultado = new JTextField();
		resultado.setBounds(100, 10, 250, 70);
		this.add(resultado);
		
		botones = new ArrayList();
		
		for (int i = 0; i < 10; i++) {
			JButton tmp = new JButton((i)+"");
			tmp.setBounds(x, y, 70, 50);
			tmp.addActionListener(new ActionListener() { 
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton btn = (JButton) e.getSource();  
					resultado.setText( resultado.getText()+btn.getText() );
				} 
			});
			this.add(tmp);
			botones.add(tmp);
			x+=80;
			if(x>270) {
				x= 110;
				y+=60;
			}
		}  
		
		btns = new JButton("+");
		btns.setBounds(x, y, 70, 50);
		btns.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				if(numUno == 0) {
					numUno = Integer.parseInt(resultado.getText());
				}
				resultado.setText("");
				operacion = true;
			} 
		});
		this.add(btns);
		
		x+=80;
		btnr = new JButton("-");
		btnr.setBounds(x, y, 70, 50);
		btnr.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				if(numUno == 0) {
					numUno = Integer.parseInt(resultado.getText());
				}
				resultado.setText("");
				operacion = false; 
			} 
		});
		this.add(btnr);
		
		x=100;
		y+=60;
		btne = new JButton("=");
		btne.setBounds(x, y, 250, 50);
		btne.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				numDos = Integer.parseInt(resultado.getText());
				
				if(operacion) {
					resultado.setText( (numUno+numDos) + "" );
				}else {
					resultado.setText( (numUno-numDos) + "" );
				}
				numUno = 0;
				numDos = 0;
			} 
		});
		this.add(btne);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
