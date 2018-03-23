package ar.org.centro8.curso.java.test;

import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Excepciones {
    
    public static void main(String[] args) {
        // Manejo de Exceptions
        //System.out.println(10/0);
        //System.out.println("Esta linea no se ejecuta");
        
        /*
            try{
                - Colocar acá todo lo que pueda arrojar exception.
                - Estas sentencias tienen mas costo de hardware.
                - Si se pueden ejecutar bien no lanza Exception.
            } catch(Exception e){
                - Este bloque se ejecuta en caso de lanzarce una Exception.
                - Se recibe un Objeto de la clase Exception como parámetro.
            } finally{
                - Estas lineas se ejecutan siempre, exista error o no.
            }
            - Estas lineas también se ejecutan siempre.
            - El programa termina normalmente.
        */
        /*
        try {
            System.out.println(10/0);
            System.out.println("Esta linea no se ejecuta");
        } catch(Exception e){
            System.out.println("Ocurrio un error");
            System.out.println(e);
        } finally{
            System.out.println("El programa termina normalmente");
        }
        
        System.out.println("--- Prueba de excepciones ---");
        
        // trycatch TAB
        try {
            //GeneradorDeExcepciones.generarException();
            //GeneradorDeExcepciones.generarException(true);
            //GeneradorDeExcepciones.generarException(null);
            //GeneradorDeExcepciones.generarException(null,2);
            //GeneradorDeExcepciones.generarException("Hola",8);
            //GeneradorDeExcepciones.generarException("22x");
            //System.out.println("Esta linea no se ejecuta");
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println("--- Prueba de excepciones personalizadas ---");
        // Captura personalizada de Exceptions
        try {
            //GeneradorDeExcepciones.generarException();
            //GeneradorDeExcepciones.generarException("Hola",20);
            //GeneradorDeExcepciones.generarException("22x");
            //GeneradorDeExcepciones.generarException(null,20);
            FileReader in = new FileReader("c:/texto.txt");
        } catch(NumberFormatException e){
            System.out.println("Formato de número incorrecot");
        }
        
        catch(NullPointerException e){
            System.out.println("Puntero nulo");
        }
        
        catch(IndexOutOfBoundsException e){
            System.out.println("Indice fuera de rango");
        }
        
        catch(ArithmeticException e){
            System.out.println("Error división por cero");
        }
        
        catch (Exception e) {
            System.out.println("Ocurrio un error no esperado");
        }
        */
        
        System.out.println("--- ---");
        // Uso de Exceptions para validar reglas de negocio
        
        // Venta de vuelos
        Vuelo v1 = new Vuelo("lat1234",100);
        Vuelo v2 = new Vuelo("aer1111",100);
        
        try {
            v1.venderPasajes(30);
            v1.venderPasajes(30);
            v2.venderPasajes(20);
            v1.venderPasajes(50);       // Lanza una NoHayMasPasajesException
            v2.venderPasajes(20);       // Esta venta no se realiza
        } catch (NoHayMasPasajesException ex) {
            System.out.println(ex);
        }
        
    }
}
