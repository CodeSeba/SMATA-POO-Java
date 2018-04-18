package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.repositories.GenericR;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class TestGeneric {

	public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("JPAPU").createEntityManager();
        GenericR<Alumno> ar = new GenericR(em,Alumno.class);

		System.out.println("------ .save() ------");
        Alumno alumno = new Alumno("Jorge","Lisan",23,2);
        ar.save(alumno);
        System.out.println(alumno);
		
		System.out.println("------ .remove() ------");
        ar.remove(ar.getById(100));
		System.out.println(ar.getById(100));
		
		System.out.println("------ .update() ------");
		alumno = ar.getById(112);
		System.out.println(alumno);
        if(alumno != null){
            alumno.setNombre("Lorena");
            alumno.setApellido("Braca");
            ar.update(alumno);
        }
		System.out.println(ar.getById(112));
        
        System.out.println("------ .getAll() ------");
		ar.getAll().forEach(System.out::println);
	}
}