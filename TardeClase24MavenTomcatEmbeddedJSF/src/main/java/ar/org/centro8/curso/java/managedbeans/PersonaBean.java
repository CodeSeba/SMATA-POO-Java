package ar.org.centro8.curso.java.managedbeans;

import ar.org.centro8.curso.java.entities.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PersonaBean {

	private Persona persona;
	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public PersonaBean() {
		this.persona = new Persona();
		mensaje = "";
	}

	public void crear() {
		System.out.println("------------------------------------------------");
		System.out.println(persona.getSaludo() + " " + persona.getNombre() + " " + persona.getApellido());
		System.out.println("------------------------------------------------");
		mensaje = "Se ingreso una persona!";
		persona = new Persona();
	}
	
	public List<Persona> getAll() {
		List<Persona> lista = new ArrayList();
		lista.add(new Persona("Sra", "Ana", "Gallardo"));
		lista.add(new Persona("Sra", "Malena", "Hernandez"));
		lista.add(new Persona("Sr", "Julio", "Quiroga"));
		lista.add(new Persona("Srta", "Andrea", "Moretti"));
		lista.add(new Persona("Lic", "Miguel", "Moreno"));
		return lista;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
