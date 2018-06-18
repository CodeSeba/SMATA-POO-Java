package creation.builder.aop.robots;

import creation.builder.aop.MapaAcciones;
import creation.builder.aop.Robot;
import java.util.List;

public class RobotPaty implements Robot {
    
	private List<String>acciones;
    
	public RobotPaty() { }
    
	private void iniciar(){
        System.out.println("Iniciando el Paty.");
    }
	
    private void getIngredientes(){
        System.out.println("Buscando: Pan, Paty, Salsas.");
    }
	
    private void armar(){
        System.out.println("Armando el Paty.");
    }
	
    private void revisar(){
        System.out.println("Revisando el Paty.");
    }
	
    private void terminar(){
        System.out.println("Proceso Terminado.");
    }

	@Override
	public void trabajar() throws Exception {
		System.out.println("Trabajando...");
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
