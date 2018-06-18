package creation.builder.aop.interceptors;

import creation.builder.aop.MapaAcciones;
import creation.builder.aop.Robot;
import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

public class InterceptorRobot implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] os, Object o) throws Throwable {
		if ( ! method.getName().equals("trabajar")) return;
		Class clazz = o.getClass();
		clazz.getDeclaredMethod("iniciar", null).invoke(o, null);
		Robot r = (Robot)o;
		r.getAcciones().forEach(item -> {
			try {
				clazz.getDeclaredMethod(MapaAcciones.getMap().get(item), null).invoke(o, null);
			} catch (Exception e) {
				System.out.println("Esta acción no la puedo ejecutar.");
			}
		});
		clazz.getDeclaredMethod("terminar", null).invoke(o, null);
	}
	
}
