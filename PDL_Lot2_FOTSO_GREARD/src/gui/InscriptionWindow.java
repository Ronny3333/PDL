package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import dao.DatePersoDAO;
import dao.DelegationDAO;
import dao.ParticipantDAO;
import dao.PersonneMoraleDAO;
import model.DatePerso;
import model.Delegation;
import model.Participant;
import model.PersonneMorale;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DropMode;

public class InscriptionWindow{

	private JFrame frameInscription;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldDateJour;
	private JTextField textFieldIdentifiant;
	private JTextField textFieldMdp;
	private JTextField textFieldNbPersonnesDelegation;
	private JTextField textFieldPaysDelegation;
	private JTextField textFieldNomEntreprise;
	private JTextField textFieldImmatriculation;
	private JTextField textFieldNomBateau;
	private JTextField textFieldTailleBateau;
	private JTextField textFieldPavillon;
	private JTextField textFieldDateMois;
	private JTextField textFieldDateAnnee;
	
	final static int xPersonneMorale = 55;
	final static int xParticipant = 312;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscriptionWindow window = new InscriptionWindow();
					window.frameInscription.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InscriptionWindow() {
		
		frameInscription = new JFrame();
		frameInscription.setTitle("Inscription");
		frameInscription.setBounds(100, 100, 720, 480);
		frameInscription.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * INSCRIPTION N1
		 */
		
		JPanel panelN1 = new JPanel();
		frameInscription.getContentPane().add(panelN1, BorderLayout.CENTER);
		panelN1.setLayout(null);
		
		JLabel titreInscription = new JLabel("Inscription : ");
		titreInscription.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 30));
		titreInscription.setBounds(10, 11, 300, 53);
		panelN1.add(titreInscription);
		
		/**
		 * Information concerning PersonneMorale class
		 */
		
		JLabel textePersonneMorale = new JLabel("Personne Morale");
		textePersonneMorale.setFont(new Font("Tahoma", Font.BOLD, 13));
		textePersonneMorale.setBounds(xPersonneMorale, 100, 120, 14);
		panelN1.add(textePersonneMorale);
		
		JLabel texteNom = new JLabel("Nom : ");
		texteNom.setBounds(xPersonneMorale, 132, 46, 14);
		panelN1.add(texteNom);
		
		JLabel textePrenom = new JLabel("Pr\u00E9nom : ");
		textePrenom.setBounds(xPersonneMorale, 215, 100, 14);
		panelN1.add(textePrenom);
		
		JLabel texteDateDeNaissance = new JLabel("Date de naissance : ");
		texteDateDeNaissance.setBounds(xPersonneMorale, 292, 178, 14);
		panelN1.add(texteDateDeNaissance);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(xPersonneMorale, 165, 100, 20);
		panelN1.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(xPersonneMorale, 240, 100, 20);
		panelN1.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		textFieldDateJour = new JTextField();
		textFieldDateJour.setBounds(55, 317, 34, 20);
		panelN1.add(textFieldDateJour);
		textFieldDateJour.setColumns(10);
		
		textFieldDateMois = new JTextField();
		textFieldDateMois.setBounds(99, 317, 34, 20);
		panelN1.add(textFieldDateMois);
		textFieldDateMois.setColumns(10);
		
		textFieldDateAnnee = new JTextField();
		textFieldDateAnnee.setBounds(143, 317, 58, 20);
		panelN1.add(textFieldDateAnnee);
		textFieldDateAnnee.setColumns(10);
		
		/**
		 *  Information concerning Participant class
		 */
		
		JLabel texteParticipant = new JLabel("Participant");
		texteParticipant.setFont(new Font("Tahoma", Font.BOLD, 13));
		texteParticipant.setBounds(xParticipant, 100, 125, 14);
		panelN1.add(texteParticipant);
		
		JLabel texteIdentifiant = new JLabel("Identifiant : ");
		texteIdentifiant.setBounds(xParticipant, 132, 100, 14);
		panelN1.add(texteIdentifiant);
		
		JLabel texteMdp = new JLabel("Mot de passe : ");
		texteMdp.setBounds(xParticipant + 200, 132, 100, 14);
		panelN1.add(texteMdp);
		
		textFieldIdentifiant = new JTextField();
		textFieldIdentifiant.setBounds(xParticipant, 165, 100, 20);
		panelN1.add(textFieldIdentifiant);
		textFieldIdentifiant.setColumns(10);
		
		textFieldMdp = new JTextField();
		textFieldMdp.setBounds(xParticipant + 200, 165, 100, 20);
		panelN1.add(textFieldMdp);
		textFieldMdp.setColumns(10);
		
		/**
		 * Choice of the Participant's type thanks to JComboBox
		 */
		
		JLabel texteNatureParticipant = new JLabel("Type : ");
		texteNatureParticipant.setBounds(xParticipant, 195, 112, 46);
		panelN1.add(texteNatureParticipant);
		
		JComboBox choixParticipant = new JComboBox();	
		choixParticipant.setModel(new DefaultComboBoxModel(new String[] {"", "Delegation", "Entreprise", "Bateau", "Commercant ", "Famille d'Accueil", "VIP"}));
		choixParticipant.setBounds(xParticipant + 150, 200, 214, 29);
		panelN1.add(choixParticipant);
		
		/**
		 * type : Delegation (typeParticipant = 1)
		 */
		
		textFieldNbPersonnesDelegation = new JTextField();
		textFieldNbPersonnesDelegation.setBounds(xParticipant, 369, 100, 20);
		panelN1.add(textFieldNbPersonnesDelegation);
		textFieldNbPersonnesDelegation.setColumns(10);
		
		textFieldPaysDelegation = new JTextField();
		textFieldPaysDelegation.setBounds(xParticipant, 292, 100, 20);
		panelN1.add(textFieldPaysDelegation);
		textFieldPaysDelegation.setColumns(10);
		
		JLabel textePaysDelegation = new JLabel("Pays : ");
		textePaysDelegation.setBounds(xParticipant, 256, 94, 14);
		panelN1.add(textePaysDelegation);
		
		JLabel texteNbPersonnesDelegation = new JLabel("Nombre de personnes : ");
		texteNbPersonnesDelegation.setBounds(xParticipant, 326, 137, 14);
		panelN1.add(texteNbPersonnesDelegation);
		
		textFieldNbPersonnesDelegation.setVisible(false);
		textFieldPaysDelegation.setVisible(false);
		textePaysDelegation.setVisible(false);
		texteNbPersonnesDelegation.setVisible(false);
		
		/**
		 * type : Entreprise (typeParticipant = 2)
		 */
		
		textFieldNomEntreprise = new JTextField();
		textFieldNomEntreprise.setBounds(xParticipant, 369, 100, 20);
		panelN1.add(textFieldNomEntreprise);
		textFieldNomEntreprise.setColumns(10);
		
		textFieldImmatriculation = new JTextField();
		textFieldImmatriculation.setBounds(xParticipant, 292, 100, 20);
		panelN1.add(textFieldImmatriculation);
		textFieldImmatriculation.setColumns(10);
		
		JLabel texteEntreprise = new JLabel("Nom : ");
		texteEntreprise.setBounds(xParticipant, 256, 94, 14);
		panelN1.add(texteEntreprise);
		
		JLabel texteImmatriculation = new JLabel("Immatriculation : ");
		texteImmatriculation.setBounds(xParticipant, 326, 137, 14);
		panelN1.add(texteImmatriculation);
		
		textFieldNomEntreprise.setVisible(false);
		textFieldImmatriculation.setVisible(false);
		texteEntreprise.setVisible(false);
		texteImmatriculation.setVisible(false);
		
		/**
		 *  type : Bateau (typeParticipant = 3)
		 */
		
		textFieldNomBateau = new JTextField();
		textFieldNomBateau.setBounds(xParticipant, 369, 100, 20);
		panelN1.add(textFieldNomBateau);
		textFieldNomBateau.setColumns(10);
		
		textFieldTailleBateau = new JTextField();
		textFieldTailleBateau.setBounds(xParticipant, 292, 100, 20);
		panelN1.add(textFieldTailleBateau);
		textFieldTailleBateau.setColumns(10);
		
		textFieldPavillon = new JTextField();
		textFieldPavillon.setBounds(xParticipant + 150, 292, 100, 20);
		panelN1.add(textFieldPavillon);
		textFieldPavillon.setColumns(10);
		
		JLabel texteNomBateau = new JLabel("Nom : ");
		texteNomBateau.setBounds(xParticipant, 256, 94, 14);
		panelN1.add(texteNomBateau);
		
		JLabel texteTailleBateau = new JLabel("Taille : ");
		texteTailleBateau.setBounds(xParticipant, 326, 137, 14);
		panelN1.add(texteTailleBateau);
		
		JLabel textePavillon = new JLabel("Pavillon : ");
		textePavillon.setBounds(xParticipant + 150, 256, 137, 14);
		panelN1.add(textePavillon);
		
		textFieldNomBateau.setVisible(false);
		textFieldTailleBateau.setVisible(false);
		textFieldPavillon.setVisible(false);
		texteNomBateau.setVisible(false);
		texteTailleBateau.setVisible(false);
		textePavillon.setVisible(false);
		
		/*
		 * INSCRIPTION N2
		 */
		
		JPanel panelN2 = new JPanel();
		//frameInscription.getContentPane().add(panelN2, BorderLayout.CENTER);
		panelN2.setLayout(null);
		
		JLabel texteInscriptionEnAttente = new JLabel("Inscription prise en compte ! En attente de la validation de la part d'un organisateur !");
		texteInscriptionEnAttente.setBounds((720-500)/2, (480-15)/2, 500, 15);
		
		JButton boutonRetourInsc2 = new JButton("Retour");
		boutonRetourInsc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("unused")
				AccueilWindow fenetreAccueil = new AccueilWindow();
				frameInscription.dispose();
			}
		});
		boutonRetourInsc2.setBounds((720-90)/2, 400, 90, 25);
		
		JLabel titreInscription2 = new JLabel("Inscription : ");
		titreInscription2.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 30));
		titreInscription2.setBounds(10, 11, 300, 53);
		
		panelN2.add(texteInscriptionEnAttente);
		panelN2.add(titreInscription2);
		panelN2.add(boutonRetourInsc2);
		
		
		/*
		 * JComboBox, Buttons
		 */
		
		/*
		 * Actions de la JComboBox selon le choix du type de Participant
		 */
		
		choixParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int typeParticipant = choixParticipant.getSelectedIndex();
				
				System.out.println(typeParticipant);
				
				/*
				 * Conditions
				 */
				
				switch(typeParticipant) {
					case 0: 
						// Vanish information concerning inheritances of Participant class
						
						// Vanish Delegation
						textFieldNbPersonnesDelegation.setVisible(false);
						textFieldPaysDelegation.setVisible(false);
						textePaysDelegation.setVisible(false);
						texteNbPersonnesDelegation.setVisible(false);
						
						// Vanish Entreprise
						textFieldNomEntreprise.setVisible(false);
						textFieldImmatriculation.setVisible(false);
						texteEntreprise.setVisible(false);
						texteImmatriculation.setVisible(false);
						
						// Vanish Bateau
						textFieldNomBateau.setVisible(false);
						textFieldTailleBateau.setVisible(false);
						textFieldPavillon.setVisible(false);
						texteNomBateau.setVisible(false);
						texteTailleBateau.setVisible(false);
						textePavillon.setVisible(false);
					
						break;
					
					case 1: // DELEGATION
						// Vanish 
						// Vanish Entreprise
						textFieldNomEntreprise.setVisible(false);
						textFieldImmatriculation.setVisible(false);
						texteEntreprise.setVisible(false);
						texteImmatriculation.setVisible(false);
						
						//Vanish Bateau
						textFieldNomBateau.setVisible(false);
						textFieldTailleBateau.setVisible(false);
						textFieldPavillon.setVisible(false);
						texteNomBateau.setVisible(false);
						texteTailleBateau.setVisible(false);
						textePavillon.setVisible(false);
						
						
						// Appear
						textFieldNbPersonnesDelegation.setVisible(true);
						textFieldPaysDelegation.setVisible(true);
						textePaysDelegation.setVisible(true);
						texteNbPersonnesDelegation.setVisible(true);
						
						break;
					
					case 2: // ENTREPRISE
						// Vanish
						// Vanish Delegation
						textFieldNbPersonnesDelegation.setVisible(false);
						textFieldPaysDelegation.setVisible(false);
						textePaysDelegation.setVisible(false);
						texteNbPersonnesDelegation.setVisible(false);
						
						// Vanish Bateau
						textFieldNomBateau.setVisible(false);
						textFieldTailleBateau.setVisible(false);
						textFieldPavillon.setVisible(false);
						texteNomBateau.setVisible(false);
						texteTailleBateau.setVisible(false);
						textePavillon.setVisible(false);
						
						// Appear
						textFieldNomEntreprise.setVisible(true);
						textFieldImmatriculation.setVisible(true);
						texteEntreprise.setVisible(true);
						texteImmatriculation.setVisible(true);
						
						break;
					
					case 3: // BATEAU
						// Vanish
						// Vanish Delegation
						textFieldNbPersonnesDelegation.setVisible(false);
						textFieldPaysDelegation.setVisible(false);
						textePaysDelegation.setVisible(false);
						texteNbPersonnesDelegation.setVisible(false);
						
						// Vanish Entreprise
						textFieldNomEntreprise.setVisible(false);
						textFieldImmatriculation.setVisible(false);
						texteEntreprise.setVisible(false);
						texteImmatriculation.setVisible(false);
						
						// Appear 
						textFieldNomBateau.setVisible(true);
						textFieldTailleBateau.setVisible(true);
						textFieldPavillon.setVisible(true);
						texteNomBateau.setVisible(true);
						texteTailleBateau.setVisible(true);
						textePavillon.setVisible(true);
						
						break;
						
					default:
						break;
				}
			}
		});
		
		
		/*
		 * Buttons : "Retour" and "Suivant"
		 */
		
		JButton boutonSuivantInsc1 = new JButton("Suivant");
		boutonSuivantInsc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean conditionFenetreSuivante = false;
				
				if(textFieldNom.getText().length() != 0 && textFieldPrenom.getText().length() != 0 && 
				   textFieldDateJour.getText().length() != 0 && textFieldDateMois.getText().length() != 0 && textFieldDateAnnee.getText().length() != 0 &&
				   textFieldIdentifiant.getText().length() != 0 && textFieldMdp.getText().length() != 0 &&
				   choixParticipant.getSelectedIndex() != 0
				   ) {
					
					switch(choixParticipant.getSelectedIndex()) {
						case 1:
							if(textFieldPaysDelegation.getText().length() != 0 && textFieldNbPersonnesDelegation.getText().length() != 0) {
								System.out.println("TEST ENTREE CASE 1");
								// Add information into Database
								
								/*
								 * VERIF La nature des champs (int, string)
								 */
								
								ParticipantDAO pDAO = new ParticipantDAO();
								
								pDAO.addDelegation(Integer.parseInt(textFieldDateJour.getText()), 
												   Integer.parseInt(textFieldDateMois.getText()), 
												   Integer.parseInt(textFieldDateAnnee.getText()), 
												   textFieldNom.getText(), 
												   textFieldPrenom.getText(), 
												   textFieldIdentifiant.getText(), 
												   textFieldMdp.getText(), 
												   textFieldPaysDelegation.getText(), 
												   Integer.parseInt(textFieldNbPersonnesDelegation.getText())
												   );
								
								conditionFenetreSuivante = true;
								
							}
							break;
						
						/*
						 * Les autres "case"	
						 */
							
						default:
							break;
					}
					
					
					// à remplacer par la prochaine fenêtre
					
					if(conditionFenetreSuivante == true) {
						panelN1.setVisible(false);
						frameInscription.getContentPane().add(panelN2, BorderLayout.CENTER);
						panelN2.setVisible(true);
					}
					
				}
				//Mettre une condition que le choix du type + champs soient remplis
			}
		});
		boutonSuivantInsc1.setBounds(605, 407, 89, 23);
		panelN1.add(boutonSuivantInsc1);
		
		JButton boutonRetourInsc1 = new JButton("Retour");
		boutonRetourInsc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("unused")
				AccueilWindow fenetreAccueil = new AccueilWindow();
				frameInscription.dispose();
			}
		});
		boutonRetourInsc1.setBounds(506, 407, 89, 23);
		panelN1.add(boutonRetourInsc1);
		
		
		
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		
		/**
		 *  frame -> setVisible(true)
		 */
		
		frameInscription.setVisible(true);
	}
}
