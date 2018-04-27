<%@page import="ar.org.centro8.curso.java.repositories.GenericR"%>
<%@page import="ar.org.centro8.curso.java.connectors.Connector"%>
<%@page import="ar.org.centro8.curso.java.entities.Alumno"%>
<%@page import="ar.org.centro8.curso.java.html.Html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<% out.println(Html.getHead()); %>
    <body>
        <h1>Baja de Alumnos</h1>
		<%
			try {
					GenericR<Alumno> ar = new GenericR(Connector.getConnection(), Alumno.class);
					ar.remove(ar.getById(Integer.parseInt(request.getParameter("alumno"))));
					out.println("<h2>Se dio de baja el alumno id: " + request.getParameter("alumno") + "</h2>");
				} catch (Exception e) {
					System.out.println(e);
					out.println("<h2>No se pudo dar de baja el alumno.</h2>");
				}
			out.println(Html.volver("alumnosBaja.jsp"));
		%>
    </body>
</html>
