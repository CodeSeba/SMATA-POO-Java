package ar.org.centro8.curso.java.repositories;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.entities.Inscripcion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class AlumnoR<E> extends GenericR<E> implements I_AlumnoR {

	public AlumnoR(EntityManager em) {
		super(em, Alumno.class);
	}

	@Override
	public List<Alumno> getByApellido(String apellido) {
		return em.createNamedQuery("Alumno.findByApellido")
				.setParameter("apellido", apellido).getResultList();
	}

	@Override
	public List<Alumno> getLikeApellido(String apellido) {
		return em.createQuery("SELECT a FROM Alumno a WHERE a.apellido like :apellido")
				.setParameter("apellido", "%" + apellido + "%").getResultList();
	}

	@Override
	public List<Alumno> getByNombreApellido(String nombre, String apellido) {
		return em.createQuery("SELECT a FROM Alumno a where a.nombre= :nombre and a.apellido= :apellido")
				.setParameter("nombre", nombre)
				.setParameter("apellido", apellido)
				.getResultList();
	}

	@Override
	public List<Curso> getCursos(int idAlumno) {
		List<Curso> listaCurso = new ArrayList();
		em.createNamedQuery("Inscripcion.findByIdAlumno")
				.setParameter("idAlumno", idAlumno)
				.getResultList()
				.forEach(item -> {
					listaCurso.add( em.find(Curso.class,
						((Inscripcion) item).getInscripcionPK().getIdCurso()));
				});
		return listaCurso;
	}

	@Override
	public List<Curso> getCursos(Alumno alumno) {
		return getCursos(alumno.getId());
	}
}
