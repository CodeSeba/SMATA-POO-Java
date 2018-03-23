package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.interfaces.Archivo;
import ar.org.centro8.curso.java.utils.ArchivoBinario;
import ar.org.centro8.curso.java.utils.ArchivoTexto;
import java.util.Scanner;

public class TestInterfaces {
    public static void main(String[] args) throws Exception{
        
        Archivo archivo = null;
        
        // Elección de tecnología de implementación
        
        //archivo = new ArchivoTexto();
        //archivo = new ArchivoBinario();
        
        System.out.println("Escriba ArchivoTexto o ArchivoBinario");
        String tecno= new Scanner(System.in).nextLine();
        
        // if (tecno.equalsIgnoreCase("ArchivoTexto")) archivo = new ArchivoTexto();
        // if (tecno.equalsIgnoreCase("ArchivoBinario")) archivo = new ArchivoBinario();
        
        archivo = (Archivo)Class.forName("ar.org.centro8.curso.java.utils."+tecno).newInstance();
        
        // Aplicación
        
        archivo.setFile("texto.txt");
        archivo.setText("Probando la tecnologia");
        System.out.println(archivo.getText());
        archivo.info();
    }
}
