package ar.org.centro8.curso.java.services;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.repositories.GenericR;
import ar.org.centro8.curso.java.utils.Validator;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AlumnosGetService implements Runnable {

	private final int port = 8004;
	
	public boolean validar(String input) {
		if ( ! new Validator(input).isSecure() || ! new Validator(input).isInteger()) return false;
		return true;
	}
	

	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(port);
			while (true) {
				System.out.println("Servicio Alumnos Get puerto: " + port + "\nEsperando conexión.");
				
				try(	Socket so = ss.accept();
						DataInputStream in = new DataInputStream(so.getInputStream());
						DataOutputStream out = new DataOutputStream(so.getOutputStream());
				) {
					
					System.out.println("Servicio Alumnos Get se conecto: " + so.getInetAddress());
					String input = in.readUTF();
					
					if ( validar(input) ) {
						GenericR<Alumno> ar = new GenericR(Connector.getConnection(), Alumno.class);
						Alumno alumno = ar.getById(Integer.parseInt(input));
						out.writeUTF(
								alumno.getId() + "," +
								alumno.getNombre()+ "," +
								alumno.getApellido()+ "," +
								alumno.getEdad()+ "," +
								alumno.getIdCurso()
						);
					}
					else {
						System.out.println("----------------------------------------");
						System.out.println("Servicio Alumnos Get reporta un error en input:");
						out.writeUTF("false");
						System.out.println("----------------------------------------");
					}
					
				} catch (Exception e) {
					System.out.println("----------------------------------------");
					System.out.println("Servicio Alumnos Get reporta un error:");
					System.out.println(e);
					System.out.println("----------------------------------------");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

