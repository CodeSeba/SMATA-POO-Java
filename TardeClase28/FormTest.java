import javax.swing.*;
import java.awt.FlowLayout;
import java.util.Date;
import java.time.LocalDateTime;

public class FormTest extends JFrame {
	
	public FormTest() {
		initComponents();
		LocalDateTime ldt = LocalDateTime.now();
		txtHora.setText(ldt.getHour() + ":" + ldt.getMinute() + ":" + ldt.getSecond());
	}
	
	public static void main(String[] args) {
		new FormTest().setVisible(true);
	}
	
	public void initComponents() {
		this.setSize(400,300);
		this.setTitle("Programación de Hilos");
		this.getContentPane().setLayout(new FlowLayout());
		
		lblHora = new JLabel();
		lblHora.setText("Hora: ");
		this.getContentPane().add(lblHora);
		
		txtHora = new JTextField();
		this.getContentPane().add(txtHora);
	}
	
	private JLabel lblHora;
	private JTextField txtHora;
}
