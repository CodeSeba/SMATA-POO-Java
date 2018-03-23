package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.entities.Cuenta;
import ar.org.centro8.curso.java.entities.Direccion;
import ar.org.centro8.curso.java.entities.Empleado;
import ar.org.centro8.curso.java.entities.Persona;
import ar.org.centro8.curso.java.entities.SocioComun;


public class TestHerencia {
    
    public static void main(String[] args) {
        System.out.println("-- dir1 --");
        Direccion dir1 = new Direccion("Medrano", 162, 1, "1");
        System.out.println(dir1);
        
        System.out.println("-- dir2 --");
        Direccion dir2 = new Direccion("Belgrano", 242, 0, null, "Morón");
        System.out.println(dir2);
        
        /*
        System.out.println("-- persona1 --");
        Persona persona1 = new Persona("Juan", "Perez", dir1, 23);
        System.out.println(persona1);
        persona1.saludar();
        
        System.out.println("-- persona2 --");
        Persona persona2 = new Persona(
                "Laura",
                "Salina",
                new Direccion("Lima", 222, 1, "a"),
                0
        );
        System.out.println(persona2);
        persona2.saludar();
        */
        
        System.out.println("-- empleado1 --");
        Empleado empleado1 = new Empleado(1, 30000, "Raul", "Ortiz", dir2, 40);
        System.out.println(empleado1);
        empleado1.saludar();
        
        System.out.println("-- socio1omun1 --");
        SocioComun socioComun1 = new SocioComun(
                1,
                new Cuenta(20, "arg$"),
                "Tatiana",
                "Ramirez",
                dir1,
                34
        );
        socioComun1.getCuenta().depositar(45000);
        System.out.println(socioComun1);
        socioComun1.saludar();
        
        // Polimorfismo
        
        System.out.println("-- polimorfismo --");
        Persona persona1 = new Empleado(2, 10000, "Jose", "Ramos", dir2, 20);
        Persona persona2 = new SocioComun(
                2,
                new Cuenta(30, "arg$"),
                "Laura",
                "Gomez",
                dir2,
                40
        );
        persona1.saludar();
        persona2.saludar();
        
        // Casteo
        
        // Empleado empleado3 = (Empleado)persona1; Funciona el casteo
        // Empleado empleado4 = (Empleado)persona2; Excepcion de casteo
        
        Empleado empleado3 = (persona1 instanceof Empleado)? (Empleado)persona1:null;
        Empleado empleado4 = (persona2.getClass().getSimpleName().equals("Empleado"))? (Empleado)persona2:null;
        
        String texto = "hola";
        
        System.out.println(empleado3.getClass());
        System.out.println(empleado3.getClass().getName());
        System.out.println(empleado3.getClass().getSimpleName());
        System.out.println(empleado3.getClass().getSuperclass().getName());
        System.out.println(empleado3.getClass().getSuperclass().getSuperclass().getName());
        System.out.println(empleado3.getClass().getSuperclass().getSuperclass().getSuperclass());
        
        System.out.println(texto.getClass());
        System.out.println(texto.getClass().getSuperclass());
    }
}
