package ar.org.centro8.curso.java.repositories;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
import java.util.List;

public interface I_CursoR {
    List<Curso>getByTitulo(String titulo);
    List<Curso>getByLikeTitulo(String titulo);
    List<Curso>getByProfesor(String profesor);
    List<Curso>getByLikeProfesor(String profesor);
    List<Curso>getByDia(String dia);
    List<Curso>getByTurno(String turno);
    List<Alumno>getAlumnos(Curso curso);
	List<Alumno>getAlumnos(int idCurso);
}
