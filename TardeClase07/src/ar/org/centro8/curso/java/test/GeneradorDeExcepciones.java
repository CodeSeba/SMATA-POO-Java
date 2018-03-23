package ar.org.centro8.curso.java.test;

public class GeneradorDeExcepciones {
    
    public static void generarException(){
        int[] vector = new int[5];
        vector[20] = 10;
    }
    
    public static void generarException(boolean x){
        if (x) System.out.println(10/0);
    }
    /*
    public static void generarException(String texto){
        //if (texto == null) return;
        System.out.println(texto.length());
    }
    */
    public static void generarException(String numero, boolean x){
        if (x) Integer.parseInt(numero);
    }
    
    public static void generarException(String texto, int pos){
        System.out.println(texto.charAt(pos));
    }
    
    public static void generarException(String numero){
        Integer.parseInt(numero);
    }
}
