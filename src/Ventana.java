import javax.swing.JFrame;

public class Ventana extends JFrame{

	public Ventana() { 
		this.setVisible(true);
		this.setSize(500, 526);
		this.setTitle("Mi ventana");
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.calculadora(); 
		//this.login();
		//this.gato();
		//this.ahorcado();
		this.memorama();
	}
	
	public void memorama()
	{
		Memorama m = new Memorama();
		this.add(m);
		this.validate();
	}
	
	public void calculadora()
	{
		Calculadora c = new Calculadora();
		
		this.add(c); 
		this.validate(); 
	}
	
	public void login() {
		Login l = new Login();
		this.add(l);
		this.validate();
	}
	
	public void gato()
	{
		Gato g = new Gato();
		this.add(g);
		this.validate();
	}
	
	public void ahorcado()
	{
		Ahorcado h = new Ahorcado();
		this.add(h);
		this.validate();
	}

}
