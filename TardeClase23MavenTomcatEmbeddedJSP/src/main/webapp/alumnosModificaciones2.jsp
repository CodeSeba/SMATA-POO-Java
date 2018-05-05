<%@page import="java.util.List"%>
<%@page import="ar.org.centro8.curso.java.entities.Curso"%>
<%@page import="ar.org.centro8.curso.java.html.Html"%>
<%@page import="ar.org.centro8.curso.java.repositories.GenericR"%>
<%@page import="ar.org.centro8.curso.java.entities.Alumno"%>
<%@page import="ar.org.centro8.curso.java.connectors.Connector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% out.println(Html.getHead()); %>
    <body>
        <h1>Modificaciones de Alumnos</h1>
		
		<%
			GenericR<Alumno> ar = new GenericR(Connector.getConnection(), Alumno.class);
			GenericR<Curso> cr = new GenericR(Connector.getConnection(), Curso.class);
			Alumno alumno = ar.getById(Integer.parseInt(request.getParameter("alumno")));
		%>
		
		<form action="alumnosModificaciones3.jsp" method="post" >
			<table>
				<tr><td>Id:			</td>
					<td><input type="text" name="id" value="<% out.print(alumno.getId()); %>" readonly="true" /></td></tr>
				<tr><td>Nombre:		</td>
					<td><input type="text" name="nombre" value="<% out.println(alumno.getNombre()); %>" /></td></tr>
				<tr><td>Apellido:	</td>
					<td><input type="text" name="apellido"	value="<% out.println(alumno.getApellido()); %>" /></td></tr>
				<tr><td>Edad:		</td>
					<td><input type="text" name="edad" value="<% out.println(alumno.getEdad()); %>" /></td></tr>
				<tr><td>Curso:		</td>
					<td><select name="curso" >
						<%
							List<Curso> cursos = cr.getAll();
							out.println("<option value=\"" + alumno.getIdCurso()+ "\">" + cr.getById(alumno.getIdCurso()).toString() + "</option>");
							for (Curso curso : cursos) {
								out.println("<option value=\"" + curso.getId() + "\">" + curso.toString() + "</option>");
							}
						%>
					</select></td></tr>
				<tr><td><input type="reset" value="Limpiear"></td>
					<td><input type="submit" value="Guardar"></td>
				</tr>
			</table>
		</form>
					
		<% out.println(Html.volver("alumnosModificaciones.jsp")); %>
		
    </body>
</html>
