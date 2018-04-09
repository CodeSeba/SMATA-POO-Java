package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.hibernate.util.HibernateUtil;
import ar.org.centro8.curso.java.repositories.AlumnoR;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestRepositories {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        AlumnoR ar = new AlumnoR(session);
        
        Alumno alumno = new Alumno("Micaela", "Morani", 22, 2);
        ar.save(alumno);
        ar.save(null);
        System.out.println(alumno);
        alumno = ar.getById(12);
        System.out.println(alumno);
        ar.remove(alumno);
        alumno = ar.getById(15);
        alumno.setNombre("Hernan");
        alumno.setApellido("Ledesma");
        ar.update(alumno);
        System.out.println(ar.getById(15));
        
        System.out.println("--- ar.getAll() ---");
        
        ar.getAll().forEach(System.out::println);
        
        System.out.println("--- ar.getByApellido() ---");
        
        ar.getByApellido("Miranda");
        
        System.out.println("--- ar.getLikeApellido() ---");
        ar.getLikeApellido("Lo").forEach(System.out::println);
        
        session.close();
        sf.close();
    }
}
