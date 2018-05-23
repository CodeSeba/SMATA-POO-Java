package ar.org.centro8.curso.java.services;

public class TardeClase32 {

	public static void main(String[] args) {
		/*
		 * Nombre			ParametrosEntrada					Port	ParametrosSalida
		 * ============		=================================	====	========================================
		 * AlumnosAltas		nombre, apellido, edad, curso		8001	id
		 * AlumnosBajas		id									8002	true/false
		 * AlumnosModif		id, nombre, apellido, edad, curso	8003	true/false
		 * AlumnosGet		id									8004	id, nombre, apellido, edad, curso
		 * AlumnosList		filtro								8005	List [id, nombre, apellido, edad, idCurso]
		 *
		 * CursosAltas		titulo, profesor, dia, turno		8010	id
		 * CursosBajas		id									8011	true/false
		 * CursosModif		id, titulo, profesor, dia, turno	8012	true/false
		 * CursosGet		id									8013	id, titulo, profesor, dia, turno
		 * CursosList		filtro								8014	List [id, titulo, profesor, dia, turno]
		 */
		
		new Thread(new AlumnosAltasService()).start();
		new Thread(new AlumnosBajasService()).start();
		new Thread(new AlumnosGetService()).start();
		new Thread(new AlumnosModifService()).start();
	}
	
}