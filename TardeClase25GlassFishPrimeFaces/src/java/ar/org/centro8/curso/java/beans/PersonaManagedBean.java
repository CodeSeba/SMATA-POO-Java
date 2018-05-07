package ar.org.centro8.curso.java.beans;

import ar.org.centro8.curso.java.entities.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named()
@SessionScoped
public class PersonaManagedBean implements Serializable{
	private Persona persona;
	private String mensaje;

	public PersonaManagedBean() {
		persona = new Persona();
		mensaje = "";
	}
	
	public List<Persona> getAll() {
		List<Persona> lista = new ArrayList();
		lista.add(new Persona("Ana", "Garcia", "Soltera", new Date()));
		lista.add(new Persona("Ana", "Garcia", "Soltera", new Date()));
		lista.add(new Persona("Ana", "Garcia", "Soltera", new Date()));
		lista.add(new Persona("Ana", "Garcia", "Soltera", new Date()));
		lista.add(new Persona("Ana", "Garcia", "Soltera", new Date()));
		lista.add(new Persona("Ana", "Garcia", "Soltera", new Date()));
		return lista;
	}
	

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public void guardar() {
		System.out.println("-------------------------------------------------");
		System.out.println(persona);
		System.out.println("-------------------------------------------------");
		mensaje = "Se dio de alta una persona.";
	}
}