<%-- 
    Document   : index
    Created on : Apr 23, 2018, 4:02:26 PM
    Author     : seba
--%>

<%@page import="ar.org.centro8.curso.java.html.Html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <% out.println(Html.getHead()); %>
    <body>
        <h1>Sistema de Colegio</h1>
		<ul>
			<li><a href="alumnos.jsp">Menu de alumnos</a></li>
			<li><a href="cursos.jsp">Menu de cursos</a></li>
		</ul>
		
    </body>
</html>
