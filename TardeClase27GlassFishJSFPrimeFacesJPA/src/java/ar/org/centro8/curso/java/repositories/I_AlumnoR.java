package ar.org.centro8.curso.java.repositories;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
import java.util.List;

public interface I_AlumnoR {
    List<Alumno>getByApellido(String apellido);
    List<Alumno>getLikeApellido(String apellido);
    List<Alumno>getByNombreApellido(String nombre, String apellido);
    List<Alumno>getByCurso(int id);
    List<Alumno>getByCurso(Curso curso);
}
