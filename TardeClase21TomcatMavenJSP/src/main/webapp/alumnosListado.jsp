<%@page import="ar.org.centro8.curso.java.repositories.GenericR"%>
<%@page import="ar.org.centro8.curso.java.entities.Alumno"%>
<%@page import="ar.org.centro8.curso.java.connectors.Connector"%>
<%@page import="ar.org.centro8.curso.java.html.Html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% out.println(Html.getHead()); %>
    <body>
        <h1>Listado de Alumnos</h1>
		<%
			GenericR<Alumno> ar = new GenericR(Connector.getConnection(), Alumno.class);
			out.println("	<table>");
			out.println("				<tr><th>Id</th><th>Nombre</th><th>Apellido</th><th>Edad</th><th>idCurso</th></tr>");
			for (Alumno item:ar.getAll() ) {
					out.println("					<tr>");
					out.println("						<td>" + item.getId() + "</td>");
					out.println("						<td>" + item.getNombre() + "</td>");
					out.println("						<td>" + item.getApellido() + "</td>");
					out.println("						<td>" + item.getEdad() + "</td>");
					out.println("						<td>" + item.getIdCurso()+ "</td>");
			};
		%>
		
		<% out.println(Html.volver("alumnos.jsp"));%>
	</body>
</html>
