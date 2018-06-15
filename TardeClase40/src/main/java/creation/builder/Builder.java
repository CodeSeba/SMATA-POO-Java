package creation.builder;

import java.util.ArrayList;
import java.util.List;

public class Builder {
	
	private Robot robot;
	private List<Integer> acciones;
	
	public Builder() {
		acciones = new ArrayList();
	}
	
	public void setRobot(int i) {
		if (i==1) robot = new RobotPaty();
		else robot = new RobotPancho();
		}
	
	public void addIngredientes() {
		acciones.add(1);
	}
	
	public void addArmar() {
		acciones.add(2);
	}

	public void addRevisar() {
		acciones.add(3);
	}
	
	public void addImposible() {
		acciones.add(100);
	}
	
	public Robot getRobot() {
		robot.cargarAcciones(acciones);
		return robot;
	}
	
}
