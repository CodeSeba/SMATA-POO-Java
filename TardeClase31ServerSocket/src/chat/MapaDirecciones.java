package chat;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapaDirecciones {
	
	public static Map<String,String> getMapa() {
		Map<String,String> mapa = new LinkedHashMap();
		mapa.put("Carlos", "172.16.11.1");
		mapa.put("Jose", "172.16.0.48");
		mapa.put("Joaquin", "172.16.0.39");
		mapa.put("Ariadna", "172.16.11.100");
		mapa.put("Sebastian", "172.16.0.100");
		return mapa;
	}
}
