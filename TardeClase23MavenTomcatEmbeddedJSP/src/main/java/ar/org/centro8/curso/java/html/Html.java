package ar.org.centro8.curso.java.html;

public class Html {

	public static String getHead() {
		return	"	<head>\n" +
				"		<link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\"/>\n" +
				"		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
				"		<title>Sistema de Colegio</title>\n" +
				"	</head>";
	}
	
	public static String volver(String pagina) {
		return "<form action=" + pagina + "><input type=\"submit\" value=\"Volver\" /></form>";
	}
}
