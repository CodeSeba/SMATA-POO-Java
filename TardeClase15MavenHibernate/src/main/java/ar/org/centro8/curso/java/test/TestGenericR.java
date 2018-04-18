package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.hibernate.util.HibernateUtil;
import ar.org.centro8.curso.java.repositories.GenericR;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestGenericR {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		GenericR<Alumno> ar = new GenericR(session, Alumno.class);

		Alumno alumno = new Alumno("Pedro", "Picapiedras", 33, 3);

		System.out.println("------ .save() ------");
		ar.save(alumno);
		System.out.println(alumno);

		System.out.println("------ .getById() ------");
		alumno = ar.getById(55);
		System.out.println(alumno);

		if (alumno != null) {
			System.out.println("------ .remove() ------");
			ar.remove(alumno);
		}

		alumno = ar.getById(45);
		if (alumno != null) {
			System.out.println("------ .update() ------");
			alumno.setNombre("Manuel");
			alumno.setApellido("Belgrano");
			ar.update(alumno);
			System.out.println(alumno);
		}

		System.out.println("------ .getAll() ------");
		ar.getAll().forEach(System.out::println);

		System.out.println("------ .getByFiltro() ------");
		ar.getByFiltro("nombre like '%nan%'").forEach(System.out::println);

		session.close();
		sf.close();
	}
}
