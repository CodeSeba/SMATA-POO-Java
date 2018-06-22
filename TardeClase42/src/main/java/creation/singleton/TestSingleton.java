package creation.singleton;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class TestSingleton {
    public static void main(String[] args) {
        Singleton singleton1=Singleton.getSingleton();
        Singleton singleton2=Singleton.getSingleton();
        Singleton singleton3=Singleton.getSingleton();
        Singleton singleton4=Singleton.getSingleton();
        Singleton singleton5=Singleton.getSingleton();
        Singleton.cantidad();
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
        System.out.println(singleton3.hashCode());
        System.out.println(singleton4.hashCode());
        System.out.println(singleton5.hashCode());
        Hashtable<String,String> h;    // métodos estan synchronizados (Safe Thread)       Lento
        Map<String,String> map;        // métodos no syncronizados     (no Safe Thread)    Rapido
        
        //Interface Collections //Provee colecciones Syncronizadas parcialmente
        map=Collections.synchronizedMap(new HashMap<String,String>());
        map.put("lunes", "monday");
    }
}
