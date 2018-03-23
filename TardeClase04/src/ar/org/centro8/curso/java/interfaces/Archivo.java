package ar.org.centro8.curso.java.interfaces;

public interface Archivo {
    // -Las interfaces no tienen atributos
    // -No tienen métodos constructores
    // -Si pueden tener atributos que sean constantes
    // -Todos los miembros de una interface son públicos y se pueden omitir
    // -Se pueden declarar métodos y parametros de entrada y salida, pero
    // -Los métodos no tiene código
    // -Las clases que implementen dicha interaface deben implementar el método abstracto
    // -Una clase pude implementar todas las interfaces que sean necesario
    
    void setText(String texto);
    String getText();
    void setFile(String file);
    String getFile();
    
    // Métodos default java 8
    // Los métodos default pueden contener código y son heredados a las clases que implementan
    // la interface.
    // Como una clase puede implementar muchas interfaces, hay una forma de herencia multiple.
    // Si creo un método llamado info() en esta interface, una clase que implemente
    // esta interface no podra implementar otra interface que otro método default info()
    
    default void info(){
        System.out.println("Interface Archivo");
    }
}
