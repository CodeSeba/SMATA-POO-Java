package serializado;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerObject {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(9000);
		while (true) {
			try {
				System.out.println("Esperando conexión de cliente.");
				try (Socket so = ss.accept()) {
					System.out.println("Se conecto " + so.getInetAddress().getHostName());
					try (ObjectInputStream in = new ObjectInputStream(so.getInputStream());
							ObjectOutputStream out = new ObjectOutputStream(so.getOutputStream()))
					{
						try {
							Persona p = (Persona)in.readObject();
							System.out.println(p);
							out.writeUTF("Se recibio el objeto.\nBye Bye !!");
						} catch (Exception e) {
							out.writeUTF("Objeto Incorecto.");
							System.out.println("Problemas con la recepcion del objeto: " + e);
						}
					}				}
			} catch (Exception e) {
				System.out.println("Problemas con ServerSocket: " + e);
			}
		}
	}
}
