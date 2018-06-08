package ar.org.centro8.curso.java.services;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.repositories.GenericR;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/v1/curso")
public class CursoServiceRest {
	
	@GET
	@Path("save")
	public String save(
			@QueryParam("titulo")	String titulo,
			@QueryParam("profesor")	String profesor,
			@QueryParam("dia")		String dia,
			@QueryParam("turno")	String turno
	){
		try {
			GenericR<Curso> cr = new GenericR(Connector.getConnection(), Curso.class);
			Curso curso = new Curso(titulo, profesor, dia, turno);
			cr.save(curso);
			return curso.getId() + "";
		} catch (Exception e) {
			return "false";
		}
	}
	
	@GET
	@Path("remove")
	public String remove( @QueryParam("id") int id ){ 
		try {
			GenericR<Curso> cr = new GenericR(Connector.getConnection(), Curso.class);
			Curso curso = cr.getById(id);
			cr.remove(curso);
			return "true";
		} catch (Exception e) {
			return "false";
		}
		
	}
	
	@GET
	@Path("update")
	public String update(
			@QueryParam("id")		int id,
			@QueryParam("titulo")	String titulo,
			@QueryParam("profesor")	String profesor,
			@QueryParam("dia")		int dia,
			@QueryParam("turno")	int turno
	){
		try {
			GenericR<Curso> cr = new GenericR(Connector.getConnection(), Curso.class);
			Curso curso = cr.getById(id);
			curso.setTitulo(titulo);
			curso.setProfesor(profesor);
			curso.setDia(titulo);
			curso.setTurno(titulo);
			cr.update(curso);
			return "true";
		} catch (Exception e) {
			return "false";
		}
	}
	
	@GET
	@Path("byId")
	public String getById( @QueryParam("id") int id ) {
		try {
			GenericR<Curso> cr = new GenericR(Connector.getConnection(), Curso.class);
			Curso curso = cr.getById(id);
			if ( curso == null ) return "false";
			return 
					curso.getId() + "," +
					curso.getTitulo() + "," +
					curso.getProfesor() + "," +
					curso.getDia() + "," +
					curso.getTurno() + "\n";
		} catch (Exception e) {
			return "false";
		}
	}
	
	@GET
	@Path("all")
	public String getAll() {
		try {
			GenericR<Curso> cr = new GenericR(Connector.getConnection(), Curso.class);
			String response = "";
			for ( Curso curso : cr.getAll() ) {
				response +=
						curso.getId() + "," +
						curso.getTitulo() + "," +
						curso.getProfesor() + "," +
						curso.getDia() + "," +
						curso.getTurno() + "\n";
			}
			return response;
		} catch (Exception e) {
			return "false";
		}
	}
	
	@GET
	@Path("byFiltro")
	public String getByFiltro( @QueryParam("filtro") String filtro) {
		try {
			GenericR<Curso> cr = new GenericR(Connector.getConnection(), Curso.class);
			String response = "";
			for ( Curso curso : cr.getByFiltro(filtro) ) {
				response +=
						curso.getId() + "," +
						curso.getTitulo() + "," +
						curso.getProfesor() + "," +
						curso.getDia() + "," +
						curso.getTurno() + "\n";
			}
			return response;
		} catch (Exception e) {
			return "false";
		}
	}
}
