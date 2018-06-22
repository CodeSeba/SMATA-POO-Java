package creation.factory;

public class InheritedFactory extends AbstractFactory {

	@Override
	protected Connection getConnection(String tipo) throws Exception {
		return (Connection)Class
				.forName(MapaConexiones
					.getMap()
					.get(tipo.toLowerCase()))
				.newInstance();
	}
}
