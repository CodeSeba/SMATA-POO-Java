package tardeclase02;

import javax.swing.JOptionPane;

public class TardeClase02 {

    public static void main(String[] args) {
        // Clase02
        // Carlos Ríos	lawlercarlospatricio@gmail.com

        String texto = "Hola";

        // Imprimir texto en mayusculas
        for ( int a=0 ; a<texto.length() ; a++ ) {
                char car = texto.charAt(a);
                if ( car>=97 && car<=122 ) car -= 32;
                System.out.print(car);
        }
        System.out.println();

        // uso del operador ternario
        for ( int a=0 ; a<texto.length() ; a++ ) {
                char car = texto.charAt(a);
                System.out.print( (car>=97 && car<=122)? car-=32 : car );
        }
        System.out.println();

        // Imprimir texto todo en minusculas
        for (int a=0 ; a<texto.length() ; a++ ) {
                char car = texto.charAt(a);
                System.out.print( (car>=65 && car<=90)? car+=32 : car );
        }
        System.out.println();

        // Funciones de la clase String
        System.out.println(texto.toLowerCase());
        System.out.println(texto.toUpperCase());

        JOptionPane.showMessageDialog(null, "Curso de Java");

        // Programación Orientada a Objetos
        // Clases:	Las clases se debe escribir en singular y la primera letra en mayuscula
        // Ejemplos:	Auto, Cliente, Persona, Articulo
        // Miembros:	Puden ser atributos o métodos
        // Atributos:	Describen a la clase (adjetivos)
        // -notas:  	Los atributos numericos se inicializan en cero
        //		Los atributos String se inicializan en null automaticamente
        // Métodos:	Son acciones (verbos, acciones)
        // Objetos:	Son instancias de la clase y representas situaciones en particular


        // Declaración de Clase Interna
        class Auto {
            // Atributos
            String marca;
            String modelo;
            String color;
            int velocidad;

            // Método constructor (Se ejecuta en la construcción de un objeto)
            // los constructores tienen el mismo nombre que la clase, es el unico método que inicia
            // en mayusculas, y en su interior se colocan las acciones necesarias para inicializar un
            // objeto. Los métodos constructores pueden sobrecargarse.
            // Si una clase no tiene constructor, El compilador agrega un constructor vacio en 
            // tiempo de compilacion.

            /**
             * Este método esta deprecado por Carlos Ríos el 07/03/2018 por ser inseguro.
             * usar en su reemplazo Auto(String marca, String modelo, String color)
             * @deprecated
             */
            @Deprecated
            Auto(){} //constructor vacio

            Auto(String marca, String modelo, String color){
                this.marca=marca;
                this.modelo=modelo;
                this.color=color;
                this.velocidad=0;
            }

                        // Métodos
                        void acelerar(){ 
                velocidad+=10; 
                if(velocidad>100) velocidad=100;
            }

                        void frenar() {	velocidad -= 10; }

                        // velocidad += 10 es lo mismo que velocidad = velociadad + 10
                        // velocidad -= 10 es lo mismo que velocidad = velociadad - 10

            @Override
            public String toString(){
                return this.marca+" "+this.modelo+" "+this.color+" "+this.velocidad;
            }
        } // Fin clase Auto


        // Objetos: son instancias de la clase y representa situaciones en particular
        // Los atributos numericos de una clase se inicializan en 0 automaticamente
        // los atributos String se inicializan en null automaticamente

        // creamos el objeto auto1
        System.out.println("-- auto1 --");
        Auto auto1=new Auto(); // llamando al constructor vacio
        auto1.marca="Ford";
        auto1.modelo="Focus";
        auto1.color="Verde";

        auto1.acelerar();       // 10
        auto1.acelerar();       // 20
        auto1.acelerar();       // 30
        auto1.frenar();         // 20

        System.out.println(auto1.marca+" "+auto1.modelo+" "+auto1.color+" "+auto1.velocidad);

        System.out.println("-- auto2 --");
        Auto auto2=new Auto();
        auto2.marca="Fiat";
        auto2.modelo="Idea";
        auto2.color="Rojo";

        for(int a=0;a<=45;a++) auto2.acelerar();

        System.out.println(auto2.marca+" "+auto2.modelo+" "+auto2.color+" "+auto2.velocidad);

        int x;
        // System.out.println(x);
        // Error no se puede imprimir una variable no inicilizada

        System.out.println("-- auto3 --");
        Auto auto3 = new Auto("Renault", "Kangoo", "Rojo");
        auto3.acelerar();

        // Método toString()
        // El metodo toString() esta definido en la clase padre Object y se ejecuta automaticamente 
        // al nombrar el objeto
        System.out.println(auto3.toString());
        System.out.println(auto3);


        // Falta ver Sobrecarga de métodos.
        // Encapsulamiento.
        // Java Bean
        // Sobrecarga de método main

    } // Fin Main

} // Fin clase Main
