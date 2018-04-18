package ar.org.centro8.curso.java.repositories;

import ar.org.centro8.curso.java.entities.Inscripcion;
import javax.persistence.EntityManager;

public class InscripcionR<E> extends GenericR<E> implements I_InscripcionR {
	
	public InscripcionR(EntityManager em) {
		super(em, Inscripcion.class);
	}

	@Override
	public E getById(int id) {
		return null;
	}
	
}
