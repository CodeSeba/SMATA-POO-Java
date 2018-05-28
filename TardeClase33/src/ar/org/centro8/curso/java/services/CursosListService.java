package ar.org.centro8.curso.java.services;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.repositories.GenericR;
import ar.org.centro8.curso.java.utils.Validator;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class CursosListService implements Runnable {

	private final int port = 8014;
	
	public boolean validar(String input) {
		if ( ! new Validator(input).isSecure()) return false;
		return true;
	}
	

	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(port);
			while (true) {
				System.out.println("Servicio Cursos List puerto: " + port);
				
				try(	Socket so = ss.accept();
						DataInputStream in = new DataInputStream(so.getInputStream());
						DataOutputStream out = new DataOutputStream(so.getOutputStream());
				) {
					
					System.out.println("Servicio Cursos List se conecto: " + so.getInetAddress());
					String input = in.readUTF();
					
					if ( validar(input) ) {
						GenericR<Curso> cr = new GenericR(Connector.getConnection(), Curso.class);
						if ( input.isEmpty() ) input = "1=1";
						List<Curso> lista = cr.getByFiltro(input);

						String texto = "";
						for (Curso c : lista) {
							texto +=	c.getId() + "," +
										c.getTitulo()+ "," +
										c.getProfesor()+ "," +
										c.getDia()+ "," +
										c.getTurno()+ "\n";
						}
						out.writeUTF(texto);
					}
					else {
						System.out.println("----------------------------------------");
						System.out.println("Servicio Cursos List reporta un error en input:");
						out.writeUTF("false");
						System.out.println("----------------------------------------");
					}
					
				} catch (Exception e) {
					System.out.println("----------------------------------------");
					System.out.println("Servicio Cursos List reporta un error:");
					System.out.println(e);
					System.out.println("----------------------------------------");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

