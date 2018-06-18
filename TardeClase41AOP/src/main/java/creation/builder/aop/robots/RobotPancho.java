package creation.builder.aop.robots;

import creation.builder.aop.MapaAcciones;
import creation.builder.aop.Robot;
import java.util.List;

public class RobotPancho implements Robot {
    
	private List<String>acciones;
    
	public RobotPancho() { }
    
	public void iniciar(){
        System.out.println("Iniciando el Pancho.");
    }
	
    public void getIngredientes(){
        System.out.println("Buscando: Pan, Salchicha, Salsas, Papas Pai.");
    }
	
    public void armar(){
        System.out.println("Armando el Pancho.");
    }
	
    public void revisar(){
        System.out.println("Revisando el Pancho.");
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
