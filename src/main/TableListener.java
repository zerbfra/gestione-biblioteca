package main;

import javax.swing.JTable;
import javax.swing.event.*;


/** Classe ascoltatore per la tabella, gestisce gli eventi che accadono sulle tabelle del programma **/
public class TableListener implements  ListSelectionListener {

	JTable table;
	String type;
	
	/** Costruttore **/
	public TableListener(JTable table,String type) {
		this.table=table;
		this.type=type;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent event) {
		// TODO Auto-generated method stub
		if (event.getValueIsAdjusting()) {
			return;
		}
		outputSelection();

	}
	/** Metodo che viene chiamato quando si seleziona una riga della tabella */
	private void outputSelection() {
		
		int row = table.getSelectionModel().getLeadSelectionIndex();
		int col = 0; // Mi interessa solo l'ID per eseguire tutte le mie funzioni, per convenzione è la colonna 0 in tutte le tabelle
		
		/* Distinzione delle azioni in base al tipo di tabella */
		if(type.equals("book")) Window.openBookInfo((Integer) getValueAt(row,col));
		if(type.equals("user")) Window.openUserInfo((Integer) getValueAt(row,col));
		if(type.equals("lend")) Window.openLendInfo((Integer) getValueAt(row,col));

	}

	private Object getValueAt(int row, int col) {
		return table.getValueAt(row, col);
	}

}
