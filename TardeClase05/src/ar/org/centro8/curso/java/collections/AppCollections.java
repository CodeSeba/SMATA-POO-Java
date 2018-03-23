package ar.org.centro8.curso.java.collections;

import ar.org.centro8.curso.java.entities.Auto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class AppCollections {
    public static void main(String[] args) {
        // Clase 05 Collections
        
        Auto[] autos = new Auto[4];
        autos[0] = new Auto("Fiat", "Uno", "Gris");
        autos[1] = new Auto("Renault", "Kango", "Bordo");
        autos[2] = new Auto("Ford", "Fiesta", "Blanco");
        autos[3] = new Auto("Peugeot", "207", "Negro");
        
        // Recorrido con indice
        System.out.println("--- Recorrido con indice ---");
        for (int a=0 ; a < autos.length ; a++) System.out.println(autos[a]);
        
        // Recorrido foreach
        System.out.println("--- Recorrido foreach ---");
        for (Auto auto:autos) System.out.println(auto);
        
        // Interface List
        List lista = new ArrayList();
        lista.add(new Auto("VW", "UP", "Rojo"));
        lista.add(new Auto("Chevrolet", "Corsa", "Verde"));
        lista.add(new Auto("VW", "Gol", "Negro"));
        lista.add("Hola");
        lista.add(24);
        
        // Recorrido con indice
        System.out.println("--- Recorrido con indice ---");
        for (int a=0 ; a < lista.size() ; a++) System.out.println(lista.get(a));
        
        // Recorrido foreach
        System.out.println("--- Recorrido foreach ---");
        for (Object obj:lista) System.out.println(obj);
        
        // Recorrido java 8
        System.out.println("--- Recorrido java 8 ---");
        lista.forEach(item -> System.out.println(item));
        
        System.out.println("--- Uso de 4 puntos ---");
        lista.forEach(System.out::println);
        
        // Copiamos los autos del vector autos a la lista.
        for (Auto auto:autos) lista.add(auto);
        System.out.println("--- Copiamos del colection autos a la list lista ---");
        lista.forEach(System.out::println);
        
        // Uso de Generics java 5
        List<Auto> listaAuto = new ArrayList();
        listaAuto.add(new Auto("Renault", "Clio", "Azul"));
        listaAuto.add(new Auto("Ford", "Ka", "Negro"));
        
        Auto auto1 = (Auto)lista.get(0);
        Auto auto2 = listaAuto.get(0);
        
        // Copiar los autos de la lista a listaAuto
        lista.forEach(item -> {
            if (item instanceof Auto) listaAuto.add((Auto)item);
        });
        
        System.out.println("-- Recorrido de listaAuto ---");
        listaAuto.forEach(System.out::println);
        
        // Interface Set
        // Funciona igual a List, representa un vector pero
        // no permite valores duplicados
        
        Set<String> setString = null;
        
        // Implementación HashSet
        // Esta implementación es la más veloz de todas pero
        // no garantiza el orden de los elementos
        setString = new HashSet();
        
        setString.add("Lunes");
        setString.add("Martes");
        setString.add("Martes");
        setString.add("Miércoles");
        setString.add("Jueves");
        setString.add("Viernes");
        setString.add("Viernes");
        setString.add("Sabado");
        setString.add("Domingo");
        
        
        System.out.println("--- Recorrido de setString con HashSet ---");
        setString.forEach(System.out::println);
        
        // Implementación TreeSet
        // Almacena los elementos en un arbol en orden natural
        
        setString = new TreeSet();
        
        setString.add("Lunes");
        setString.add("Martes");
        setString.add("Martes");
        setString.add("Miércoles");
        setString.add("Jueves");
        setString.add("Viernes");
        setString.add("Viernes");
        setString.add("Sabado");
        setString.add("Domingo");
        
        
        System.out.println("--- Recorrido de setString con TreeSet ---");
        setString.forEach(System.out::println);
        
        // Implementacion LinkedHashSet
        // Almacena los elementos por orden de ingreso
        
        setString = new LinkedHashSet();
        
        setString.add("Lunes");
        setString.add("Martes");
        setString.add("Martes");
        setString.add("Miércoles");
        setString.add("Jueves");
        setString.add("Viernes");
        setString.add("Viernes");
        setString.add("Sabado");
        setString.add("Domingo");
        
        System.out.println("--- Recorrido de setString con LinkedHahsSet ---");
        setString.forEach(System.out::println);
        
        Set<Auto> setAutos = new LinkedHashSet();
        setAutos.add(new Auto("Fiat", "Duna", "Blanco"));
        setAutos.add(new Auto("Fiat", "Duna", "Blanco"));
        setAutos.add(new Auto("Fiat", "Duna", "Negro"));
        setAutos.add(listaAuto.get(0));
        setAutos.add(listaAuto.get(0));
        
        System.out.println("--- Recorrido de SetAutos ---");
        setAutos.forEach(item -> System.out.println(item + "\t" + item.hashCode()));
        
        // Pila - Stack: LIFO Last In First Out
        // Cola - Queue: FIFO First In First Out
        
        // Clase Stack
        Stack<Auto> pilaAuto = new Stack();
        pilaAuto.push(new Auto("Fiat", "600", "Amarillo")); // método push() apila un elemento a la lista
        pilaAuto.addAll(listaAuto);
        
        System.out.println("--- Recorrido de pilaAuto ---");
        pilaAuto.forEach(System.out::println);
        
        System.out.println("Longitud de pila:" + pilaAuto.size());
        
        while (!pilaAuto.isEmpty()) System.out.println(pilaAuto.pop());
        
        System.out.println("Longitud de pila:" + pilaAuto.size());
        
        // Interface PriorityQueue
        Queue<Auto> colaAuto = new LinkedList();
        colaAuto.offer(new Auto("Fiat", "600", "Amarillo"));
        // Método offer encola un elemento
        
        colaAuto.addAll(listaAuto);
        
        System.out.println("--- Recorrido de colaAuto ---");
        colaAuto.forEach(System.out::println);
        
        System.out.println("Longitud colaAuto:" + colaAuto.size());
        
        while (!colaAuto.isEmpty()) System.out.println(colaAuto.poll());
        // Método poll descola un elemento
        
        System.out.println("Longitud colaAuto:" + colaAuto.size());
    }
}
