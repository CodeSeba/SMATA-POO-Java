package creation.builder;

import java.util.List;

public class RobotPancho implements Robot{
    private List<Integer> acciones;
    public RobotPancho() { }
    private void start(){
        System.out.println("Iniciando el Pancho.");
    }
    private void getParts(){
        System.out.println("Buscando: Pan, Salchicha, Salsas.");
    }
    private void build(){
        System.out.println("Armando el Pancho.");
    }
    private void check(){
        System.out.println("Revisando Pancho");
    }
    private void finish(){
        System.out.println("Terminado el proceso.");
    }
    @Override
    public void trabajar() {
        start();
        for(Integer i:acciones){
            switch(i){
                case 1: getParts(); break;
                case 2: build(); break;
                case 3: check(); break;
            }
        }
        finish();
    }

    @Override
    public void cargarAcciones(List<Integer> acciones) {
        this.acciones=acciones;
    }
    
}
