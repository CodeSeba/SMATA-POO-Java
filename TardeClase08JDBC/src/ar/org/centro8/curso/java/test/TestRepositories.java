package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.repositories.AlumnoR;
import ar.org.centro8.curso.java.repositories.CursoR;

public class TestRepositories {
    public static void main(String[] args) {
        AlumnoR ar = new AlumnoR(Connector.getConnection());
        Alumno alumno = new Alumno("Gabriel", "Moreno", 24, 1);
        ar.save(alumno);
        System.out.println(alumno);
        
        ar.remove(ar.getById(6));
        
        alumno = ar.getById(8);
        alumno.setNombre("Carolina");
        alumno.setApellido("Herrera");
        ar.update(alumno);
        
        System.out.println("--- getAll ---");
        ar.getAll().forEach(System.out::println);
        
        //System.out.println("--- getLikeApellido ---");
        //ar.getLikeApellido("per").forEach(System.out::println);
        
        System.out.println("--- Prueba de CursoR ---");
        CursoR cr = new CursoR(Connector.getConnection());
        Curso curso = new Curso("Java", "Ríos", "Lunes", "Tarde");
        cr.save(curso);
        System.out.println(curso);
        
        //System.out.println(cr.getById(2));
        System.out.println("--- getAll(cursos) ---");
        cr.getAll().forEach(System.out::println);
        
        // Falta CursosR.remove y CursoR.Update
    }
}
