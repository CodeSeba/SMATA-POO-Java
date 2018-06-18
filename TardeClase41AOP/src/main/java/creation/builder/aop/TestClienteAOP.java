package creation.builder.aop;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClienteAOP {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringAOPXMLConfig.xml");
		//TestAOP t1 = context.getBean("test", TestAOP.class);
		
		TestAOP t1 = context.getBean("testServiceProxy", TestAOP.class);
		
		System.out.println("********************");
		t1.metodo1();
		t1.metodo2();
		t1.metodo3();
		System.out.println("********************");
		
		Scanner sc = new Scanner(System.in);
		Builder constructor = new Builder();
		Robot robot;
		String tipoRobot;
		
		System.out.println("Seleccione el tipo de robot (robotPaty - robotPancho):");
		tipoRobot = sc.nextLine();
		constructor.setRobot(tipoRobot, context);
		constructor.addItem("Revisar");
		constructor.addItem("Imposible");
		constructor.addItem("Ingredientes");
		constructor.addItem("Armar");
		constructor.addItem("Revisar");
		robot = constructor.getRobot();
		robot.trabajar();
	}
}
