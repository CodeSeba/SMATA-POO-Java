package ar.org.centro8.curso.java.repositories;

import java.util.List;
import javax.persistence.EntityManager;

public class GenericR<E> implements I_GenericR<E> {

    protected EntityManager em;
    private Class clazz;

    public GenericR(EntityManager em, Class clazz) {
        this.em = em;
        this.clazz = clazz;
    }

    @Override
    public void save(E e) {
        if(e==null) return;
        try {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex);
            em.getTransaction().rollback();
        }
    }

    @Override
    public void remove(E e) {
        if(e==null) return;
        try {
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex);
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(E e) {
        if(e==null) return;
        try {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex);
            em.getTransaction().rollback();
        }  
    }

    @Override
    public E getById(int id) {
        return (E)em.find(clazz, id);
    }

    @Override
    public List<E> getAll() {
        return em.createNamedQuery(clazz.getSimpleName()+".findAll").getResultList();
    }

}
