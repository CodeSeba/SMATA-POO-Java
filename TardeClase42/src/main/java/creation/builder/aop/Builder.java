package creation.builder.aop;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;

public class Builder {
	private Robot robot;
	private List<String> acciones;

	public Builder() {
		acciones = new ArrayList();
	}
	
	public void setRobot(String tipoRobot, ApplicationContext context) throws Exception {
		robot = context.getBean(tipoRobot + "ServiceProxy", Robot.class);
	}
	
	public void addItem(String accion) {
		acciones.add(accion);
	}
	
	public Robot getRobot() {
		robot.cargarAcciones(acciones);
		return robot;
	}
	
}
