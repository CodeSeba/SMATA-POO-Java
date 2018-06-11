package tardeclase35;

import ar.org.centro8.curso.java.utils.SwingTable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JTable;

public class HiloTabla implements Runnable {
	private JTable tbl;
	private String server;
	private int port;
	private String[] metadato;
	private int time;
	
	public HiloTabla() { } // Temporal, borrar mas tarde

	public HiloTabla(JTable tbl, String server, int port, String[] metadato) {
		this.tbl = tbl;
		this.server = server;
		this.port = port;
		this.metadato = metadato;
		this.time = 2000;
	}
	
	@Override
	public void run() {
		while (true) {
			try(
					Socket so = new Socket(server,port);
					DataOutputStream out = new DataOutputStream(so.getOutputStream());
					DataInputStream in = new DataInputStream(so.getInputStream());
			){
				out.writeUTF("");
				SwingTable.cargar(tbl, in.readUTF().split("\n"), metadato);
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
