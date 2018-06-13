package creation.builder;

import java.util.List;

public class RobotPancho implements Robot {
	
	private List<Integer> acciones;

	public RobotPancho() { }
	
	private void start() {
		System.out.println("Quere' Panchito? Calentitos los Pancho' !");
	}
	
	private void getParts() {
		System.out.println("Me hice de: Pan, Salchicha y Salsas.");
	}
	
	private void build() {
		System.out.println("Marcheee Pancho...");
	}
	
	public void check() {
		System.out.println("No señor no son Panchos Contaminados...");
	}
	
	public void finish() {
		System.out.println("Lo queres con papas Pay ?");
	}
	
	@Override
	public void trabajar() {
		start();
		
		for (Integer i : acciones) {
			switch (i) {
				case 1	: getParts(); break;
				case 2	: build(); break;
				case 3	: check(); break;
				default : System.out.println("Esta acción no la puedo realizar.");
			}
		}
		
		finish();
	}

	@Override
	public void cargarAcciones(List<Integer> acciones) {
		this.acciones = acciones;
	}
}
