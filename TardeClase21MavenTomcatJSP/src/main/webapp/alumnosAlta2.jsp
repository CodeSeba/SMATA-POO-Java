<%@page import="ar.org.centro8.curso.java.repositories.GenericR"%>
<%@page import="ar.org.centro8.curso.java.connectors.Connector"%>
<%@page import="ar.org.centro8.curso.java.entities.Alumno"%>
<%@page import="ar.org.centro8.curso.java.html.Html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<% out.println(Html.getHead()); %>
    <body>
        <h1>Alta de Alumnos</h1>
		<%
			try {
					Alumno alumno = new Alumno(
						request.getParameter("nombre"),
						request.getParameter("apellido"),
						Integer.parseInt(request.getParameter("edad")),
						Integer.parseInt(request.getParameter("curso"))
					);
					new GenericR (Connector.getConnection(), Alumno.class).save(alumno);
					out.println("<h2>Se dio de alta el alumno id: " + alumno.getId() + "</h2>");
				} catch (Exception e) {
					System.out.println(e);
					out.println("<h2>No se pudo dar de alta un alumno.</h2>");
				}
			out.println(Html.volver("alumnosAlta.jsp"));
		%>
    </body>
</html>
