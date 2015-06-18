package main;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;





@SuppressWarnings("serial")

/** Classe del pannello che mostra la lista dei libri presenti del database.
 *  Si avvale di una JTable che mostra i vari libri recuperati con una query SQL
 */
public class BookList extends JPanel {


	JTable table;

	/** Costruttore del pannello, si occupa di inserire i vari elementi e formulare la query al database **/
	public BookList() {
		

		/* Inserisco un layout BorderLayout */
		this.setLayout(new BorderLayout(30,30));

		/* Titolo del pannello */
		JLabel title=new JLabel("Lista libri",JLabel.CENTER);
		title.setFont(new Font("", Font.BOLD, 14));
		this.add(title,BorderLayout.NORTH);

		/* Pannello FlowLayout */
		JPanel grid = new JPanel();
		grid.setLayout(new FlowLayout());

		/* Inoltro la query */
		ResultSet rs = Database.Query("SELECT * FROM book",Database.getConn(),false);

		/* Modello per la JTable, a cui vengono aggiunte le varie colonne */
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("ISBN");
		model.addColumn("Titolo");
		model.addColumn("Autore");
		model.addColumn("Editore");
		model.addColumn("Pag."); 

		try {
			while (rs.next()) {	
				/* Inserisco le righe con le informazioni */
				model.insertRow(model.getRowCount(), new Object[]{ rs.getInt("id"), rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getString("numpages") });

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* Includo uno scroller nella tabella, in modo da visualizare tutti i record in una piccola schermata */
		JScrollPane scrollPane = new JScrollPane();
		
		/* Inizializzo la tabella e le assegno il modello creato e le relative righe */
		table = new JTable(model);

		/* Gestisco il layout della tabella, in modo che sia graficamente comprensibile */
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(95);

		/* Aggiungo il Listener */
		table.getSelectionModel().addListSelectionListener(new TableListener(table,"book"));

		/* Aggiungo lo scroller alla tabella e ne assegno una dimensione di default */
		scrollPane.getViewport().add(table);
		scrollPane.setPreferredSize(new Dimension(800,400));

		/* Aggiungo al pannello lo scroller (e di conseguenza la tabella in esso contenuta */
		grid.add(scrollPane);
		/* Aggiungo grid al pannello centralmente */
		this.add(grid,BorderLayout.CENTER);

	}

}


