package serializado;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientObject {
	
	public static void main(String[] args) {
		try (	Socket so = new Socket("172.16.11.1", 9000);
				ObjectOutputStream out = new ObjectOutputStream(so.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(so.getInputStream())
			)
		{
			out.writeObject(new Persona("Sebastian", "Barberan", 123));
			System.out.println(in.readUTF());

		} catch (IOException ex) {
			System.out.println(ex);
		}
		
	}
}
