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
	private AlumnoR ar;
	private String param;

	public AlumnoMB() {
		em = Persistence.createEntityManagerFactory("JPAPU").createEntityManager();
		ar = new AlumnoR(em);
		alumno = new Alumno();
		param = "";
	}
	
	public void save() {
		ar.save(alumno);
		FacesContext
				.getCurrentInstance()
				.addMessage(null,
						new FacesMessage(FacesMessage.FACES_MESSAGES,
						"Se dio de alta un alumno id " + alumno.getId())
						);
		alumno = new Alumno();
	}
	
	public void remove() {
		ar.remove(ar.getById(alumno.getId()));
		FacesContext
				.getCurrentInstance()
				.addMessage(null,
						new FacesMessage(FacesMessage.FACES_MESSAGES,
						"Se dio de baja el alumno id " + alumno.getId())
						);
		alumno = new Alumno();
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
		if (param.isEmpty()) return ar.getAll();
		return ar.getLikeApellido(param);
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
	
	
}
