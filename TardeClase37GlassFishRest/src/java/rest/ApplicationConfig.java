package rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("webResources")
public class ApplicationConfig extends Application{
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet();
		resources.add(rest.TestRest.class);
		resources.add(ar.org.centro8.curso.java.services.AlumnoServiceRest.class);
		resources.add(ar.org.centro8.curso.java.services.CursoServiceRest.class);
		return resources;
	}
}
