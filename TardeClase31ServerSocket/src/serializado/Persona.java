package serializado;

import java.io.Serializable;

public class Persona implements Serializable {

	private static transient final long serialVersionUID = -5530049966851006212L;
	// Serializable
	// Garantiza que se utilizara en un objeto Java
	
	private String nombre;
	private String apellido;
	private int edad;

	public Persona(String nombre, String apellido, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + '}';
	}
}
