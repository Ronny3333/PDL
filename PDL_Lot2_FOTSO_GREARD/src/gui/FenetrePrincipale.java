package gui;

/*
 * FenetrePrincipale est une classe de tests
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import javax.swing.JLabel;

public class FenetrePrincipale {

	private JFrame frame;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldDateDeNaissance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetrePrincipale window = new FenetrePrincipale();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FenetrePrincipale() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * Page d'Accueil
		 */
		
		JPanel pageAccueil = new JPanel();
		pageAccueil.setLayout(null);
		frame.getContentPane().add(pageAccueil);
		
		JButton boutonInscription = new JButton("Inscription");
		boutonInscription.setBounds(100, 200, 150, 50);
		pageAccueil.add(boutonInscription);
		
		JLabel titreAccueil = new JLabel("ARMADA 2023");
		titreAccueil.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 30));
		titreAccueil.setHorizontalAlignment(SwingConstants.CENTER);
		titreAccueil.setBounds(210, 11, 300, 80);
		pageAccueil.add(titreAccueil);
		
		JButton boutonConnexion = new JButton("Connexion");
		boutonConnexion.setBounds(470, 200, 150, 50);
		pageAccueil.add(boutonConnexion);
		
		/**
		 * Page d'Inscription
		 */
		
		JPanel pageInscription = new JPanel();
		pageInscription.setLayout(null);
		
		JLabel titreInscription = new JLabel("Inscription : ");
		titreInscription.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 30));
		titreInscription.setBounds(10, 11, 300, 80);
		pageInscription.add(titreInscription);
		
		JLabel texteNatureParticipant = new JLabel("Nature du participant : ");
		texteNatureParticipant.setBounds(495, 35, 200, 80);
		pageInscription.add(texteNatureParticipant);
		
		String choix[] = {" ", "Delegation", "Entreprise", "Bateau", "Commercant", "Famille d'Accueil", "VIP"};
		JComboBox choixParticipant = new JComboBox(choix);
		choixParticipant.setBounds(447, 127, 214, 29);
		pageInscription.add(choixParticipant);
		
		JLabel textePersonneMorale = new JLabel("Personne Morale");
		textePersonneMorale.setBounds(54, 134, 120, 14);
		pageInscription.add(textePersonneMorale);
		
		JLabel texteNom = new JLabel("Nom : ");
		texteNom.setBounds(54, 166, 46, 14);
		pageInscription.add(texteNom);
		
		JLabel textePrenom = new JLabel("Prenom : ");
		textePrenom.setBounds(54, 249, 100, 14);
		pageInscription.add(textePrenom);
		
		JLabel texteDateDeNaissance = new JLabel("Date de naissance : ");
		texteDateDeNaissance.setBounds(54, 326, 178, 14);
		pageInscription.add(texteDateDeNaissance);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(54, 199, 100, 20);
		pageInscription.add(textFieldNom);
		textFieldNom.setColumns(10);
		
	    textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(54, 274, 100, 20);
		pageInscription.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		textFieldDateDeNaissance = new JTextField();
		textFieldDateDeNaissance.setBounds(54, 351, 100, 20);
		pageInscription.add(textFieldDateDeNaissance);
		textFieldDateDeNaissance.setColumns(10);
		
		JButton boutonSuivantInsc1 = new JButton("Suivant");
		boutonSuivantInsc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		boutonSuivantInsc1.setBounds(605, 407, 89, 23);
		pageInscription.add(boutonSuivantInsc1);
		
		
		boutonInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageAccueil.setVisible(false);
				frame.getContentPane().add(pageInscription);
				pageInscription.setVisible(true);
			}
		});
		
		
	}
}
