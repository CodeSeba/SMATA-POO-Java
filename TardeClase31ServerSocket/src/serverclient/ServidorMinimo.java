package serverclient;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class ServidorMinimo {

	public static void main(String[] args) throws Exception {
		//String mensaje = "Hola soy Sebas";
		
		//String mensaje = "<!DOCTYPE html>"
		//		+ "<html><head></head><body>"
		//		+ "<h1>Hola soy Sebas</h1>"
		//		+ "</body></html>";
		
		String mensaje = "";
		
		for ( Map.Entry<Object,Object> entry : System.getProperties().entrySet())
			mensaje += entry.getKey() + " : " + entry.getValue() + "\n";
		
		for ( Map.Entry<String,String> entry : System.getenv().entrySet())
			mensaje += entry.getKey() + " : " + entry.getValue() + "\n";
		
		mensaje = "HTTP/1.0 200 OK\n"
				+ "Content-Type : text/HTML\n"
				+ "Content-Length : " + mensaje.length() + "\n\n"
				+ mensaje;
		
		ServerSocket ss = new ServerSocket(4000);
		while (true) {
			System.out.println("||||||||||||||||||||||||||||||");
			System.out.println("Esperando conexión de cliente.");
			Socket so = ss.accept();
			
			System.out.println("Se conecto " + so.getInetAddress());
			OutputStream out = so.getOutputStream();
			out.write(mensaje.getBytes());
			out.close();
			so.close();
			
			System.out.println("Se desconecto el cliente.");
			System.out.println("||||||||||||||||||||||||||||||");
		}
	}
}
