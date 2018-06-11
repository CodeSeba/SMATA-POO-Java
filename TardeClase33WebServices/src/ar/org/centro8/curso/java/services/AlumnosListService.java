package ar.org.centro8.curso.java.services;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.repositories.GenericR;
import ar.org.centro8.curso.java.utils.Validator;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class AlumnosListService implements Runnable {

	private final int port = 8005;
	
	public boolean validar(String input) {
		if ( ! new Validator(input).isSecure()) return false;
		return true;
	}
	

	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(port);
			while (true) {
				System.out.println("Servicio Alumnos List puerto: " + port);
				
				try(	Socket so = ss.accept();
						DataInputStream in = new DataInputStream(so.getInputStream());
						DataOutputStream out = new DataOutputStream(so.getOutputStream());
				) {
					
					System.out.println("Servicio Alumnos List se conecto: " + so.getInetAddress());
					String input = in.readUTF();
					
					if ( validar(input) ) {
						GenericR<Alumno> ar = new GenericR(Connector.getConnection(), Alumno.class);
						if ( input.isEmpty() ) input = "1=1";
						List<Alumno> lista = ar.getByFiltro(input);

						String texto = "";
						for (Alumno a : lista) {
							texto +=	a.getId() + "," +
										a.getNombre() + "," +
										a.getApellido() + "," +
										a.getEdad() + "," +
										a.getIdCurso() + "\n";
						}
						out.writeUTF(texto);
					}
					else {
						System.out.println("----------------------------------------");
						System.out.println("Servicio Alumnos List reporta un error en input:");
						out.writeUTF("false");
						System.out.println("----------------------------------------");
					}
					
				} catch (Exception e) {
					System.out.println("----------------------------------------");
					System.out.println("Servicio Alumnos List reporta un error:");
					System.out.println(e);
					System.out.println("----------------------------------------");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

