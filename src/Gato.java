import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gato extends JPanel implements ActionListener{
	
	private int x,y;
	private int c;
	private boolean turno = true;
	ArrayList <JButton> botones; 
	
	public Gato() {
		this.setLayout(null);
		this.setVisible(true);
		
		x = 0;
		y = 0;
		c = 0;
		botones = new ArrayList();
		
		for (int i = 0; i < 9; i++) {
			
			JButton tmp = new JButton("");
			tmp.setBounds(x, y, 166, 166);
			tmp.addActionListener(new ActionListener() { 
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton btn = (JButton) e.getSource();   
					if(turno) {
						btn.setText("X");
						turno = false;
					}else{
						btn.setText("O");
						turno = true;
					}
					btn.setEnabled(false); 
					c++;
					verificar(c);
				}
			});
			this.add(tmp);
			botones.add(tmp);
			
			x+=160;
			if(x>=480) {
				x= 0;
				y+=160;
			}
		} 
		
	}

	
	public void verificar(int c)
	{
		boolean win = false;
		if( botones.get(0).getText() == botones.get(1).getText() &&
			botones.get(1).getText() == botones.get(2).getText() &&
			botones.get(0).getText() !="") {
			win = true;
			JOptionPane.showMessageDialog(null, "El ganador es: "+botones.get(0).getText()); 
		}
		
		if( botones.get(3).getText() == botones.get(4).getText() &&
				botones.get(4).getText() == botones.get(5).getText() &&
				botones.get(3).getText() !="") {
				win = true;
				JOptionPane.showMessageDialog(null, "El ganador es: "+botones.get(3).getText()); 
		}
		
		if( botones.get(6).getText() == botones.get(7).getText() &&
				botones.get(7).getText() == botones.get(8).getText() &&
				botones.get(6).getText() !="") {
				win = true;
				JOptionPane.showMessageDialog(null, "El ganador es: "+botones.get(6).getText()); 
		}
		
		if( botones.get(0).getText() == botones.get(3).getText() &&
				botones.get(3).getText() == botones.get(6).getText() &&
				botones.get(0).getText() !="") {
				win = true;
				JOptionPane.showMessageDialog(null, "El ganador es: "+botones.get(0).getText()); 
		}
		
		if( botones.get(1).getText() == botones.get(4).getText() &&
				botones.get(4).getText() == botones.get(7).getText() &&
				botones.get(1).getText() !="") {
				win = true;
				JOptionPane.showMessageDialog(null, "El ganador es: "+botones.get(1).getText()); 
		}
		
		if( botones.get(2).getText() == botones.get(5).getText() &&
				botones.get(5).getText() == botones.get(8).getText() &&
				botones.get(2).getText() !="") {
				win = true;
				JOptionPane.showMessageDialog(null, "El ganador es: "+botones.get(2).getText()); 
		}
		
		if( botones.get(0).getText() == botones.get(4).getText() &&
				botones.get(4).getText() == botones.get(8).getText() &&
				botones.get(0).getText() !="") {
				win = true;
				JOptionPane.showMessageDialog(null, "El ganador es: "+botones.get(0).getText()); 
		}
		
		if( botones.get(2).getText() == botones.get(4).getText() &&
				botones.get(4).getText() == botones.get(6).getText() &&
				botones.get(2).getText() !="") {
				win = true;
				JOptionPane.showMessageDialog(null, "El ganador es: "+botones.get(2).getText()); 
		}
		
		if(win) {
			for (int i = 0; i < botones.size(); i++) {
				botones.get(i).setEnabled(false);
			}
		}
		if(c==9 && win == false) {
			JOptionPane.showMessageDialog(null, "Empate"); 
		}
			
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub 
	}

}
