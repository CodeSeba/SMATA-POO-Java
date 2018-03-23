package ar.org.centro8.curso.java.entities;

public class Empleado extends Persona {
    private int legajo;
    private float basico;

    public Empleado(int legajo, float basico, String nombre, String apellido, Direccion direccion, int edad) {
        super(nombre, apellido, direccion, edad);
        this.legajo = legajo;
        this.basico = basico;    
    }

    @Override
    public String toString() {
        return super.toString() + "Empleado{" + "legajo=" + legajo + ", basico=" + basico + '}';
    }

    public int getLegajo() {
        return legajo;
    }

    public float getBasico() {
        return basico;
    }
    
    @Override
    public void saludar(){
        System.out.println("Hola soy un empleado");
    }
}
