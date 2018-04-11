package ar.org.centro8.curso.java.repositories;

import ar.org.centro8.curso.java.entities.Alumno;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericR<E> {

    private Session session;
    private Class clazz;

    public GenericR(Session session, Class clazz) {
        this.session = session;
        this.clazz = clazz;
    }

    public void save(E e) {
        Transaction tx = session.beginTransaction();
        try {
            session.save(e);
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex);
            tx.rollback();
        }
    }
    
    public void remove(E e) {
        Transaction tx = session.beginTransaction();
        try {
            session.delete(e);
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex);
            tx.rollback();
        }
    }
    
    public void update(E e) {
        Transaction tx = session.beginTransaction();
        try {
            session.update(e);
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex);
            tx.rollback();
        }
    }
    
    public E getById(int id) {
        return (E)session.get(clazz, id);
    }
    
    public List<E> getAll() {
        return session.createQuery("from " + clazz.getName()).list();
    }
    
    public List<E> getByFiltro(String filtro) {
        return session.createQuery(
                "from " + clazz.getName() + " where " + filtro).
                list();
    }
}
