package creation.builder;

import java.util.List;

public class RobotPaty implements Robot {
    private List<Integer>acciones;
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
    public void trabajar() {
        iniciar();
        for(Integer i:acciones){
            switch(i){
                case 1: getIngredientes();  break;
                case 2: armar();            break;
                case 3: revisar();          break;
                default: System.out.println("Esta acción no la puedo realizar.");
            }
        }
        terminar();
    }

    @Override
    public void cargarAcciones(List<Integer> acciones) {
        this.acciones=acciones;
    }
    
}
