package ar.org.centro8.curso.java.webserver;

import java.io.File;
import javax.servlet.ServletException;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Launch {

	public static void main(String[] args) throws LifecycleException,
			InterruptedException, ServletException {

		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);
		tomcat.getConnector();
		
		String docBase = "src/main/webapp/";
		tomcat.addWebapp("", new File(docBase).getAbsolutePath());

		tomcat.start();
		tomcat.getServer().await();
	}
}