package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



@SuppressWarnings("serial")

/** Classe che crea il pannello per la ricerca dei libri in prestito agli utenti,
 *  dato un utente specifico mi trova i libri attualmente in prestito.
 *  Totalmente identica come struttura a FindBookLend.
 */
public class FindUserLend extends JPanel implements ActionListener {

	
	private JTextField user;
	private JLabel txtUser;
	private JButton btnFind;
		
	protected FindUserLend() {
				
		this.setLayout(new BorderLayout(30,30));
		
		JLabel title=new JLabel("Trova prestiti utenti",JLabel.CENTER);
		title.setFont(new Font("", Font.BOLD, 14));
		this.add(title,BorderLayout.NORTH);	
		
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(3,1));

		user = new JTextField(20);
		txtUser = new JLabel("Inserisci il nome utente:");

		btnFind = new JButton("Cerca...");
		btnFind.addActionListener(this);

		grid.add(txtUser);
		grid.add(user);
		grid.add(Box.createGlue());

		
		this.add(grid,BorderLayout.CENTER);
		
		
		ImageIcon image = new ImageIcon("image/prestito.png");
		JLabel img = new JLabel("", image, JLabel.CENTER);
		this.add(img,BorderLayout.EAST);
		
	
		JPanel foot = new JPanel();
		foot.add(Box.createGlue());
		foot.add(btnFind);
		this.add(foot,BorderLayout.SOUTH);
		
	}
	
	public void actionPerformed(ActionEvent e) {		
		if (e.getSource() == btnFind) {
			
			/* Solito metodo di selezione dati per la ricerca */
			if (user.getText().equals("")) 
			{
				JLabel msg= new JLabel("Inserire il nome utente!");
				JOptionPane.showMessageDialog(null,msg); 
			} else Window.openFind("userlend",user.getText()); 
		}
	}
	
}
