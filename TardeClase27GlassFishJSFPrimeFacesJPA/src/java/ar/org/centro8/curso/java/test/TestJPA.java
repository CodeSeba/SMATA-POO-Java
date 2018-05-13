package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.entities.Alumno;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestJPA {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("JPAPU").createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Alumno alumno = new Alumno("Nicolas", "Leon", 21, 1);
		System.out.println(alumno);
		
        tx.begin();
        
		System.out.println("------ .persist() ------");
		em.persist(alumno);
        System.out.println(alumno);

        System.out.println("------ .find() ------");
		alumno = em.find(Alumno.class, 60);
        System.out.println(alumno);

        System.out.println("------ .update() ------");
		alumno = em.find(Alumno.class, 64);
		System.out.println(alumno);
		if (alumno != null) {
            alumno.setNombre("Karina");
            alumno.setApellido("Vazques");
        }
		System.out.println(em.find(Alumno.class, 64));

        System.out.println("------ .remove() ------");
		alumno = em.find(Alumno.class, 62);
        if (alumno != null) {
            em.remove(alumno);
        }
		System.out.println(em.find(Alumno.class, 62));

        tx.commit();

        System.out.println("------ .createNamedQuery('Alumno.findAll', Class) ------");
		em.createNamedQuery("Alumno.findAll",Alumno.class).getResultList().forEach(System.out::println);
        
		System.out.println("------ .createNamedQuery('Alumno.findByApellido', Class) ------");
		em.createNamedQuery("Alumno.findByApellido", Alumno.class)
                .setParameter("apellido", "Picapiedras")
                .getResultList()
                .forEach(System.out::println);

        try {
            // sleep se utilizo para ver las conexiones en la base de datos
			Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}