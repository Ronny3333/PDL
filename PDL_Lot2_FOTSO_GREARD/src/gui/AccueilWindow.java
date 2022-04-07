package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccueilWindow {

	private JFrame frameAccueil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccueilWindow window = new AccueilWindow();
					window.frameAccueil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AccueilWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameAccueil = new JFrame();
		frameAccueil.setTitle("ARMADA 2023");
		frameAccueil.setBounds(100, 100, 720, 480);
		frameAccueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAccueil.getContentPane().setLayout(null);
		
		JButton boutonInscription = new JButton("Inscription");
		boutonInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("unused")
				InscriptionWindow fenetreInscription = new InscriptionWindow();
				frameAccueil.dispose();
				
			}
		});
		boutonInscription.setBounds(100, 200, 150, 50);
		frameAccueil.getContentPane().add(boutonInscription);
		
		JButton boutonConnexion = new JButton("Connexion");
		boutonConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("unused")
				ConnexionWindow fenetreConnexion = new ConnexionWindow();
				frameAccueil.dispose();
				
			}
		});
		boutonConnexion.setBounds(470, 200, 150, 50);
		frameAccueil.getContentPane().add(boutonConnexion);
		
		JLabel titreAccueil = new JLabel("ARMADA 2023");
		titreAccueil.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 30));
		titreAccueil.setHorizontalAlignment(SwingConstants.CENTER);
		titreAccueil.setBounds(210, 11, 300, 80);
		frameAccueil.getContentPane().add(titreAccueil);
		
		frameAccueil.setVisible(true);
	}
}
