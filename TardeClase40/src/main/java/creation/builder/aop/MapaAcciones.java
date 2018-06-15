package creation.builder.aop;

import java.util.HashMap;
import java.util.Map;

public class MapaAcciones {
	
	public static Map<String,String> getMap() {
		Map<String,String> mapa = new HashMap();
		mapa.put("Ingredientes", "getIngredientes");
		mapa.put("Armar", "armar");
		mapa.put("Revisar", "revisar");
		mapa.put("Parts", "getIngredientes");
		mapa.put("Build", "armar");
		mapa.put("Check", "revisar");
		return mapa;
	}
}
