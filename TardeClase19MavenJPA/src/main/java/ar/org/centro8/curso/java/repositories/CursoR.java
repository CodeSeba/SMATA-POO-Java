package ar.org.centro8.curso.java.repositories;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.entities.Inscripcion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class CursoR<E> extends GenericR<E> implements I_CursoR{

	public CursoR(EntityManager em) {
		super(em, Curso.class);
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
				.setParameter("turno", turno).getResultList();
	}

	@Override
	public List<Alumno> getAlumnos(Curso curso) {
		return getAlumnos(curso.getId());
	}

	@Override
	public List<Alumno> getAlumnos(int idCurso) {
		List<Alumno> listaAlumno = new ArrayList();
		em.createNamedQuery("Inscripcion.findByIdCurso")
				.setParameter("idCurso", idCurso)
				.getResultList()
				.forEach(item -> {
					listaAlumno.add( em.find(Alumno.class,
						((Inscripcion)item).getInscripcionPK().getIdCurso()));
				});
		return listaAlumno;
	}
}
