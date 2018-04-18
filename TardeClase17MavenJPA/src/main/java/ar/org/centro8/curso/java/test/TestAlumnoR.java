package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.repositories.AlumnoR;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class TestAlumnoR {
    
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("JPAPU").createEntityManager();
        AlumnoR ar = new AlumnoR(em);
        
        ar.getLikeApellido("ani").forEach(System.out::println);
        //ar.getAll().forEach(System.out::println);
        //ar.getByNombreApellido("Nicolas", "Leon").forEach(System.out::println);
        //ar.getByCurso(2).forEach(System.out::println);
    }
}
