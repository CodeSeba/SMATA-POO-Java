package creation.builder.improved;

import java.util.List;

public class RobotPancho implements Robot {
    
	private List<String>acciones;
    
	public RobotPancho() { }
    
	private void iniciar(){
        System.out.println("Iniciando el Pancho.");
    }
	
    private void getIngredientes(){
        System.out.println("Buscando: Pan, Salchicha, Salsas, Papas Pai.");
    }
	
    private void armar(){
        System.out.println("Armando el Pancho.");
    }
	
    private void revisar(){
        System.out.println("Revisando el Pancho.");
    }
	
    private void terminar(){
        System.out.println("Proceso Terminado.");
    }

	@Override
	public void trabajar() throws Exception {
		this.getClass().getDeclaredMethod("iniciar", null).invoke(this, null);
		getAcciones().forEach(item -> {
			try {
				this
					.getClass()
					.getDeclaredMethod(MapaAcciones.getMap().get(item), null)
					.invoke(this, null);
			} catch (Exception e) {
				System.out.println("Esta accion no la puedo realizar.");
			}
		});
		this.getClass().getDeclaredMethod("terminar", null).invoke(this, null);
	}

	@Override
	public void cargarAcciones(List<String> acciones) {
		this.acciones = acciones;
	}

	@Override
	public List<String> getAcciones() {
		return acciones;
	}
}
