package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("test")
public class TestRest {
	
	@GET
	public String info() {
		return "Hola Mundo ! WebService REST Sebas";
	}
	// http://localhost:8080/TardeClase35GlassFishRest/webResources/test
	
	@GET
	@Path("info2")
	public String info2() {
		return "Sebas";
	}
	// http://localhost:8080/TardeClase35GlassFishRest/webResources/test/info2
	
	@GET
	@Path("suma")
	public String sumar(@QueryParam("nro1") int nro1, @QueryParam("nro2") int nro2) {
		return (nro1 + nro2) + "";
	}
	// http://localhost:8080/TardeClase35GlassFishRest/webResources/test/suma?nro1=4&nro2=6
	
}
