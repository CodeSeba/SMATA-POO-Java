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
        <h1>Modificaciones de Alumnos</h1>
		<form action="alumnosModificaciones2.jsp" method="post" >
			<table>
				<tr><td>Seleccione alumno:</td>
					<td><select name="alumno">
						<option></option>
						<%
							List<Alumno> alumnos = new GenericR(Connector.getConnection(), Alumno.class).getAll();
							// ar.getAll().forEach(System.out::println)
							for (Alumno alumno : alumnos) {
								out.println("<option value=\"" + alumno.getId() + "\">" + alumno.toString() + "</option>");
							}
						%>
		
				</select></td></tr>
				<tr><td><input type="reset" value="Limpiar" /></td>
					<td><input type="submit" value="Modificar" /></td></tr>
			</table>
		</form>
					
		<% out.println(Html.volver("alumnos.jsp"));%>
		
    </body>
</html>
