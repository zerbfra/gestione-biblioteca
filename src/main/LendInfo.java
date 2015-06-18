package main;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class LendInfo extends JPanel implements ActionListener {

	private Lend l;
	private JButton btnLend;

	/** Costruttore per il layout della schermata **/
	public LendInfo(Integer id) {

		this.setLayout(new BorderLayout(30,30));

		/* Recupero le informazioni sul prestito */
		l = getInfo(id);

		JLabel title=new JLabel("Prestito del "+l.getStartdate(),JLabel.CENTER);
		title.setFont(new Font("", Font.BOLD, 14));
		this.add(title,BorderLayout.NORTH);

		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(7,1));

		JLabel lCod = new JLabel(" Codice prestito: "+l.getId());
		JLabel lCodL = new JLabel(" Codice libro: "+l.getId_book());
		JLabel lStart = new JLabel(" Data inizio prestito: "+l.getStartdate());
		JLabel lEnd = new JLabel(" Data fine prestito: "+l.getEnddate());


		grid.add(lCod);
		grid.add(lCodL);
		grid.add(lStart);
		grid.add(lEnd);


		this.add(grid,BorderLayout.CENTER);

		JPanel foot = new JPanel();
		foot.add(Box.createGlue());

		/* Aggiungo bottone per la restituzione */
		
		btnLend = new JButton("Restituisci");
		btnLend.addActionListener(this);
		foot.add(btnLend);
		foot.add(Box.createGlue());
		this.add(foot,BorderLayout.SOUTH);

	}

	/** Restituisce tutte le informazioni su un prestito **/
	private Lend getInfo(Integer id) {

		ResultSet rs;
		Lend l = new Lend();
		
		/* Reperisco tutte le informazioni tramite l'“d del prestito e le restituisco */
		rs = Database.Query("SELECT * FROM lending_view WHERE id_lend = '"+id+"'",Database.getConn(),false);
		try {
			rs.next();
			l.setId(rs.getInt("id_lend"));
			l.setId_book(rs.getInt("id_book"));
			l.setId_user(rs.getInt("id_user"));
			l.setStartdate(rs.getString("startdate"));
			l.setEnddate(rs.getString("enddate"));



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnLend) {
			/* Rientro del libro cliccando sul pulsante */
			l.returnLend();
			

		}
	}

}
