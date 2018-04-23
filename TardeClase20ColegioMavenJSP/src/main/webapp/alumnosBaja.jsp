<%@page import="ar.org.centro8.curso.java.repositories.GenericR"%>
<%@page import="java.util.List"%>
<%@page import="ar.org.centro8.curso.java.entities.Alumno"%>
<%@page import="ar.org.centro8.curso.java.connectors.Connector"%>
<%@page import="ar.org.centro8.curso.java.html.Html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% out.println(Html.getHead()); %>
    <body>
        <h1>Baja de Alumos</h1>
		<form action="alumnosBaja2.jsp" method="post">
			<table>
				<select name="alumno">
					<option></option>
					<%
						List<Alumno> alumnos = new GenericR(Connector.getConnection(), Alumno.class).getAll();
						for (Alumno alumno : alumnos) {
							out.println("<option value=\"" + alumno.getId() + "\">" + alumno.toString() + "</option>");
						}
					%>
				</select>
				<tr><td><input type="reset" value="Limpiear"></td>
					<td><input type="submit" value="Borrar"></td>
				</tr>
			</table>
		</form>
		<% out.println(Html.volver("alumnos.jsp"));%>
    </body>
</html>
