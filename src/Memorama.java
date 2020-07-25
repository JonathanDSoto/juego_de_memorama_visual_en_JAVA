import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Memorama extends JPanel implements ActionListener{
	
	ArrayList <Carta> cartas; 
	private JButton btn;
	private int turnos;
	private int[] cartasP;
	
	public Memorama() {
		this.setLayout(new GridLayout());
		this.setVisible(true);
		turnos = 0;
		cartasP = new int[2];
		
		cartas = new <Carta> ArrayList();
		String[] valores = {"perro","gato","caballo","perro","elefante","caballo","gato","elefante"};
		
		for (int i = 0; i < 8; i++) {
			
			Carta tmp = new Carta(valores[i],i);
			tmp.setText("a"); 
			tmp.addActionListener(this);
			this.add(tmp);
			cartas.add(tmp);
			
		} 
	}
	
	public void reset() {
		for (int i = 0; i < cartas.size(); i++) {
			if(cartas.get(i).getEstatus()) {
				cartas.get(i).setEstatus(false);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		Carta tmp = (Carta) arg0.getSource();
		if(tmp.getEstatus()==false) {
			cartasP[turnos] = tmp.getPos();
			turnos++;
			System.out.println(turnos);
		}
		if(turnos==2) {
			if( cartas.get(cartasP[0]).getValue() ==  cartas.get(cartasP[1]).getValue()) {
				
				cartas.get(cartasP[0]).setEnabled(false);
		        cartas.get(cartasP[1]).setEnabled(false);
		        
		        turnos = 0;
				
			}else {
				String[] options = {"Ok"}; 
		        int x = JOptionPane.showOptionDialog(null, "No son pares",
		                "Click a button",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		        
		        if(x==0) {
		        	cartas.get(cartasP[1]).setEstatus(false);
		        	cartas.get(cartasP[0]).setEstatus(false);  
		        } 
		        turnos = 0; 
			}
		}
	}

}
