package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




@SuppressWarnings("serial")

/** Classe per l'inserimento di un nuovo utente **/
public class NewUser extends JPanel implements ActionListener, ItemListener {
	
	
	private JTextField nome,cognome,cf,mail,tel,indirizzo,user,pwd;
	private JLabel txtNome,txtCognome,txtCf,txtMail,txtTel,txtIndirizzo,txtUser,txtPwd;
	private JButton btnAdd;
	private JCheckBox adminChk;
	private int isAdmin;
	    
	   
	
	/** Costruttore del pannello **/
	public NewUser() {
		
		
		this.setLayout(new BorderLayout(30,30));
		
		JLabel title=new JLabel("Inserisci utente",JLabel.CENTER);
		title.setFont(new Font("", Font.BOLD, 14));
		this.add(title,BorderLayout.NORTH);
		
		
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(9,2));
		
		nome = new JTextField(20);
		cognome = new JTextField(20);
		cf = new JTextField(20);
		mail = new JTextField(20);
		tel = new JTextField(20);
		indirizzo = new JTextField(20);
		user = new JTextField(20);
		pwd = new JTextField(20);
		
		txtNome = new JLabel("Nome:");
		txtCognome = new JLabel("Cognome:");
		txtCf = new JLabel("Codice Fiscale:");
		txtMail = new JLabel("E-Mail:");
		txtTel = new JLabel("Telefono:");
		txtIndirizzo = new JLabel("Indirizzo:");
		
		txtUser = new JLabel("Nome utente:");
		txtPwd = new JLabel ("Password:");
		
		adminChk = new JCheckBox("Admin");
		adminChk.setSelected(false);
		adminChk.addItemListener(this);
		
		btnAdd = new JButton("Inserisci");
		
		
		grid.add(txtNome);
		grid.add(nome);
		
		grid.add(txtCognome);
		grid.add(cognome);
		
		grid.add(txtCf);
		grid.add(cf);
		
		grid.add(txtMail);
		grid.add(mail);
		
		grid.add(txtTel);
		grid.add(tel);
		
		grid.add(txtIndirizzo);
		grid.add(indirizzo);
		
		grid.add(txtUser);
		grid.add(user);
		
		grid.add(txtPwd);
		grid.add(pwd);
		
		grid.add(Box.createGlue());
		grid.add(adminChk);
		
		this.add(grid,BorderLayout.CENTER);
	
		JPanel foot = new JPanel();
		foot.add(Box.createGlue());
		foot.add(btnAdd);
		this.add(foot,BorderLayout.SOUTH);
		
		ImageIcon image = new ImageIcon("image/newuser.png");
		JLabel img = new JLabel("", image, JLabel.CENTER);
		this.add(img,BorderLayout.EAST);
		
		btnAdd.addActionListener(this);
		
	}
	
	/** Evento generato dal check/uncheck della checkbox per essere admin **/
	public void itemStateChanged(ItemEvent ie) {
		Object source=ie.getItem();
		if (source==adminChk){
			if(adminChk.isSelected()) isAdmin = 1;
			else isAdmin= 0;
		}

	}
	
	
	/** Metodo per gestire btnAdd: aggiunge l'oggetto utente al database sql **/
	public void actionPerformed(ActionEvent e) {

	
		if(e.getSource() == this.btnAdd) {
			
			
			String tNome = nome.getText();
			String tCognome = cognome.getText();
			String tCf = cf.getText();
			String tMail = mail.getText();
			String tTel = tel.getText();
			String tIndirizzo = indirizzo.getText();
			String tUser = user.getText();
			String tPwd = pwd.getText();
			

			
			/* Esegui la query */
			
			Database.Query("INSERT INTO user (cf, nome, cognome, tel, indirizzo, mail, user, pwd, admin)" +
							"VALUES ('"+tCf+"', '"+tNome+"', '"+tCognome+"', '"+tTel+"', '"+tIndirizzo+"', '"+tMail+"', '"+tUser+"', '"+tPwd+"', '"+isAdmin+"')",Database.getConn(),false);
							
			
			/* Dopo l'inserimento rimuovo i dati precedenti, ora non più utili */
			nome.setText("");
			cognome.setText("");
			cf.setText("");
			mail.setText("");
			tel.setText("");
			indirizzo.setText("");
			user.setText("");
			pwd.setText("");
			
			
			/* Aggiorno il pannello con le nuove informazioni vuote */
			this.updateUI();
			
		}
	
	}
	
}
	

