package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.hibernate.util.HibernateUtil;
import ar.org.centro8.curso.java.repositories.AlumnoR;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestRepository {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		AlumnoR ar = new AlumnoR(session);

		Alumno alumno = new Alumno("Micaela", "Morani", 22, 2);
		
		System.out.println("------ .save() ------");
		ar.save(alumno);
		System.out.println(alumno);
		
		System.out.println("------ .save(null) ------");
		ar.save(null);
		
		System.out.println("------ .getById() ------");
		alumno = ar.getById(12);
		System.out.println(alumno);
		
		if (alumno != null) {
			System.out.println("------ .remove() ------");
			ar.remove(alumno);
		}
		
		alumno = ar.getById(15);
		if (alumno != null) {
			System.out.println("------ .update() ------");
			alumno.setNombre("Hernan");
			alumno.setApellido("Ledesma");
			ar.update(alumno);
		}
		System.out.println(ar.getById(15));

		System.out.println("------ .getAll() ------");
		ar.getAll().forEach(System.out::println);

		System.out.println("------ .getByApellido() ------");
		ar.getByApellido("Miranda").forEach(System.out::println);

		System.out.println("------ .getLikeApellido() ------");
		ar.getLikeApellido("Lo").forEach(System.out::println);

		session.close();
		sf.close();
	}
}
