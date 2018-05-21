package chat;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;

public class HiloChat implements Runnable {
	
	private JTextArea txa;

	public HiloChat(JTextArea txt) {
		this.txa = txt;
	}
	
	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(8000);
			while (true) {
				try {
					Socket so = ss.accept();
					String mensaje = "";
					String ip = so.getInetAddress().getHostAddress();
					for (String st : MapaDirecciones.getMapa().keySet() )
						if (MapaDirecciones.getMapa().get(st).equals(ip) )
							mensaje += st + ": ";
					if (mensaje.equals("")) mensaje += "Anonimus: ";
					
					InputStream in = so.getInputStream();
					int car;
					while ((car = in.read()) != -1) {
						mensaje += (char)car;
					}
					mensaje += "\n";
					txa.append(mensaje);
					in.close();
					so.close();
				} catch (Exception e) {
					System.out.println("Problemas con el Socket: " + e);
				}
				
			}
		} catch (Exception e) {
				System.out.println("Problemas con el ServerSocket: " + e);
		}
	}
}
