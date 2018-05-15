import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.time.LocalDateTime;
//import java.awt.*;


public class FormTest extends JFrame {
	
	private JLabel		lblHora;
	private JLabel		lblTitulo;
	private JTextField	txtHora;
	private FlowLayout	mainLayout = new FlowLayout();
	
	static private String nombreApp = "Programación de Hilos";
	
	public FormTest(String name) {
		super(name);
	}
	
	public void initComponents(Container pane) {
        JPanel reloj = new JPanel();
        reloj.setLayout(mainLayout);
        
        JPanel titulo = new JPanel();
        titulo.setLayout(mainLayout);
        
        lblTitulo = new JLabel();
        lblTitulo.setText(nombreApp);
        
        lblHora = new JLabel();
		lblHora.setText("Hora: ");
		
		txtHora = new JTextField();
		LocalDateTime ldt = LocalDateTime.now();
		txtHora.setText(ldt.getHour() + ":" + ldt.getMinute() + ":" + ldt.getSecond());
        
        reloj.add(lblHora);
        reloj.add(txtHora);
        titulo.add(lblTitulo);
        
        pane.add(titulo, BorderLayout.CENTER);
        pane.add(reloj, BorderLayout.SOUTH);
    }
	
	private static void mostrarVentana() {
        FormTest ventana = new FormTest(nombreApp);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.initComponents(ventana.getContentPane());
        ventana.pack();
        ventana.setLocationRelativeTo(null);	// Centrado al monitor
        ventana.setVisible(true);
	}
	
	public static void main(String[] args) {
		mostrarVentana();
	}
}
