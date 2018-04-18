package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.entities.Inscripcion;
import ar.org.centro8.curso.java.repositories.AlumnoR;
import ar.org.centro8.curso.java.repositories.CursoR;
import ar.org.centro8.curso.java.repositories.InscripcionR;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class TestRelaciones {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("JPAPU").createEntityManager();
		CursoR cr = new CursoR(em);
		
//		Se crea estos curso como ejemplo unas pocas veces, por eso se comenta.
//		cr.save(new Curso("Java", "Ríos", "Lunes", "Tarde"));
//		cr.save(new Curso("PHP", "Gomez", "Viernes", "Tarde"));
		
		AlumnoR ar = new AlumnoR(em);
//		ar.save(new Alumno("Juan", "Perez", 22));
//		ar.save(new Alumno("Laura", "Soto", 21));
//		ar.save(new Alumno("Andres", "Lopez", 23));
//		ar.save(new Alumno("Juana", "Molina", 24));
		
		InscripcionR ir = new InscripcionR(em);
		ir.save(new Inscripcion (
				((Curso)cr.getById(1)).getId(),
				((Alumno)ar.getById(4)).getId()
		));

		System.out.println("------ cr.getAll() ------");
		cr.getAll().forEach(System.out::println);
		
		System.out.println("------ ar.getAll() ------");
		ar.getAll().forEach(System.out::println);
		
		// Cuales son los alumnos del curso 1
		System.out.println("------ Cuales son los alumnos del curso 1 ------");
		cr.getAlumnos(1).forEach(System.out::println);
		
		// Cuales son los cursos del alumno 1
		System.out.println("------ Cuales son los cursos del alumno 1 ------");
		ar.getCursos(1).forEach(System.out::println);
	}
}
