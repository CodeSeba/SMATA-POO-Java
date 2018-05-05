package ar.org.centro8.curso.java.entities;

public class Persona {
	private String saludo;
	private String nombre;
	private String apellido;

	public Persona() {}

	public Persona(String saludo, String nombre, String apellido) {
		this.saludo = saludo;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Persona{" + "saludo=" + saludo + ", nombre=" + nombre + ", apellido=" + apellido + '}';
	}

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
