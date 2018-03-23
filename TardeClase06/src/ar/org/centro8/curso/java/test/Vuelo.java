package ar.org.centro8.curso.java.test;

public class Vuelo {
    private String nombreVuelo;
    private int cantidadPasajes;
    
    public synchronized void venderPasajes(int cantidad) throws NoHayMasPasajesException{
        if (cantidadPasajes < cantidad)
            throw new NoHayMasPasajesException(nombreVuelo, cantidad);
        cantidadPasajes -= cantidad;
    }

    @Override
    public String toString() {
        return "Vuelo{" + "nombreVuelo=" + nombreVuelo + ", cantidadPasajes=" + cantidadPasajes + '}';
    }

    public Vuelo(String nombreVuelo, int cantidadPasajes) {
        this.nombreVuelo = nombreVuelo;
        this.cantidadPasajes = cantidadPasajes;
    }

    public String getNombreVuelo() {
        return nombreVuelo;
    }

    public int getCantidadPasajes() {
        return cantidadPasajes;
    }
}
