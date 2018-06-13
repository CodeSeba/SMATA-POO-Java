package creation.singleton;

public final class Singleton {
	private static Singleton singleton = null;
	private static int cont = 0;
	
	private Singleton() {
		System.out.println("Se creo un objeto de Singleton");
	}
	
	public static Singleton getSingleton() {
		System.out.println("--- Inicio de método ---");
		cont++;
		synchronized (new Object()) {
			if (singleton == null) singleton = new Singleton();
		}
		System.out.println("--- Fin de método ---");
		return singleton;
	}
	
	public static void cantidad() {
		System.out.println("Se ejecuto el método getSingleton() " + cont + " veces.");
	}
}
