package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.repositories.GenericR;

public class TestGeneric {
    public static void main(String[] args) {
        System.out.println("--- Prueba de GenericR con clase Alumno ---");
        GenericR<Alumno> ar = new GenericR(Connector.getConnection());
        ar.save(new Alumno("Nicolas","Leno",22,1));
        
        System.out.println("---Prueba de GenericR con clase Curso ---");
        GenericR<Curso> cr = new GenericR(Connector.getConnection());
        cr.save(new Curso("Oracle","Hernan","Lunes","Noche"));
        
        System.out.println("--- Prueba de GenericR ---");
        Alumno a = new Alumno("Mirta", "Mendoza", 43, 1);
        ar.save(a);
        System.out.println(a);
        
        //System.out.println("--- Filtro de Alumnos ---");
        //ar.getByFiltro("1=1", "Alumno").forEach(System.out::println);
        
        //System.out.println("--- Filtro de Cursos ---");
        //cr.getByFiltro("1=1", "Curso").forEach(System.out::println);
        
        System.out.println("--------------------------");
        ar.getAll("Alumno").forEach(System.out::println);
        
        //gomezjose15386@gmail.com
        
    }
}
