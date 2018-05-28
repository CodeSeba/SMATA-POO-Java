package ar.org.centro8.curso.java.services;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.repositories.GenericR;
import ar.org.centro8.curso.java.utils.Validator;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AlumnosAltasService implements Runnable {

	private final int port = 8001;
	
	public boolean validar(String[] params) {
		if ( ! new Validator(params[0]).isSecure() || ! new Validator(params[0]).length(2,20)) return false;
		if ( ! new Validator(params[1]).isSecure() || ! new Validator(params[1]).length(2,20)) return false;
		if ( ! new Validator(params[2]).isSecure() || ! new Validator(params[2]).isInteger(18,120)) return false;
		if ( ! new Validator(params[3]).isSecure() || ! new Validator(params[3]).isInteger()) return false;
		return true;
	}
	

	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(port);
			while (true) {
				System.out.println("Servicio Alumnos Alta puerto: " + port);
				
				try(	Socket so = ss.accept();
						DataInputStream in = new DataInputStream(so.getInputStream());
						DataOutputStream out = new DataOutputStream(so.getOutputStream());
				) {
					
					System.out.println("Servicio Alumnos Alta se conecto: " + so.getInetAddress());
					String input = in.readUTF();
					
					if ( ! new Validator(input).isSecure()) {
						out.writeUTF("0");
						break;
					}
					
					String[] params = input.split(",");
					
					if (params.length != 4) {
						out.writeUTF("0");
						break;
					}
					
					if (validar(params)) {
						String nombre = params[0];
						String apellido = params[1];
						int edad = Integer.parseInt(params[2]);
						int idCurso = Integer.parseInt(params[3]);
						
						GenericR<Alumno> ar = new GenericR(Connector.getConnection(), Alumno.class);
						Alumno alumno = new Alumno(nombre, apellido, edad, idCurso);
						ar.save(alumno);
						out.writeUTF(alumno.getId()+"");
					}
					else {
						System.out.println("----------------------------------------");
						System.out.println("Servicio Alumnos Altas reporta un error:");
						out.writeUTF("0");
						System.out.println("----------------------------------------");
					}
					
				} catch (Exception e) {
					System.out.println("----------------------------------------");
					System.out.println("Servicio Alumnos Altas reporta un error:");
					System.out.println(e);
					System.out.println("----------------------------------------");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

