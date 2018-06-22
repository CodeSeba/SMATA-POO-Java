package creation.builder.aop.robots;

import creation.builder.aop.MapaAcciones;
import creation.builder.aop.Robot;
import java.util.List;

public class RobotPaty implements Robot {
    
	private List<String>acciones;
    
	public RobotPaty() { }
    
	public void iniciar(){
        System.out.println("Iniciando el Paty.");
    }
	
    public void getIngredientes(){
        System.out.println("Buscando: Pan, Paty, Salsas.");
    }
	
    public void armar(){
        System.out.println("Armando el Paty.");
    }
	
    public void revisar(){
        System.out.println("Revisando el Paty.");
    }
	
    public void terminar(){
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
