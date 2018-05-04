<%@page import="ar.org.centro8.curso.java.repositories.GenericR"%>
<%@page import="ar.org.centro8.curso.java.connectors.Connector"%>
<%@page import="ar.org.centro8.curso.java.entities.Alumno"%>
<%@page import="ar.org.centro8.curso.java.html.Html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% out.println(Html.getHead()); %>
    <body>
        <h1>Alumnos Modificaciones</h1>
		
		<%
			Alumno alumno = new Alumno (
					Integer.parseInt(request.getParameter("id")),
					request.getParameter("nombre"),
					request.getParameter("apellido"),
					Integer.parseInt(request.getParameter("edad")),
					Integer.parseInt(request.getParameter("curso"))
			);
			GenericR<Alumno> ar = new GenericR(Connector.getConnection(), Alumno.class);
			ar.update(alumno);
			out.println("<h2>Se modifico el alumno id: "+ alumno.getId() + "</h2>");
		%>
		
		<% out.println(Html.volver("alumnosModificaciones.jsp"));%>
    </body>
</html>
