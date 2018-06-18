package creation.builder;

import java.util.Scanner;

public class TestCliente {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Builder constructor = new Builder();
		Robot robot;
		int tipoRobot;
		
		System.out.println("Digite el tipo robot que desea:\n1- RobotPaty\n2- 1RobotPancho\n");
		tipoRobot = sc.nextInt();
		
		constructor.setRobot(tipoRobot);
		constructor.addRevisar();
		constructor.addImposible();
		constructor.addIngredientes();
		constructor.addArmar();
		constructor.addRevisar();
		
		robot = constructor.getRobot();
		robot.trabajar();
	}
}
