package ar.org.centro8.curso.java.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/*
 * Java 5, 6, 7, 8 son LTS
 *
 * LTS: Long Time Support, tiene 8 años de soporte
 * Java 8 fue lanzado el 18/03/2014 tiene soporte hasta el 18/03/2022
 * 
 * A partir de java 9 Oracle lanza una version nueva de java cada
 * 6 meses, SIN SOPORTE LTS.
 * Oracle lanza una version LTS cada 18 meses.
 *
 * java  9 fue liberado en 09/2017, no es LTS.
 * java 10 fue liberado en 03/2018, no es LTS.
 * java 11  se liberara en 09/2018, va a ser con soporte LTS hasta 2026.
 * 
*/

public class TestServices {
	
	public static void main(String[] args) {
		
		// Test Alta
		
//		try(	Socket so = new Socket("localhost",8001);
//				DataOutputStream out = new DataOutputStream(so.getOutputStream());
//				DataInputStream in = new DataInputStream(so.getInputStream());
//		){
//			out.writeUTF("Ana,Gomez,30,40");
//			System.out.println(in.readUTF());
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
		// Test Baja
		
//		try(	Socket so = new Socket("localhost",8002);
//				DataOutputStream out = new DataOutputStream(so.getOutputStream());
//				DataInputStream in = new DataInputStream(so.getInputStream());
//		){
//			out.writeUTF("27");
//			System.out.println(in.readUTF());
//		} catch (Exception e) {
//			System.out.println(e);
//		}

		// Test Get
		
		try(	Socket so = new Socket("localhost",8004);
				DataOutputStream out = new DataOutputStream(so.getOutputStream());
				DataInputStream in = new DataInputStream(so.getInputStream());
		){
			System.out.println("------ Get ------");
			out.writeUTF("14");
			System.out.println(in.readUTF());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Test Modificacion
		
		try(	Socket soget = new Socket("localhost",8004);
				DataOutputStream outget = new DataOutputStream(soget.getOutputStream());
				DataInputStream inget = new DataInputStream(soget.getInputStream());
				
				Socket somod = new Socket("localhost",8003);
				DataOutputStream outmod = new DataOutputStream(somod.getOutputStream());
				DataInputStream inmod = new DataInputStream(somod.getInputStream());
		){
			System.out.println("------ Get antes de Modificacion ------");
			outget.writeUTF("14");
			String alumnoget = inget.readUTF();
			System.out.println(alumnoget);
			
			System.out.println("------ Despues de Modificacion ------");
			String[] params = alumnoget.split(",");
			outmod.writeUTF(params[0] + ",Cosme,Fulanito,41,3");
			System.out.println(inmod.readUTF());
			outget.writeUTF("14");
			System.out.println(inget.readUTF());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
