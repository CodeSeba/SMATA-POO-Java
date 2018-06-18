package creation.builder.improved;

import java.util.ArrayList;
import java.util.List;

public class Builder {

	private Robot robot;
	private List<String> acciones;

	public Builder() {
		acciones = new ArrayList();
	}

	public void setRobot(String tipo) throws Exception {
		robot = (Robot)Class.forName("creation.builder.improved." + tipo).newInstance();
	}
	
	public void addItem(String accion) {
		acciones.add(accion);
	}
	
	public Robot getRobot() {
		robot.cargarAcciones(acciones);
		return robot;
	}
}
