package ar.org.centro8.curso.java.entities;

import java.util.Date;


public class Persona {
	private String nombre;
	private String apellido;
	private String estado;
	private Date fecha;


	public Persona() {}
	
	public Persona(String nombre, String apellido, String estado, Date fecha) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.estado = estado;
		this.fecha = fecha;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido
				+ ", estado=" + estado + ",fecha=" + fecha + '}';
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}