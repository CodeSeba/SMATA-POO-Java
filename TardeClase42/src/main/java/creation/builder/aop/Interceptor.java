package creation.builder.aop;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class Interceptor implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice {

	@Override
	public void before(Method method, Object[] os, Object o) throws Throwable {
		System.out.println("-- Inicio del método.");
	}
	
	@Override
	public void afterReturning(Object o, Method method, Object[] os, Object o1) throws Throwable {
		System.out.println("-- Fin del método.");
	}
	
	public void afterThrowing(ArithmeticException e) {
		System.out.println("Ocurrio una división / 0");
			}
	
	public void afterThrowing(Exception e) {
		System.out.println("Ocurrio un error no esperado.");
	}
}
