package creation.builder.improved;

import java.util.Scanner;

public class TestCliente {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Builder constructor = new Builder();
		Robot robot;
		String tipoRobot;
		
		System.out.println("Digite el tipo de robot desea crear (RobotPaty - RobotPancho):");
		tipoRobot = sc.nextLine();
		
		constructor.setRobot(tipoRobot);
		constructor.addItem("Revisar");
		constructor.addItem("Imposible");
		constructor.addItem("Ingredientes");
		constructor.addItem("Armar");
		constructor.addItem("Revisar");
		
		robot = constructor.getRobot();
		robot.trabajar();
	}
}
