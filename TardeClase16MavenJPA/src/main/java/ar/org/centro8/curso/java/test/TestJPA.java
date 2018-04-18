package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.entities.Alumno;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class TestJPA {

    public static void main(String[] args) {
        
        EntityManager em = Persistence.createEntityManagerFactory("JPAPU").createEntityManager();
        Alumno alumno = new Alumno("Nicolas", "Leon", 21, 1);
        
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        
		System.out.println("------ .persist() ------");
        em.persist(alumno);
        System.out.println(alumno);
        
        System.out.println("------ .find() ------");
		alumno = em.find(Alumno.class, 58);
        System.out.println(alumno);
        
        System.out.println("------ update ? ------");
		if (alumno != null) {
            alumno.setNombre("Karina");
            alumno.setApellido("Vazques");
        }
		System.out.println(em.find(Alumno.class, 58));
        
		alumno = em.find(Alumno.class, 62);
        if (alumno != null) {
			System.out.println("------ .remove() ------");
			em.remove(alumno);
		}
        
        tx.commit();
        
        System.out.println("------ NamedQuery('Alumno.findAll', Class) ------");
		em.createNamedQuery("Alumno.findAll", Alumno.class)
                .getResultList().forEach(System.out::println);
        
        System.out.println("------ NamedQuery('Alumno.findByApellido', Class) ------");
        em.createNamedQuery("Alumno.findByApellido", Alumno.class).setParameter("apellido","Picapiedras")
                .getResultList().forEach(System.out::println);
    }
}
