import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Carta extends JButton implements ActionListener{
	  
	private boolean estado;
	private Image back;
	private Image front;
	private String valor;
	private int pos;
	
	public Carta(String v,int p) { 
		this.addActionListener(this);
		//this.estado = false;
		this.setEstatus(false);
		this.valor = v;
		this.pos = p;
		
	}
	
	public void setEstatus(boolean estado)
	{
		this.estado = estado;
		if(estado)
		{
			try {
				front = ImageIO.read(new File("src/cards/front.jpg"));
				this.setIcon(new ImageIcon(front));
			} catch (IOException e) { 
				e.printStackTrace();
			}
			
		}else {
			try {
				back = ImageIO.read(new File("src/cards/back.png"));
				this.setIcon(new ImageIcon(back));
			} catch (IOException e) { 
				e.printStackTrace();
			}
		}
	}
	
	public int getPos()
	{
		return this.pos;
	}
	
	public boolean getEstatus()
	{
		return this.estado;
	}
	
	public String getValue()
	{
		return this.valor;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.setEstatus(true);
		System.out.println(this.valor); 
	}

}
