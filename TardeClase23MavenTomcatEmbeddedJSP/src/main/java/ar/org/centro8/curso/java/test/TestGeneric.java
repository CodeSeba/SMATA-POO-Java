package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.repositories.GenericR;

public class TestGeneric {

	public static void main(String[] args) {
		GenericR<Alumno> ar = new GenericR(Connector.getConnection(), Alumno.class);
		ar.save(new Alumno("Nicolas", "Leon", 22, 1));

		Alumno a = new Alumno("Mirta", "Mendoza", 43, 1);
		ar.save(a);
		System.out.println(a);

		//ar.getByFiltro("1=1").forEach(System.out::println);
		//ar.getAll().forEach(System.out::println);
		System.out.println("-------------------------------------");
		GenericR<Curso> cr = new GenericR(Connector.getConnection(), Curso.class);
		cr.save(new Curso("Oracle", "Herman", "Lunes", "Noche"));

		cr.remove(cr.getById(10));

		Curso curso = cr.getById(15);
		if (curso != null) {
			curso.setTitulo("PosgreSQL");
			curso.setDia("Jueves");
			cr.update(curso);
		}

		//cr.getByFiltro("1=1").forEach(System.out::println);
		//cr.getAll().forEach(System.out::println);
	}
}