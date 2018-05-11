package ar.org.centro8.curso.java.beans;

import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.repositories.CursoR;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@Named()
@SessionScoped
public class CursoMB implements Serializable {
	EntityManager em;
	Curso curso;
	CursoR cr;

	public CursoMB() {
		em = Persistence.createEntityManagerFactory("JPAPU").createEntityManager();
		cr = new CursoR(em);
		curso = new Curso();
	}
	public List<Curso> getAll() {
		return cr.getAll();
	}
	
}
