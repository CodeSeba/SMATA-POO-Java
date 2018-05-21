package serializado;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TestSerializado {
	
	public static void main(String[] args) throws Exception {
		String archivo = "persona.dat";
		
		// Serializado de Objetos
		//ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo));
		//out.writeObject(new Persona("Ana", "Garcia", 23));
		//out.writeObject(new Persona("Mariano", "Orue", 34));
		//out.writeObject(new Persona("Cristal", "Fragil", 44));
		//out.close();
		
		// DeSerializado de Objetos
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo));
		Object obj;
		try {
			while ((obj = in.readObject()) != null ) {
				Persona p = (Persona)obj;
				System.out.println(p);
			}
		} catch (EOFException e) {
			System.out.println("Fin del archivo.");
		}
		in.close();
	}
}
