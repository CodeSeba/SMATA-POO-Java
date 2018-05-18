import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.time.LocalDateTime;
import java.awt.event.*;

public class FormTest extends JFrame{
	
	private JLabel lblHora;
	private JTextField txtHora;
	private JLabel lblCrono;
	private JTextField txtCrono;
	private JButton btnStart;
	private JButton btnPause;
	private JButton btnReset;
	private JLabel lblMusic;
	private JButton btnMusicPlay;
	private JButton btnMusicPause;
	private JButton btnMusicStop;
	
	private HiloCrono hCrono;
	private HiloRepro hRepro;
	private Thread tCrono;
	private Thread tRepro;
	
	public FormTest(){
		initWindow();
		initComponents();
		initEvents();
		LocalDateTime ldt=LocalDateTime.now();
		//txtHora.setText(ldt.getHour()+":"+ldt.getMinute()+":"+ldt.getSecond());
		new Thread(new HiloHora(txtHora)).start();
		hCrono = new HiloCrono(txtCrono);
		tCrono = new Thread(hCrono);
		tCrono.start();
	}
	
	public static void main(String[] args){
		new FormTest().setVisible(true);
	}
	
	public void initEvents() {
		// Evento Start
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Apretó el Botón Start");
				hCrono.play();
			}
		});
		
		// Evento Pause
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Apretó el Botón Pause");
				hCrono.pause();	
			}
		});
		
		// Evento Reset
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Apretó el Botón Reset");
				hCrono.reset();
			}
		});
		
		// Evento MusicPlay
		btnMusicPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Apretó el Botón [Play]");
				if (tRepro == null || ! tRepro.isAlive()) {
					hRepro = new HiloRepro();
					tRepro = new Thread(hRepro);
					tRepro.start();
				}
				
				if (tRepro.isAlive()) {
					tRepro.resume();
				}
			}
		});
		
		// Evento MusicPause
		btnMusicPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Apretó el Botón [Pause]");
				if (tRepro != null && tRepro.isAlive()) {
					tRepro.suspend();
				}
			}
		});
		
		// Evento MusicStop
		btnMusicStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Apretó el Botón [Stop]");
				if (tRepro != null);
				tRepro.stop();
				tRepro = null;
			}
		});
	}
	
	public void initWindow() {
		this.setSize(400,350);
		//this.setBounds.();
		this.setTitle("Programación de hilos.");
		this.getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ventana.pack();
		//ventana.setLocationRelativeTo(null);	// Centrado al monitor
		//ventana.setVisible(true);
	}
	
	public void initComponents(){
		
		//lblHora
		lblHora=new JLabel();
		lblHora.setText("Hora: ");
		lblHora.setBounds(50,50,125,25);
		this.getContentPane().add(lblHora);
		
		//txtHora
		txtHora=new JTextField();
		txtHora.setBounds(150,50,125,25);
		this.getContentPane().add(txtHora);
		
		//lblCrono
		lblCrono = new JLabel();
		lblCrono.setText("Cronometro:");
		lblCrono.setBounds(50,100,125,25);
		this.getContentPane().add(lblCrono);
		
		//txtCrono
		txtCrono = new JTextField();
		txtCrono.setText("0");
		txtCrono.setBounds(150,100,125,25);
		this.getContentPane().add(txtCrono);
		
		//btnStart
		btnStart = new JButton();
		btnStart.setText("Start");
		btnStart.setBounds(50,150,90,25);
		this.getContentPane().add(btnStart);
		
		//btnPause
		btnPause = new JButton();
		btnPause.setText("Pause");
		btnPause.setBounds(150,150,90,25);
		this.getContentPane().add(btnPause);
		
		//btnReset
		btnReset = new JButton();
		btnReset.setText("Reset");
		btnReset.setBounds(250,150,90,25);
		this.getContentPane().add(btnReset);
		
		//lblMusica
		lblMusic = new JLabel();
		lblMusic.setText("Musica");
		lblMusic.setBounds(50,200,125,25);
		this.getContentPane().add(lblMusic);
		
		//btnMusicPlay
		btnMusicPlay = new JButton();
		btnMusicPlay.setText("[Play]");
		btnMusicPlay.setBounds(150,200,90,25);
		this.getContentPane().add(btnMusicPlay);
		
		//btnMusicPause
		btnMusicPause = new JButton();
		btnMusicPause.setText("[Pause]");
		btnMusicPause.setBounds(250,200,90,25);
		this.getContentPane().add(btnMusicPause);
		
		//btnMusicStop
		btnMusicStop = new JButton();
		btnMusicStop.setText("[Stop]");
		btnMusicStop.setBounds(250,250,90,25);
		this.getContentPane().add(btnMusicStop);
	}

}
