package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.entities.Cliente;
import ar.org.centro8.curso.java.entities.ClienteEmpresa;
import ar.org.centro8.curso.java.entities.ClienteEmpresa2;
import ar.org.centro8.curso.java.entities.Cuenta;
import java.util.List;

public class TestRelaciones {
    // psvm atajo de public static void main
    public static void main(String[] args) {
        System.out.println("-- cuenta 1 --");
        Cuenta cuenta1 = new Cuenta(1, "arg$");
        
        cuenta1.depositar(30000);
        cuenta1.depositar(25000);
        cuenta1.debitar(7000);
        
        System.out.println(cuenta1);
        
        System.out.println("-- cliente1 --");
        Cliente cliente1 = new Cliente(1, "Laura", "Salinas", 10);
        cliente1.getCuenta().depositar(5000);
        
        Cuenta cuenta = cliente1.getCuenta();
        cuenta.depositar(10000);
        
        cliente1.getCuenta().debitar(3000);
        System.out.println(cliente1);
        System.out.println(cliente1.getCuenta());
        
        System.out.println("-- clienteEmpresa1 --");
        ClienteEmpresa clienteEmpresa1 = new ClienteEmpresa(
                1,                      // nro de cliente
                "Todo Limpio SRL",      // razon social
                "Lima 345"              // direccion
        );
        
        Cuenta[] cuentas = clienteEmpresa1.getCuentas();
        
        cuentas[0] = new Cuenta(11, "arg$");
        cuentas[1] = new Cuenta(12, "reale$");
        cuentas[2] = new Cuenta(13, "us$");
        
        cuentas[0].depositar(40000);
        cuentas[0].depositar(30000);
        cuentas[0].debitar(15000);
        
        cuentas[1].depositar(20000);
        
        cuentas[2].depositar(12000);
        
        System.out.println(clienteEmpresa1);
        // for (int a=0 ; a < cuentas.length ; a++) System.out.println(cuentas[a]);
        for (Cuenta cta:cuentas) System.out.println(cta);
        
        System.out.println("-- clienteEmpresa2 --");
        ClienteEmpresa2 clienteEmpresa2 = new ClienteEmpresa2(
                2, "Servicios Informaticos", "Larrea 222"
        );
        
        List<Cuenta> lista = clienteEmpresa2.getCuentas();
        lista.add(new Cuenta(21, "arg$"));
        lista.add(new Cuenta(22, "reale$"));
        
        lista.get(0).depositar(50000);
        
        System.out.println(clienteEmpresa2);
        lista.forEach(System.out::println);
        
    }
}
