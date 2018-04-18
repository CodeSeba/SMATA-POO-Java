package ar.org.centro8.curso.java.repositories;

import java.util.List;

public interface I_GenericR<E> {
    public void save(E e);
    public void remove(E e);
    public void update(E e);
    public E getById(int id);
    public List<E>getAll();
}
