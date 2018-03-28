package tardeclase11fx;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapaColores {
    public static Map<String,String> getMapa() {
        Map<String,String> mapaColores = new LinkedHashMap();
        mapaColores.put("Rojo", "red");
        mapaColores.put("Verde", "green");
        mapaColores.put("Azul", "blue");
        mapaColores.put("Blanco", "white");
        mapaColores.put("Negro", "black");
        mapaColores.put("Amarillo", "yellow");
        return mapaColores;
    }
}
