package ar.org.centro8.curso.java.repositories;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
import java.util.List;
import javax.persistence.EntityManager;

public class CursoR<E> extends GenericR<E> implements I_CursoR{

	public CursoR(EntityManager em, Class clazz) {
		super(em, clazz);
	}

	@Override
	public List<Curso> getByTitulo(String titulo) {
		return em.createNamedQuery("Curso.findByTitulo")
				.setParameter("tiulo", titulo).getResultList();
	}

	@Override
	public List<Curso> getByLikeTitulo(String titulo) {
		return em.createQuery("SELECT c FROM Curso c WHERE c.titulo like :titulo")
				.setParameter("titulo", "%" + titulo + "%").getResultList();
	}

	@Override
	public List<Curso> getByProfesor(String profesor) {
		return em.createNamedQuery("Curso.findByProfesor")
				.setParameter("tiulo", profesor).getResultList();
	}

	@Override
	public List<Curso> getByLikeProfesor(String profesor) {
		return em.createQuery("SELECT c FROM Curso c WHERE c.titulo like :profesor")
				.setParameter("titulo", "%" + profesor + "%").getResultList();
	}

	@Override
	public List<Curso> getByDia(String dia) {
		return em.createNamedQuery("Curso.findByDia")
				.setParameter("tiulo", dia).getResultList();
	}

	@Override
	public List<Curso> getByTurno(String turno) {
		return em.createNamedQuery("Curso.findByTurno")
				.setParameter("tiulo", turno).getResultList();
	}

	@Override
	public List<Alumno> getAlumnos(Curso curso) {
		return getAlumnos(curso.getId());
	}

	@Override
	public List<Alumno> getAlumnos(int idCurso) {
		return em.createNamedQuery("Alumno.findByIdCurso")
				.setParameter("idCurso", idCurso).getResultList();
	}
    
}
