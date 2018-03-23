package ar.org.centro8.curso.java.maps;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapaSemana {
    Map<Integer,String> mapaSemana = new LinkedHashMap();
    
    public Map<Integer,String> getMapa(){
        mapaSemana.put(1, "Lunes");
        mapaSemana.put(2, "Martes");
        mapaSemana.put(3, "Miércoles");
        mapaSemana.put(4, "Jueves");
        mapaSemana.put(5, "Viernes");
        mapaSemana.put(6, "Sábado");
        mapaSemana.put(7, "Domingo");
        return mapaSemana;
    }
    
    public Map<Integer,String> getMapaCatolico(){
        mapaSemana.put(7, "Domingo");
        mapaSemana.put(1, "Lunes");
        mapaSemana.put(2, "Martes");
        mapaSemana.put(3, "Miércoles");
        mapaSemana.put(4, "Jueves");
        mapaSemana.put(5, "Viernes");
        mapaSemana.put(6, "Sábado");
        return mapaSemana;
    }
    
    public Map<Integer,String> getMapaIngles(){
        mapaSemana.put(1, "Monday");
        mapaSemana.put(2, "Tuesday");
        mapaSemana.put(3, "Wednesday");
        mapaSemana.put(4, "Thursday");
        mapaSemana.put(5, "Friday");
        mapaSemana.put(6, "Saturday");
        mapaSemana.put(7, "Sunday");
        return mapaSemana;
    }
}
