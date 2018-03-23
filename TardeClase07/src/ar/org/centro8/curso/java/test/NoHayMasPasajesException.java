package ar.org.centro8.curso.java.test;

public class NoHayMasPasajesException extends Exception{
    // Extends Exception: el usuario esta obligado a controlar la Exception
    // Extends RuntimeException: el usuario no esta obligado a controlar la Exception
    
    private String nombreVuelo;
    private int cantidadPasajesNoDisponibles;

    public NoHayMasPasajesException(String nombreVuelo, int cantidadPasajesNoDisponibles) {
        this.nombreVuelo = nombreVuelo;
        this.cantidadPasajesNoDisponibles = cantidadPasajesNoDisponibles;
    }

    @Override
    public String toString() {
        return "El vuelo " + nombreVuelo + ", no tiene " + cantidadPasajesNoDisponibles + " pasajes.";
    }

    public String getNombreVuelo() {
        return nombreVuelo;
    }

    public int getCantidadPasajesNoDisponibles() {
        return cantidadPasajesNoDisponibles;
    }
    
    
}
