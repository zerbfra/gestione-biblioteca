package main;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;


import javax.swing.*;




@SuppressWarnings("serial")

/** Classe per il rientro dei libri in biblioteca **/
public class ReturnBook extends JPanel implements ActionListener {

	private JTextField isbn;
	private JLabel txtIsbn;
	private JButton btnFind;

	/** Costruttore per il layout della schermata **/
	public ReturnBook() {

		this.setLayout(new BorderLayout(30,30));

		JLabel title=new JLabel("Restituisci libro",JLabel.CENTER);
		title.setFont(new Font("", Font.BOLD, 14));
		this.add(title,BorderLayout.NORTH);

		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(3,2));

		isbn = new JTextField(20);
		txtIsbn = new JLabel("ISBN:");

		btnFind = new JButton("Restituisci");
		btnFind.addActionListener(this);

		grid.add(txtIsbn);
		grid.add(isbn);

		grid.add(Box.createGlue());

		ImageIcon image = new ImageIcon("image/code.png");
		JLabel img = new JLabel("", image, JLabel.CENTER);
		this.add(img,BorderLayout.EAST);

		this.add(grid,BorderLayout.CENTER);

		JPanel foot = new JPanel();
		foot.add(Box.createGlue());
		foot.add(btnFind);
		this.add(foot,BorderLayout.SOUTH);

	}

	/** Metodo per l'individuazione delle azioni, restituzione libro **/
	public void actionPerformed(ActionEvent e) {	


		if (e.getSource() == btnFind) {

			if (isbn.getText().equals("")) 
			{
				/* Nessun dato inserito */
				JLabel msg= new JLabel("Inserire ISBN!");
				JOptionPane.showMessageDialog(null,msg); 

			} else {

				/* Dati inseriti ed eseguo la query al database */
				ResultSet rs = Database.Query("SELECT * FROM lending_view WHERE isbn = '"+isbn.getText()+"' AND id_user = '"+LoginPanel.getUser().getId()+"' AND returndate = '0000-00-00'",Database.getConn(),true);
				Lend l = new Lend();

				try {
					if(rs.next()) {
						/* Libro presente, aggiorno la vista prestiti inserento la data di ritorno del libro */
						l.setId(rs.getInt("id_lend"));
						l.setId_book(rs.getInt("id_book"));
						l.setId_user(rs.getInt("id_user"));
						l.setStartdate(rs.getString("startdate"));
						l.setEnddate(rs.getString("enddate"));

						l.returnLend();

					}else {			
						/* Il libro non è presente nel database e quindi è già stato restituito dal cliente */
						JLabel msg1= new JLabel("Libro già restituito!");
						JOptionPane.showMessageDialog(null,msg1); 
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
	}

}
