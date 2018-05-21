package serverclient;

import java.io.InputStream;
import java.net.Socket;

public class ClienteMinimo {
	
	public static void main(String[] args) throws Exception {
		Socket so = new Socket("172.16.11.1",4000);
		InputStream in = so.getInputStream();
		int car;
		while ( (car=in.read()) != -1 ) {
			System.out.print((char)car);
		}
		System.out.println();
		in.close();
		so.close();
	}
}
