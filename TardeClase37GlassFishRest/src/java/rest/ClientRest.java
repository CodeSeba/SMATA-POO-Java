package rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ClientRest {
	
	public static void main(String[] args) throws Exception{
		int nro1 = 32;
		int nro2 = 24;
		String url = "http://localhost:8080/TardeClase35GlassFishRest/webResources/test/suma?nro1=%d&nro2=%d";
		String url2 = String.format(url, nro1, nro2);
		URL url3 = new URL(url2);
		try(
				BufferedReader in = new BufferedReader(new InputStreamReader(url3.openStream()));
		){
			in.lines().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
