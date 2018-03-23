package tardeclase01;

/**
 * Esta clase es la clase principal del proyecto TardeClase01 del curso Java
 * Objetos fecha 05/03/2018
 *
 * @author Carlos Ríos
 */
public class TardeClase01 {

    /**
     * Punto de inicio del proyecto TardeClase01
     *
     * @param args Argumentos que ingresan desde consola.
     */
    public static void main(String[] args) {
        /*
        Curso:  Java Objectos 150 horas
        Días:   Lunes Miércoles Viernes     15:00 a 18:30 hs
        Profe:  Carlos Ríos         lawlercarlospatricio@gmail.com
        Materiales:     google docs.
        
        Usamos Java SE  Java EE
        
        Software:   JDK 8.X         www.oracle.com
        JDK: Java Development Kit   (Kit de Desarrollo Java) para usar con Java SE
        
        JDK Alternativo:    OpenJDK (Solo esta para linux)
        
        nota: descargar JDK 8X solo (sin netbeans)
        
        Netbeans IDE 8.X            netbeans.org (descargar versión full)
        
        Eclipse, IntelliJ,  JDeveloper
        
         */

        // Comentario de una sola linea
        /* Bloque de Comentarios */
        /**
         * Comentario JavaDOC Los comentarios JavaDOC se colocan antes de la
         * declaración de clase o método
         */
        // sout TAB Atajo de teclado para System.out.println("");
        // Java, C++, C#, VisualBasic son lenguajes de tipado fuerte
        // Javascript, php, python son lenguajes de tipado debil
        // Tipo de datos primitivos
        // tipo de datos boolean            1 byte 
        boolean bo = true;
        System.out.println(bo);
        bo = false;
        System.out.println(bo);

        // tipo de datos byte       (signed)
        byte by = 100;
        System.out.println(by);

        /*
            signed
            byte by;
        
            |--------|-------|
          -128       0      127
        
        
            unsigned
            byteu by;
        
            |----------------|
            0               255
            
        
         */
        System.out.println(by);

        // Tipo de datos short  2 bytes
        short sh = 2000;
        System.out.println(sh);

        // Tipo de datos int    4 bytes
        int in = 4000;
        System.out.println(in);

        // Tipo de datos long   8 bytes
        long lo = 4000L;
        System.out.println(lo);

        // Tipo de datos char   2 bytes unsigned
        // usa la tabla unicode
        char ch = 65;
        System.out.println(ch);
        ch += 32;                 //ch le sumo 32
        System.out.println(ch);

        // Tipo de datos float 32 bits
        float fl = 4.75f;
        System.out.println(fl);

        // Tipo de datos double 64 bits
        double dl = 4.75;
        System.out.println(dl);

        fl = 10;
        dl = 10;
        System.out.println(fl / 3);
        System.out.println(dl / 3);

        fl = 100;
        dl = 100;
        System.out.println(fl / 3);
        System.out.println(dl / 3);

        // Clase BigDecimal permite expresar decimal de mas de 64 bits
        // Clase String
        String st = "Hola";
        System.out.println(st);

        // Recorro st como un vector
        for (int a = 0; a < st.length(); a++) {
            System.out.print(st.charAt(a));
        }
        System.out.println();

        // menu source / format acomoda automaticamente el identado
        
        // vuelvo a recorrer el vector
        for(int a=0;a<st.length();a++) System.out.print(st.charAt(a));
        System.out.println();
        
        
    }// end main

}// end main class
