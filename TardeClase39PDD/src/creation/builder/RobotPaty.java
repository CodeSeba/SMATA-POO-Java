package creation.builder;

import java.util.List;

public class RobotPaty implements Robot {
	
	private List<Integer> acciones;

	public RobotPaty() { }
	
	private void iniciar() {
		System.out.println("Marcheee Paty !");
	}
	
	private void getIngredientes() {
		System.out.println("Me hice de: Pan, Paty y Salsas.");
	}
	
	private void armar() {
		System.out.println("Armando Paty...");
	}
	
	public void revisar() {
		System.out.println("Mira que lindo Paty.");
	}
	
	public void terminar() {
		System.out.println("Sale con Fritas !");
	}
	
	@Override
	public void trabajar() {
		iniciar();
		
		for (Integer i : acciones) {
			switch (i) {
				case 1	: getIngredientes(); break;
				case 2	: armar(); break;
				case 3	: revisar(); break;
				default : System.out.println("Esta acción no la puedo realizar.");
			}
		}
		
		terminar();
	}

	@Override
	public void cargarAcciones(List<Integer> acciones) {
		this.acciones = acciones;
	}
}
