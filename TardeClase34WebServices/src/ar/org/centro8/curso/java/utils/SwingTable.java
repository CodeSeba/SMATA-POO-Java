package ar.org.centro8.curso.java.utils;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SwingTable {
	
	public static void cargar(JTable tbl, String[] lista, String[] metaDato) {
		if ( tbl == null || lista == null || metaDato == null ) return;
		DefaultTableModel modelo = new DefaultTableModel();
		tbl.setModel(modelo);

		for (String st : metaDato) modelo.addColumn(st);
		for (String st : lista) modelo.addRow(st.split(","));
	}
}
