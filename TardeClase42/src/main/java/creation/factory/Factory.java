package creation.factory;

import creation.builder.aop.MapaAcciones;

public class Factory {
	protected String tipo;
	
	public Factory(String tipo) {
		this.tipo = tipo;
	}
	
	public Connection getConnection() throws Exception {
		return (Connection)Class
				.forName(MapaConexiones
					.getMap()
					.get(tipo.toLowerCase()))
				.newInstance();
	}
}
