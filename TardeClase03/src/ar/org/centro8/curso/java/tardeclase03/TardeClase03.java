package ar.org.centro8.curso.java.tardeclase03;

import javax.swing.JOptionPane;

public class TardeClase03 {

    public static void main(String[] args) {
        // Clase 03 UML
        
        Empleado e1 = new Empleado(1, "Juan", "Perez", 200000);
        System.out.println(e1);
        
        // Modificadores de visibilidad
        // Modificador      Alcance
        // -Omitido         Se accede desde la misma clase y desde clases del mismo paquete
        // -Public          Se accede desde la misma clase y desde cuaquier clase de cualquier paquete
        // -Private         Se accede sólo desde la misma clase
        // -Protected       Se accede desde la misma clase y clases hijas
        
        e1.saludar();
        e1.saludar("Carlos");
        
        e1.nombre();
        e1.getNombre();
        // JOptionPane 
        
    }
    
}
