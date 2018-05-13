package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.repositories.CursoR;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class TestCursoR {
    
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("JPAPU").createEntityManager();
        CursoR cr = new CursoR(em);
		
        System.out.println("------ .getAlumnos(curso) .getById() ------");
		Curso curso = (Curso)cr.getById(2);
		cr.getAlumnos(curso).forEach(System.out::println);
		
		System.out.println("------ .getByTurno() ------");
		cr.getByTurno("tarde").forEach(System.out::println);
    }
}
