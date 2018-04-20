<%-- 
    Document   : index
    Created on : Apr 20, 2018, 4:30:48 PM
    Author     : seba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
		<%
			// Código java EE 7
			out.println("<h1>Servidor de Sebas</h1>");
			System.out.println("------ ------");
			System.out.println("Sitio web en linea.");
			System.out.println("------ ------");
			
			for (int a=1 ; a<=6 ; a++) {
				//out.println("<h" + a + ">Etiqueta " + a + "</h" + a + ">");
				out.println(String.format("<h%d>Etiqueta %d</h%d>", a, a, a));
			}
		%>
    </body>
</html>
