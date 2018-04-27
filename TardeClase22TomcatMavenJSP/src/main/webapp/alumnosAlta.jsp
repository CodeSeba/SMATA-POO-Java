<%@page import="ar.org.centro8.curso.java.repositories.GenericR"%>
<%@page import="java.util.List"%>
<%@page import="ar.org.centro8.curso.java.entities.Curso"%>
<%@page import="ar.org.centro8.curso.java.connectors.Connector"%>
<%@page import="ar.org.centro8.curso.java.html.Html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% out.println(Html.getHead()); %>
    <body>
        <h1>Alta de Alumos</h1>
		<form action="alumnosAlta2.jsp" method="post">
			<table>
				<tr><td>Nombre:		</td><td><input type="text" name="nombre"	></td></tr>
				<tr><td>Apellido:	</td><td><input type="text" name="apellido"	></td></tr>
				<tr><td>Edad:		</td><td><input type="text" name="edad"		></td></tr>
				<tr><td>Curso:		</td><td>
						<select name="curso">
							<%
								List<Curso> cursos = new GenericR(Connector.getConnection(), Curso.class).getAll();
								for (Curso curso : cursos) {
									out.println("<option value=\"" + curso.getId() + "\">" + curso.toString() + "</option>");
								}
							%>
						</select></td></tr>
				<tr><td><input type="reset" value="Limpiear"></td>
					<td><input type="submit" value="Agregar"></td>
				</tr>
			</table>
		</form>
		<% out.println(Html.volver("alumnos.jsp"));%>
    </body>
</html>
