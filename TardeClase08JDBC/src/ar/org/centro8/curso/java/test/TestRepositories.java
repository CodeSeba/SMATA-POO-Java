package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.repositories.AlumnoR;
import ar.org.centro8.curso.java.repositories.CursoR;

public class TestRepositories {
    public static void main(String[] args) {
        AlumnoR ar=new AlumnoR(Connector.getConnection());
        Alumno alumno=new Alumno("Gabriel", "Peralta", 24, 1);
        ar.save(alumno);
        System.out.println(alumno);
        
        ar.remove(ar.getById(6));
        
        alumno=ar.getById(8);
        alumno.setNombre("Carolina");
        alumno.setApellido("Herrera");
        ar.update(alumno);
        
        ar.getAll().forEach(System.out::println);
        //ar.getLikeApellido("per").forEach(System.out::println);
        
        CursoR cr=new CursoR(Connector.getConnection());
        Curso curso=new Curso("Java","Ríos","Lunes","Tarde");
        cr.save(curso);
        System.out.println(curso);
        
        //System.out.println(cr.getById(2));
        cr.getAll().forEach(System.out::println);
        
        // falta CursoR.remove y CursoR.Update
        
        
        
    }
 
}
