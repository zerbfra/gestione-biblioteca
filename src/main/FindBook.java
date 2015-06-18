package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


@SuppressWarnings("serial")

/** Classe per la creazione del pannello di ricerca libri, non esegue la query ma la richiede alla classe SearchResult **/
public class FindBook extends JPanel implements ActionListener {
	
	
	private JTextField isbn,keyword;
	private JLabel txtIsbn,txtKeyword,txtO;
	private JButton btnFind;
	
	/** Costruttore per il layout della schermata **/
	protected FindBook() {
		
		
		this.setLayout(new BorderLayout(30,30));
		
		JLabel title=new JLabel("Trova libro",JLabel.CENTER);
		title.setFont(new Font("", Font.BOLD, 14));
		this.add(title,BorderLayout.NORTH);
			
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(3,2));
		
		isbn = new JTextField(20);
		keyword = new JTextField(20);

		txtIsbn = new JLabel("ISBN:");
		txtO = new JLabel("- o -");
		txtKeyword = new JLabel("Parola chiave:");

		btnFind = new JButton("Cerca...");
		btnFind.addActionListener(this);
	
		grid.add(txtIsbn);
		grid.add(isbn);
		grid.add(txtO);
		grid.add(Box.createGlue());
		grid.add(txtKeyword);
		grid.add(keyword);
		
		this.add(grid,BorderLayout.CENTER);
		
		ImageIcon image = new ImageIcon("image/search96.png");
		JLabel img = new JLabel("", image, JLabel.CENTER);
		
		this.add(img,BorderLayout.EAST);
		
		JPanel foot = new JPanel();
		foot.add(Box.createGlue());
		foot.add(btnFind);
		this.add(foot,BorderLayout.SOUTH);
		
	}
	
	/** Metodo per l'individuazione delle azioni **/
	public void actionPerformed(ActionEvent e) {	
		
		if (e.getSource() == btnFind) {
			
			if (isbn.getText().equals("") && keyword.getText().equals("")) 
			{
				/* Nessun dato inserito */
				JLabel msg= new JLabel("Inserire ISBN oppure parola di ricerca");
				JOptionPane.showMessageDialog(null,msg); 
				
			} else if (isbn.getText().equals("")) {
				/* Inserita solo la keyword */
				Window.openFind("book",keyword.getText());
			} else if (keyword.getText().equals("")) {
				/* Inserito solo ISBN */
				Window.openFind("book",isbn.getText());
			} else Window.openFind("book",isbn.getText()); /* Inseriti entrambi, adotto ISBN */
		}
	}
	
}
