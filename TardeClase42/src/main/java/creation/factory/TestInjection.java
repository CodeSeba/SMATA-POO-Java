package creation.factory;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInjection {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Connection conn;
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringXMLConfig.xml");
		
		// Abstract Factory Injection
		System.out.println("Digite la BD (Generic-Oracle-MySQL-SQLServer-PostgreSQL):");
		String tipo = sc.nextLine();
		conn = context.getBean("factory", InheritedFactory.class).getConnection(tipo);
		System.out.println("Esta conectado a " + conn.description());
	}
}
