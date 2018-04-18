package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.hibernate.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestHibernate {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        Alumno alumno = new Alumno("Melina", "Loquetti", 23, 2);

        Transaction tx = session.beginTransaction();
        try {
            System.out.println("------ .save() ------");
			session.save(alumno);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        }
        System.out.println(alumno);

        // método get       lazy       peresozo
		System.out.println("------ .get(Class, id) lazy ------");
        alumno = (Alumno) session.get(Alumno.class, 2);
        System.out.println(alumno);

        // método load      eager       laborioso
		System.out.println("------ .get(Class, id) eager ------");
        alumno = (Alumno) session.load(Alumno.class, 3);
        //if(alumno!=null)
        //    System.out.println(alumno);

        tx = session.beginTransaction();
        try {
            System.out.println("------ .delete() ------");
			session.delete(alumno);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        }

        alumno = (Alumno) session.get(Alumno.class, 6);
        tx = session.beginTransaction();
        try {
			System.out.println("------ .update() ------");
            alumno.setNombre("Jose");
            alumno.setApellido("Miranda");
            session.update(alumno);
            tx.commit();
			System.out.println(alumno);
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        }

        //Query query=session.createQuery("from Alumno");
        //query.list().forEach(System.out::println);
		System.out.println("------ .createQuery() ALL ------");
        session.createQuery("from Alumno").list().forEach(System.out::println);
		
        System.out.println("------ .createQuery() nombre='Jose' ------");
        session.createQuery("from Alumno where nombre='Jose'").list().forEach(System.out::println);

        System.out.println("------ .createQuery().list().forEach() ALL ------");
		List<Alumno> lista = session.createQuery("from Alumno").list();
        lista.forEach(System.out::println);

        session.close();
        sf.close();
    }
}
