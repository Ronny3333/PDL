package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import dao.ParticipantDAO;

public class ConnexionWindow {

	private JFrame frameConnexion;
	private JTextField textFieldIdentifitantConnexionParticipant;
	private JTextField textFieldMdpConnexionParticipant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnexionWindow window = new ConnexionWindow();
					window.frameConnexion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConnexionWindow() {
		frameConnexion = new JFrame();
		frameConnexion.setBounds(100, 100, 720, 480);
		frameConnexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * Panel choice class : Participant or Organisateur
		 */
		
		
		JPanel panelChoixConnexion = new JPanel();
		panelChoixConnexion.setLayout(null);
		frameConnexion.getContentPane().add(panelChoixConnexion, BorderLayout.CENTER);
		
		JLabel titreChoixConnexion = new JLabel("Connexion : ");
		titreChoixConnexion.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 30));
		titreChoixConnexion.setBounds(10, 11, 300, 53);
		panelChoixConnexion.add(titreChoixConnexion);
		
		JButton boutonParticipant = new JButton("Participant");
		boutonParticipant.setBounds(100, 200, 150, 50);
		panelChoixConnexion.add(boutonParticipant);
		
		JButton boutonOrganisateur = new JButton("Organisateur");
		boutonOrganisateur.setBounds(470, 200, 150, 50);
		panelChoixConnexion.add(boutonOrganisateur);
		
		JButton boutonRetourChoix = new JButton("Retour");
		boutonRetourChoix.setBounds((720-150)/2, 400, 150, 25);
		panelChoixConnexion.add(boutonRetourChoix);
		
		
		/*
		 * Panel of Participant Connexion
		 */
		
		JPanel panelConnexionParticipant = new JPanel();
		panelConnexionParticipant.setLayout(null);
		//frameConnexion.getContentPane().add(panelConnexionParticipant, BorderLayout.CENTER);
		
		JLabel titreConnexionParticipant = new JLabel("Connexion : ");
		titreConnexionParticipant.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 30));
		titreConnexionParticipant.setBounds(10, 11, 300, 53);
		panelConnexionParticipant.add(titreConnexionParticipant);
		
		JButton boutonRetourParticipant = new JButton("Retour");
		boutonRetourParticipant.setBounds((720-150)/2, 400, 150, 25);
		panelConnexionParticipant.add(boutonRetourParticipant);
		
		JLabel texteIdentifiantConnexionParticipant = new JLabel("Identifiant :");
		texteIdentifiantConnexionParticipant.setBounds((720-125)/2, 150, 125, 20);
		panelConnexionParticipant.add(texteIdentifiantConnexionParticipant);
		
		textFieldIdentifitantConnexionParticipant = new JTextField();
		textFieldIdentifitantConnexionParticipant.setBounds((720-125)/2, 175, 125, 20);
		panelConnexionParticipant.add(textFieldIdentifitantConnexionParticipant);
		textFieldIdentifitantConnexionParticipant.setColumns(10);
		
		JLabel texteMdpConnexionParticipant = new JLabel("Mot de passe  :");
		texteMdpConnexionParticipant.setBounds((720-125)/2, 200, 125, 20);
		panelConnexionParticipant.add(texteMdpConnexionParticipant);
		
		textFieldMdpConnexionParticipant = new JTextField();
		textFieldMdpConnexionParticipant.setBounds((720-125)/2, 225, 125, 20);
		panelConnexionParticipant.add(textFieldMdpConnexionParticipant);
		textFieldMdpConnexionParticipant.setColumns(10);
		
		JButton boutonValiderConenxionParticipant = new JButton("Valider");
		
		boutonValiderConenxionParticipant.setBounds((720-150)/2, 350, 150, 25);
		panelConnexionParticipant.add(boutonValiderConenxionParticipant);
		
		JLabel texteMessageErreur = new JLabel("Identifiant ou mot de passe incorrect !");
		texteMessageErreur.setBounds((720-195)/2, 300, 195, 20);
		panelConnexionParticipant.add(texteMessageErreur);
		texteMessageErreur.setVisible(false);
		
		
		
		/*
		 * Panel of Organisateur Connexion
		 */
		
		JPanel panelConnexionOrganisateur = new JPanel();
		panelConnexionOrganisateur.setLayout(null);
		
		JLabel titreConnexionOrganisateur = new JLabel("Connexion : ");
		titreConnexionOrganisateur.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 30));
		titreConnexionOrganisateur.setBounds(10, 11, 300, 53);
		panelConnexionOrganisateur.add(titreConnexionOrganisateur);
		
		JButton boutonRetourOrganisateur = new JButton("Retour");
		boutonRetourOrganisateur.setBounds((720-150)/2, 400, 150, 25);
		panelConnexionOrganisateur.add(boutonRetourOrganisateur);
		
		/*
		 * Actions of buttons 
		 */
		
		// Choice : Participant
		boutonParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelChoixConnexion.setVisible(false);
				frameConnexion.getContentPane().add(panelConnexionParticipant);
				panelConnexionParticipant.setVisible(true);
				
			}
		});
		
		boutonValiderConenxionParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				texteMessageErreur.setVisible(false);
				ParticipantDAO pDAO = new ParticipantDAO();
				
				if(textFieldIdentifitantConnexionParticipant.getText().length() != 0 && textFieldMdpConnexionParticipant.getText().length() != 0) {
					
					if(pDAO.isItInDataBase(textFieldIdentifitantConnexionParticipant.getText(),textFieldMdpConnexionParticipant.getText()) == 1) {
						
						@SuppressWarnings("unused")
						AccueilWindow fenetreAccueil = new AccueilWindow();
						frameConnexion.dispose();
					}
					else {
						texteMessageErreur.setVisible(true);	
					}
					
				}
				
			}
		});
		
		// Choice : Organisateur
		boutonOrganisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelChoixConnexion.setVisible(false);
				frameConnexion.getContentPane().add(panelConnexionOrganisateur);
				panelConnexionOrganisateur.setVisible(true);
				
			}
		});
		
		// "Retour Choix"
		boutonRetourChoix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("unused")
				AccueilWindow fenetreAccueil = new AccueilWindow();
				frameConnexion.dispose();
				
			}
		});

		// "Retour Participant"
		boutonRetourParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelConnexionParticipant.setVisible(false);
				frameConnexion.getContentPane().add(panelChoixConnexion);
				panelChoixConnexion.setVisible(true);
				
			}
		});
		
		// "Retour Organisateur"
		boutonRetourOrganisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelConnexionOrganisateur.setVisible(false);
				frameConnexion.getContentPane().add(panelChoixConnexion);
				panelChoixConnexion.setVisible(true);
				
			}
		});
		
		
		frameConnexion.setVisible(true);
	}
}
