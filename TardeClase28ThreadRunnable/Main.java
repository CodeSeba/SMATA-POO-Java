public class Main {
	
	public static void main(String[] args) {
		System.out.println("Hola Mundo!");
		for (String st : args) System.out.println(st);
		
		/*
		 * 	Tarea 1		Leer Archivo 1 del medio 1					10s
		 * 	Tarea 2		Leer Archivo 2 del medio 2					10s
		 * 	Tarea 3		Abrir un form y mostrar info de archivos	1s
		 * 
		 *     Tarea 1    Tarea 2  Tarea 3
		 *  |----------|----------|-|
		 *       10s        10s    1s
		 * 
		 * 	Tiempo total: 21s
		 *
		 *     Tarea 1
		 *  |----------|
		 *       10s
		 * 
		 *     Tarea 2
		 *  |----------|
		 *       10s
		 * 
		 *              Tarea 3
		 *             |-|
		 *              1s
		 * 
		 * 	Tiempo total 11s
		 * 
		 *     Tarea 1
		 *  |----------|
		 *       10s
		 * 
		 *     Tarea 2
		 *  |----------|
		 *       10s
		 * 
		 *   Tarea 3
		 *  |-|
		 *   1s
		 * 
		 * 	Tiempo total 11s
		 */
	
	class Hilo extends Thread {
		
		private String nombre;
		
		public Hilo(String nombre) {
			this.nombre = nombre;
		}
		
		@Override
		public void run() {
			for (int a=1 ; a <= 20; a++) {
				System.out.println(nombre + ": " + a);
				try { Thread.sleep(500); }	catch(Exception e) { }
			}
		}
	} // end class Hilo
	
	//Hilo hilo1 = new Hilo("hilo1");
	//Hilo hilo2 = new Hilo("hilo2");
	//Hilo hilo3 = new Hilo("hilo3");
	//Hilo hilo4 = new Hilo("hilo4");
	
	// Método run: CUIDADO! no ejecuta en un nuevo Thread
	//hilo1.run();
	//hilo2.run();
	//hilo3.run();
	//hilo4.run();
	
	// El método start() ejecuta el método en un Thread nuevo.
	//hilo1.start();
	//hilo2.start();
	//hilo3.start();
	//hilo4.start();
	
	// Interfaz Runnable
	class HiloRunnable implements Runnable {
		
		private String nombre;
		
		public HiloRunnable(String nombre) {
			this.nombre = nombre;
		}
		
		@Override
		public void run() {
			for (int a=1 ; a <= 20 ; a++) {
				System.out.println(nombre + ": " + a);
				try { Thread.sleep(500); } catch(Exception e) { }
			}
		} // end class HiloRunnable
	}
		
		HiloRunnable hiloRunnable1 = new HiloRunnable("Hilo1");
		HiloRunnable hiloRunnable2 = new HiloRunnable("Hilo2");
		HiloRunnable hiloRunnable3 = new HiloRunnable("Hilo3");
		HiloRunnable hiloRunnable4 = new HiloRunnable("Hilo4");
		
		Thread t1 = new Thread(hiloRunnable1);
		Thread t2 = new Thread(hiloRunnable2);
		Thread t3 = new Thread(hiloRunnable3);
		Thread t4 = new Thread(hiloRunnable4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		new Thread(new HiloRunnable("Hilo5")).start();
	
	} // end main
} // end class Main
