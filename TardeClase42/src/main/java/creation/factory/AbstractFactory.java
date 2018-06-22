package creation.factory;

public abstract class AbstractFactory {
	
	public AbstractFactory() {	}
	
	protected abstract Connection getConnection(String tipo) throws Exception;
}
