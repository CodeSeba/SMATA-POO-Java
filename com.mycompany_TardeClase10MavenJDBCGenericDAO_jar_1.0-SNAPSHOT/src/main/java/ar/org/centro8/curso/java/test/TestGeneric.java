package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.repositories.GenericR;

public class TestGeneric {

    public static void main(String[] args) {

        // Esta primera prueba es para revisar si la query se genera correctamente, sin setId
        System.out.println("--- Prueba de GenericR con clase Alumno ---");
        GenericR<Alumno> ar = new GenericR(Connector.getConnection(), Alumno.class);
        ar.save(new Alumno("Nicolas", "Leno", 22, 1));

        // Esta prueba revisa si funciona setId correctamente
        System.out.println("--- Prueba de save() si ingresa la id desde la BD ---");
        Alumno a = new Alumno("Mirta", "Mendoza", 43, 1);
        ar.save(a);
        System.out.println(a);

        // Se prueba si getByFiltro() funciona correctamente
        System.out.println("--- Prueba de getByFiltro() usando Alumnos ---");
        ar.getByFiltro("1=1").forEach(System.out::println);

        // Se prueba si getAll() funciona correctamente
        System.out.println("--- Prueba de getAll() ---");
        ar.getAll().forEach(System.out::println);
        
        System.out.println("--- Prueba de GenericR con clase Curso ---");
        GenericR<Curso> cr = new GenericR(Connector.getConnection(), Curso.class);
        cr.save(new Curso("Oracle", "Hernan", "Lunes", "Noche"));
        cr.save(new Curso("Python", "Matias", "Martes", "Tarde"));

        System.out.println("--- Prueba de remove() usando Cursos ---");
        cr.remove(cr.getById(12));
        
        System.out.println("--- Prueba de update() usando Curso ---");
        Curso curso = cr.getById(15);
        if (curso!=null) {
            curso.setTitulo("PostgreSQL");
            curso.setDia("Jueves");
            cr.update(curso);
        }
        
        System.out.println("--- Prueba de getByFiltro() usando Cursos ---");
        cr.getByFiltro("1=1").forEach(System.out::println);
        
    }
}
