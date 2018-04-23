<%@page import="ar.org.centro8.curso.java.html.Html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% out.println(Html.getHead()); %>
    <body>
        <h1>Menu de Alumnos</h1>
		<ul>
			<li><a href="cursosAlta.jps">Alta de cursos</a></li>
			<li><a href="cursosBaja.jps">Baja de cursos</a></li>
			<li><a href="cursosModificaciones.jps">Modificaciones de cursos</a></li>
			<li><a href="cursosListado.jps">Listado de cursos</a></li>
			<li><a href="index.jps">Menu Principal</a></li>
		</ul>
    </body>
</html>
