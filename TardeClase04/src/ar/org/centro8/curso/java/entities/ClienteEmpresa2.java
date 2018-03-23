package ar.org.centro8.curso.java.entities;

import java.util.ArrayList;
import java.util.List;

public class ClienteEmpresa2 {
    private int nro;
    private String razonSocial;
    private String direccion;
    private List<Cuenta> cuentas;

    public ClienteEmpresa2(int nro, String razonSocial, String direccion) {
        this.nro = nro;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.cuentas = new ArrayList();
    }

    @Override
    public String toString() {
        return "ClienteEmpresa2{" + "nro=" + nro + ", razonSocial=" + razonSocial + ", direccion=" + direccion + '}';
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

    public List<Cuenta> getCuentas() {
        return cuentas;
    }
    
}
