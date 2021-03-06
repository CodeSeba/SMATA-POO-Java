package ar.org.centro8.curso.java.services;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.repositories.GenericR;
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
	public String remove( @QueryParam("id") int id ){ return ""; }
	
	@GET
	@Path("update")
	public String update(
			@QueryParam("id")		int id,
			@QueryParam("nombre")	String nombre,
			@QueryParam("apellido")	String apellido,
			@QueryParam("edad")		int edad,
			@QueryParam("idCurso")	int idCurso
	){
		return "";
	}
	
	@GET
	@Path("byId")
	public String getById( @QueryParam("id") int id ) { return ""; }
	
	@GET
	@Path("all")
	public String getAll() { return ""; }
	
	@GET
	@Path("byFiltro")
	public String getByFiltro( @QueryParam("filtro") String filtro) { return ""; }
}
