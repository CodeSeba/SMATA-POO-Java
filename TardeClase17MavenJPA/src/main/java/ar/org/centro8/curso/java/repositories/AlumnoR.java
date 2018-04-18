package ar.org.centro8.curso.java.repositories;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> getByCurso(int id) {
        return em.createNamedQuery("Alumno.findByIdCurso")
                .setParameter("idCurso", id).getResultList();
    }
    
        @Override
    public List<Alumno> getByCurso(Curso curso) {
        return getByCurso(curso.getId());
    }
}
