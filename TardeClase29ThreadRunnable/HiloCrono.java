//import java.awt.*;
//import javax.swing.*;
import javax.swing.JTextField;
import java.time.LocalDateTime;

public class HiloCrono implements Runnable {
	private JTextField txt;
	private boolean correr = false;
	private int cont = 0;
	
	public HiloCrono(JTextField txt) {
		this.txt = txt;
		
	}
	
	@Override
	public void run() {
		while (true) {
			if (correr) {
				cont++;
				txt.setText(cont + "");
			}
			try { Thread.sleep(1000); } catch(Exception e) { }
		}
	}
	
	public void play()  { correr = true; }
	
	public void pause() {
		if (correr) correr = false;
		else correr = true;
	}
	
	public void reset()  {
		correr = false;
		cont = 0;
		txt.setText("0");
	}
}
