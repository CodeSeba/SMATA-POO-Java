package ar.org.centro8.curso.java.entities;

public class SocioComun extends Persona{
    private int nro;
    private Cuenta cuenta;

    public SocioComun(int nro, Cuenta cuenta, String nombre, String apellido, Direccion direccion, int edad) {
        super(nombre, apellido, direccion, edad);
        this.nro = nro;
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return super.toString() + "SocioComun{" + "nro=" + nro + ", cuenta=" + cuenta + '}';
    }
    
    @Override
    public void saludar(){
        System.out.println("Hola soy un socio común");
    }

    public int getNro() {
        return nro;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
}
