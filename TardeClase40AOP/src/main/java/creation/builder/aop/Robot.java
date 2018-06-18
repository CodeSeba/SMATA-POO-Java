package creation.builder.aop;

import java.util.List;

public interface Robot {
	
	void trabajar() throws Exception;
	void cargarAcciones(List<String>acciones);
	List<String>getAcciones();
}
