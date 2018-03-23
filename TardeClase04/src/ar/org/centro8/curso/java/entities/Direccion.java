package ar.org.centro8.curso.java.entities;

public class Direccion {
    private String calle;
    private int nro;
    private int piso;
    private String depto;
    private String ciudad;

    @Override
    public String toString() {
        return "Direccion{" + "calle=" + calle + ", nro=" + nro + ", piso=" + piso + ", depto=" + depto + ", ciudad=" + ciudad + '}';
    }

    public Direccion(String calle, int nro, int piso, String depto, String ciudad) {
        this.calle = calle;
        this.nro = nro;
        this.piso = piso;
        this.depto = depto;
        this.ciudad = ciudad;
    }
    
    public Direccion(String calle, int nro, int piso, String depto) {
        this.calle = calle;
        this.nro = nro;
        this.piso = piso;
        this.depto = depto;
        this.ciudad = "CABA";
    }

    public String getCalle() {
        return calle;
    }

    public int getNro() {
        return nro;
    }

    public int getPiso() {
        return piso;
    }

    public String getDepto() {
        return depto;
    }

    public String getCiudad() {
        return ciudad;
    }
    
}
