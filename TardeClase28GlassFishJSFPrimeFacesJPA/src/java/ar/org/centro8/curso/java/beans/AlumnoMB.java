package ar.org.centro8.curso.java.beans;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.repositories.AlumnoR;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@Named()
@SessionScoped
public class AlumnoMB implements Serializable {

	private EntityManager em;
	private Alumno alumno;
	private AlumnoR<Alumno> ar;
	private String buscarApellido;
	private String alumnoEdad;

	public AlumnoMB() {
		em = Persistence.createEntityManagerFactory("JPAPU").createEntityManager();
		ar = new AlumnoR(em);
		alumno = new Alumno();
		buscarApellido = "";
		alumnoEdad = "";
	}

	public void save() {
		ar.save(alumno);
		FacesContext
				.getCurrentInstance()
				.addMessage(null,
						new FacesMessage("Agregado",
								"Alta de alumno con id: " + alumno.getId())
				);
		alumno = new Alumno();
	}

	public void remove() {
		ar.remove(ar.getById(alumno.getId()));
		FacesContext
				.getCurrentInstance()
				.addMessage(null,
						new FacesMessage("Removido",
								"Baja de alumno con id: " + alumno.getId())
				);
		alumno = new Alumno();
	}
	
	public void cargar() {
		alumno = ar.getById(alumno.getId());
	}
	
	public void update() {
		ar.update(alumno);
		FacesContext
				.getCurrentInstance()
				.addMessage(null,
						new FacesMessage("Modificado",
								"Modificado el alumno con id: " + alumno.getId()));
		// Arreglar Edad antes de colocar new Alumno()
		//alumno = new Alumno();
	}
	

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public AlumnoR getAr() {
		return ar;
	}

	public void setAr(AlumnoR ar) {
		this.ar = ar;
	}

	public List<Alumno> getAll() {
		return ar.getAll();
	}

	public List<Alumno> getLikeApellido() {
		if (buscarApellido.isEmpty()) {
			return ar.getAll();
		}
		return ar.getLikeApellido(buscarApellido);
	}

	public String getBuscarApellido() {
		return buscarApellido;
	}

	public void setBuscarApellido(String param) {
		this.buscarApellido = param;
	}

	public String getAlumnoEdad() {
		alumnoEdad = ((alumno.getEdad() == 0) ? "" : String.valueOf(alumno.getEdad()));
		return alumnoEdad;
	}

	public void setAlumnoEdad(String edad) {
		if (edad.isEmpty() || edad == null) return;
		alumno.setEdad(Integer.parseInt(alumnoEdad));
	}
}
