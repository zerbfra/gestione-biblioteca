package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




@SuppressWarnings("serial")

/** Classe per la creazione del pannello di ricerca utenti, non esegue la query ma la richiede alla classe SearchResult **/
public class FindUser extends JPanel implements ActionListener {
	
	private JTextField cf,mail;
	private JLabel txtCf,txtMail,txtO;
	private JButton btnFind;
	
	/** Costruttore per il layout della schermata **/
	protected FindUser() {
		
		
		this.setLayout(new BorderLayout(30,30));
		
		JLabel title=new JLabel("Trova utente",JLabel.CENTER);
		title.setFont(new Font("", Font.BOLD, 14));
		this.add(title,BorderLayout.NORTH);
			
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(3,2));
		
		cf = new JTextField(20);
		mail = new JTextField(20);

		txtCf = new JLabel("Codice Fiscale:");
		txtO = new JLabel("- o -");
		txtMail = new JLabel("E-Mail:");

		btnFind = new JButton("Cerca...");
		btnFind.addActionListener(this);
	
		grid.add(txtCf);
		grid.add(cf);
		grid.add(txtO);
		grid.add(Box.createGlue());
		grid.add(txtMail);
		grid.add(mail);
		
		this.add(grid,BorderLayout.CENTER);
	
		JPanel foot = new JPanel();
		foot.add(Box.createGlue());
		foot.add(btnFind);
		this.add(foot,BorderLayout.SOUTH);
		ImageIcon image = new ImageIcon("image/group96.png");
		JLabel img = new JLabel("", image, JLabel.CENTER);
		this.add(img,BorderLayout.EAST);
		
	}
	
	/** Metodo per l'individuazione delle azioni **/
	public void actionPerformed(ActionEvent e) {	
		
		if (e.getSource() == btnFind) {
			
			if (mail.getText().equals("") && cf.getText().equals("")) 
			{
				/* Nessun dato inserito */
				JLabel msg= new JLabel("Inserire codice fiscale o mail dell'utente");
				JOptionPane.showMessageDialog(null,msg); 
				
			} else if (cf.getText().equals("")) {
				/* Inserita solo la mail */
				Window.openFind("user",mail.getText());
			} else if (mail.getText().equals("")) {
				/* Inserito solo il codice fiscale */
				Window.openFind("user",cf.getText());
			} else Window.openFind("user",mail.getText()); /* Inseriti entrambi, adotto la mail */
		}
	}
	
}
