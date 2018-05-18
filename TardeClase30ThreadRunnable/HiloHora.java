import javax.swing.JTextField;
import java.time.LocalDateTime;

public class HiloHora implements Runnable {
	private JTextField txt;
	
	public HiloHora(JTextField txt) {
		this.txt = txt;
	}
	
	@Override
	public void run() {
		while (true) {
			LocalDateTime ldt = LocalDateTime.now();
			txt.setText(ldt.getHour()+":"+ldt.getMinute()+":"+ldt.getSecond());
			try { Thread.sleep(1000); } catch(Exception e) { }
		}
	}
}
