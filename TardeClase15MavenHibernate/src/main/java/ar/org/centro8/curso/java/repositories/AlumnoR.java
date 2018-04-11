package ar.org.centro8.curso.java.repositories;

import ar.org.centro8.curso.java.entities.Alumno;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AlumnoR {
    private Session session;

    public AlumnoR(Session session) {
        this.session = session;
    }
    
    public void save(Alumno alumno) {
        Transaction tx = session.beginTransaction();
        try {
            session.save(alumno);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        }
    }
    
    public void remove(Alumno alumno) {
        Transaction tx = session.beginTransaction();
        try {
            session.delete(alumno);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        }
    }
    
    public void update(Alumno alumno) {
        Transaction tx = session.beginTransaction();
        try {
            session.update(alumno);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        }
    }
    
    public Alumno getById(int id) {
        List<Alumno> lista = session.createQuery("from Alumno where id=" + id).list();
        if (lista.isEmpty()) return null;
        else return lista.get(0);
    }
    
    public List<Alumno> getAll() {
        return session.createQuery("from Alumno").list();
    }
    
    public List<Alumno> getByApellido(String apellido) {
        return session.createQuery("from Alumno where apellido='" + apellido + "'").list();
    }
    
    public List<Alumno> getLikeApellido(String apellido) {
        return session.createQuery("from Alumno where apellido like '%" + apellido + "%'").list();
    }
}
