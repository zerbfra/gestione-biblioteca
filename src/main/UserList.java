package main;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;



@SuppressWarnings("serial")

/** Classe che fornisce la lista utenti nel pannello di amministrazione **/
public class UserList extends JPanel {
	

	
	/** Costruttore che crea il layout della schermata ed esegue la query **/
	public UserList() {
		
		
		this.setLayout(new BorderLayout(30,30));
		
		JLabel title=new JLabel("Lista utenti registrati",JLabel.CENTER);
		title.setFont(new Font("", Font.BOLD, 14));
		this.add(title,BorderLayout.NORTH);
		
		
		JPanel grid = new JPanel();
		grid.setLayout(new FlowLayout());
		
		/* Eseguo la query sul db */
		ResultSet rs;
		rs = Database.Query("SELECT * FROM user",Database.getConn(),false);
				
		
		/* Modello per la JTable, a cui vengono aggiunte le varie colonne */
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("ID");
		model.addColumn("Nome");
		model.addColumn("Cognome");
		model.addColumn("Codice fiscale");
		model.addColumn("E-mail");
		model.addColumn("Telefono");
		model.addColumn("Indirizzo");

	
		/* Inserisco i dati in tabella */
		try {
			while (rs.next()) {	
				model.insertRow(model.getRowCount(), new Object[]{ rs.getInt("id"), rs.getString("nome"), rs.getString("cognome"), rs.getString("cf"), rs.getString("mail"), rs.getString("tel"), rs.getString("indirizzo") });

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane();
		
		/* Aggiungo il Listener, per riga */
		table.getSelectionModel().addListSelectionListener(new TableListener(table,"user"));
		
		scrollPane.getViewport().add(table);
		scrollPane.setPreferredSize(new Dimension(800,400));
				
		grid.add(scrollPane);

		this.add(grid,BorderLayout.CENTER);
	
		JPanel foot = new JPanel();
		foot.add(Box.createGlue());
		this.add(foot,BorderLayout.SOUTH);
		
	}


}
