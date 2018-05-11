package ar.org.centro8.curso.java.beans;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.repositories.AlumnoR;
import java.io.Serializable;
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
	private AlumnoR ar;

	public AlumnoMB() {
		em = Persistence.createEntityManagerFactory("JPAPU").createEntityManager();
		ar = new AlumnoR(em);
		alumno = new Alumno();
	}
	
	public void save() {
		System.out.println("-------------------------------------------------");
		System.out.println(alumno);
		System.out.println("-------------------------------------------------");
		ar.save(alumno);
		System.out.println("-------------------------------------------------");
		System.out.println(alumno);
		System.out.println("-------------------------------------------------");
		FacesContext
				.getCurrentInstance()
				.addMessage(null,
						new FacesMessage(FacesMessage.FACES_MESSAGES,
						"Se dio de alta un alumno id " + alumno.getId())
						);
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
}
