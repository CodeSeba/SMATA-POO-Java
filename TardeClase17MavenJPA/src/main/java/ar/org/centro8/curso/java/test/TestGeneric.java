package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.entities.Alumno;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class TestGeneric {
    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("JPAPU").createEntityManager();
        
        Alumno alumno=new Alumno("Jorge","Lisan",23,2);
        
        
    }
}
