package ar.org.centro8.curso.java.entities;

public class ClienteEmpresa {
    private int nro;
    private String razonSocial;
    private String direccion;
    private Cuenta[] cuentas;

    public ClienteEmpresa(int nro, String razonSocial, String direccion) {
        this.nro = nro;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.cuentas = new Cuenta[3];
    }

    @Override
    public String toString() {
        return "ClienteEmpresa{" + "nro=" + nro + ", razonSocial=" + razonSocial + ", direccion=" + direccion + '}';
    }

    public int getNro() {
        return nro;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public Cuenta[] getCuentas() {
        return cuentas;
    }
}
