package creation.factory;

import java.util.Scanner;

public class TestFactory {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		// Factory
//		System.out.println("Digite la BD (Generic-Oracle-MySQL-SQLServer-PostgreSQL):");
//		String tipo = sc.nextLine();
//		
//		Connection conn = new Factory(tipo).getConnection();
//		System.out.println("Esta conectado a " + conn.description());
		
		// AbstractFactory
		System.out.println("Digite la BD (Generic-Oracle-MySQL-SQLServer-PostgreSQL):");
		String tipo = sc.nextLine();
		Connection conn = new InheritedFactory().getConnection(tipo);
		System.out.println("Esta conectado a " + conn.description());
	}
}
