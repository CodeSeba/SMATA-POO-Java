package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.repositories.AlumnoROld;
import ar.org.centro8.curso.java.repositories.CursoROld;

public class TestRepositories {
    public static void main(String[] args) {
        AlumnoROld ar=new AlumnoROld(Connector.getConnection());
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
        
        CursoROld cr=new CursoROld(Connector.getConnection());
        Curso curso=new Curso("Java","Ríos","Lunes","Tarde");
        cr.save(curso);
        System.out.println(curso);
        
        
        cr.remove(cr.getById(8));
        
        curso=cr.getById(10);
        if(curso!=null){
            curso.setTitulo("Javascript");
            curso.setProfesor("Fernandez");
            curso.setDia("Viernes");
            cr.update(curso);
        }
        
        
        //System.out.println(cr.getById(2));
        cr.getAll().forEach(System.out::println);
        
        // falta CursoR.remove y CursoR.Update
        
        
        
    }
 
}
