package ar.org.centro8.curso.java.services;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.repositories.GenericR;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/v1/alumno")
public class AlumnoServiceRest {
	
	@GET
	@Path("save")
	public String save(
			@QueryParam("nombre")	String nombre,
			@QueryParam("apellido")	String apellido,
			@QueryParam("edad")		int edad,
			@QueryParam("idCurso")	int idCurso
	) {
		GenericR<Alumno> ar = new GenericR(Connector.getConnection(), Alumno.class);
		Alumno alumno = new Alumno(nombre, apellido, edad, idCurso);
		ar.save(alumno);
		return alumno.getId() + "";
	}
	// http://localhost:8080/TardeClase35GlassFishRest/webResources/v1/alumno/save?nombre=juan&apellido=vega&edad=33&idCurso=2
	
	@GET
	@Path("remove")
	public String remove( @QueryParam("id") int id ){ 
		try {
			GenericR<Alumno> ar = new GenericR(Connector.getConnection(), Alumno.class);
			Alumno alumno = ar.getById(id);
			ar.remove(alumno);
		return "true";
		} catch (Exception e) {
			return "false";
		}
		
	}
	
	@GET
	@Path("update")
	public String update(
			@QueryParam("id")		int id,
			@QueryParam("nombre")	String nombre,
			@QueryParam("apellido")	String apellido,
			@QueryParam("edad")		int edad,
			@QueryParam("idCurso")	int idCurso
	){
		try {
			GenericR<Alumno> ar = new GenericR(Connector.getConnection(), Alumno.class);
			Alumno alumno = ar.getById(id);
			if ( alumno == null ) return "false";
			alumno.setNombre(nombre);
			alumno.setApellido(apellido);
			alumno.setEdad(edad);
			alumno.setIdCurso(idCurso);
			ar.update(alumno);
			return "true";
		} catch (Exception e) {
			return "false";
		}
	}
	
	@GET
	@Path("byId")
	public String getById( @QueryParam("id") int id ) {
		try {
			GenericR<Alumno> ar = new GenericR(Connector.getConnection(), Alumno.class);
			Alumno alumno = ar.getById(id);
			if ( alumno == null ) return "false";
		return
				alumno.getId() + "," +
				alumno.getNombre() + "," +
				alumno.getApellido() + "," +
				alumno.getEdad() + "," +
				alumno.getIdCurso() + "\n";
		} catch (Exception e) {
			return "false";
		}
	}
	
	@GET
	@Path("all")
	public String getAll() {
		try {
			GenericR<Alumno> ar = new GenericR(Connector.getConnection(), Alumno.class);
			String response = "";
			for ( Alumno alumno : ar.getAll() ) {
				response +=
						alumno.getId() + "," +
						alumno.getNombre() + "," +
						alumno.getApellido() + "," +
						alumno.getEdad() + "," +
						alumno.getIdCurso() + "\n";
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
			GenericR<Alumno> ar = new GenericR(Connector.getConnection(), Alumno.class);
			String response = "";
			for ( Alumno alumno : ar.getByFiltro(filtro) ) {
				response +=
						alumno.getId() + "," +
						alumno.getNombre() + "," +
						alumno.getApellido() + "," +
						alumno.getEdad() + "," +
						alumno.getIdCurso() + "\n";
			}
			return response;
		} catch (Exception e) {
			return "false";
		}
		// http://localhost:8080/TardeClase37GlassFishRest/webResources/v1/alumno/
		// byFiltro?filtro=nombre='Gabriel'
	}
}
