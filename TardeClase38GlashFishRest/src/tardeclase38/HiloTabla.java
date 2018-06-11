package tardeclase38;

import ar.org.centro8.curso.java.utils.SwingTable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

public class HiloTabla implements Runnable {
	private JTable tbl;
	private String url;
	private String[] metadato;
	private int time;
	
	public HiloTabla() { } // Temporal, borrar mas tarde

	public HiloTabla(JTable tbl, String url, String[] metadato) {
		this.tbl = tbl;
		this.url = url;
		this.metadato = metadato;
		this.time = 2000;
	}
	
	@Override
	public void run() {
		while (true) {
			try(
					BufferedReader in = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
			){
				String response = "";
				List<String> lista = new ArrayList();
				in.lines().forEach(lista::add);
				for ( String st : lista ) response += st+"\n";
				SwingTable.cargar(tbl, response.split("\n"), metadato);
			} catch (Exception e) {
				e.printStackTrace();
			}
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

	public String[] getMetadato() {
		return metadato;
	}

	public void setMetadato(String[] metadato) {
		this.metadato = metadato;
	}
	
}
