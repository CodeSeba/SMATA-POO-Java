package creation.factory;

import java.util.HashMap;
import java.util.Map;

public class MapaConexiones {
	public static Map<String,String> getMap() {
		Map<String,String> mapaConexiones = new HashMap();
		mapaConexiones.put("generic",		"creation.factory.ConnectionGeneric");
		mapaConexiones.put("oracle",		"creation.factory.ConnectionOracle");
		mapaConexiones.put("sqlserver",		"creation.factory.ConnectionSQLServer");
		mapaConexiones.put("mysql",			"creation.factory.ConnectionMySQL");
		mapaConexiones.put("postgresql",	"creation.factory.ConnectionPostgradeSQL");
		mapaConexiones.put("mysql",			"creation.factory.ConnectionMySQL");
		mapaConexiones.put("postgre",		"creation.factory.ConnectionPostgreSQL");
		return mapaConexiones;
	}
}
