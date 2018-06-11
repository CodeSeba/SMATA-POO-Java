package tardeclase34;

import ar.org.centro8.curso.java.utils.SwingTable;
import javax.swing.JTable;

public class HiloTabla implements Runnable {
	private JTable tbl;
	private String[] lista;
	private String[] metadato;
	private int time;
	
	public HiloTabla() { } // Temporal, borrar mas tarde

	public HiloTabla(JTable tbl, String server, int port, String[] metadato) {
		this.tbl = tbl;
		this.lista = lista;
		this.metadato = metadato;
		this.time = 2000;
	}
	
	@Override
	public void run() {
		while (true) {
			SwingTable.cargar(tbl, lista, metadato);
			try { Thread.sleep(time); } catch (Exception e) { }
		}
	}
	
	public void setFast()	{ time = 1000; }
	public void setNormal()	{ time = 2000; }
	public void setSlow()	{ time = 4000; }
	public void setIdle()	{ time = 10000; }

	public JTable getTbl() {
		return tbl;
	}

	public void setTbl(JTable tbl) {
		this.tbl = tbl;
	}

	public String[] getLista() {
		return lista;
	}

	public void setLista(String[] lista) {
		this.lista = lista;
	}

	public String[] getMetadato() {
		return metadato;
	}

	public void setMetadato(String[] metadato) {
		this.metadato = metadato;
	}
	
}
