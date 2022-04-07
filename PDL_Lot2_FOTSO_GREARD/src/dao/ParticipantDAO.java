package dao;

import java.sql.*;
import model.*;

/**
 * Access class to the data contained in the Participant table
 * 
 * @author GUILLAUME GREARD 
 * @version 1.0
 * */
public class ParticipantDAO extends ConnectionDAO {

	public ParticipantDAO() {
		super();
	}
	
	public int add(Participant unParticipant, int fk_pk_personneMorale) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// Database connection
		try {

			// Connection attempt
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			
			String generatedColumns[] = { "IDPARTICIPANT" };
			
			ps = con.prepareStatement("INSERT INTO PARTICIPANT_2 (IDPARTICIPANT, IDENTIFIANT, MDP, POSSEDECOMPTE, IDPERSONNEMORALE) VALUES (PARTICIPANT_2_SEQ.nextval, ?, ?, ?, ?)", generatedColumns);
			ps.setString(1, unParticipant.getIdentifiant());
			ps.setString(2, unParticipant.getMdp());
			ps.setInt(3, unParticipant.getPossedeCompte());
			ps.setInt(4, fk_pk_personneMorale);
		
			
			// Query execution
			returnValue = ps.executeUpdate();
			
			// Get the primary key using the "generatedColumns"
			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    returnValue = generatedKeys.getInt(1);
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
			
			
		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant de fournisseur existe déjà. Ajout impossible !");
			else
				e.printStackTrace();
		} finally {
			// Close PreparedStatement and Connection
			
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
	
	
	public int update(Participant unParticipant, String idTypeParticipant, int fk_pkTypeParticipant) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		String update = "UPDATE PARTICIPANT_2 set ".concat(idTypeParticipant).concat(" = ? WHERE IDPARTICIPANT = (SELECT IDPARTICIPANT FROM PARTICIPANT_2 WHERE IDENTIFIANT = ?)");
		
		
		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);

			ps = con.prepareStatement(update);
			ps.setInt(1, fk_pkTypeParticipant);
			ps.setString(2, unParticipant.getIdentifiant());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
	
	public int isItInDataBase(String identifiantParticipant, String mdpParticipant) {
		Connection con = null;
		Statement stmt = null;
		int returnValue = 0;
		ResultSet rs = null;
		
		String search = "SELECT * FROM PARTICIPANT_2 WHERE IDENTIFIANT = '".concat(identifiantParticipant).concat("' AND MDP = '").concat(mdpParticipant).concat("'");
		
		
		// connexion a la base de donnees
		try {

			// tentative de connexion 
			con = DriverManager.getConnection(URL, LOGIN, PASS);

			stmt = con.createStatement();
			
			
			
			// Execution de la requete
			rs = stmt.executeQuery(search);
			
			if(rs.next() == true) {
				returnValue = 1;
			}
			
			

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		
		return returnValue; // 0 ou 1	
	}
	
	
	
	
	public void addDelegation(int jour, int mois, int annee, String nom, String prenom, String pseudo, String motDePasse, String pays, int nbPersonnes) {
		
		DatePerso date = new DatePerso(jour, mois, annee);
		PersonneMorale personneMorale = new PersonneMorale(nom, prenom, date);
		Participant participant = new Participant(pseudo, motDePasse, personneMorale);
		Delegation delegation = new Delegation(pseudo, motDePasse, pays, nbPersonnes, personneMorale);
		
		DatePersoDAO dateDAO = new DatePersoDAO();
		PersonneMoraleDAO personneMoraleDAO = new PersonneMoraleDAO();
		ParticipantDAO participantDAO = new ParticipantDAO();
		DelegationDAO delegationDAO = new DelegationDAO();
		
		participantDAO.add(participant,(personneMoraleDAO.add(personneMorale, dateDAO.add(date))));
		participantDAO.update(participant, "IDDELEGATION", delegationDAO.add(delegation));
		
	}
	
	
	public void addEntreprise(int jour, int mois, int annee, String nom, String prenom, String pseudo, String motDePasse, String nomEntreprise, String immatriculationEntreprise) {
		
		DatePerso date = new DatePerso(jour, mois, annee);
		PersonneMorale personneMorale = new PersonneMorale(nom, prenom, date);
		Participant participant = new Participant(pseudo, motDePasse, personneMorale);
		Entreprise entreprise = new Entreprise(pseudo, motDePasse, nomEntreprise, immatriculationEntreprise, personneMorale);
		
		DatePersoDAO dateDAO = new DatePersoDAO();
		PersonneMoraleDAO personneMoraleDAO = new PersonneMoraleDAO();
		ParticipantDAO participantDAO = new ParticipantDAO();
		EntrepriseDAO entrepriseDAO = new EntrepriseDAO();
		
		
		participantDAO.add(participant,(personneMoraleDAO.add(personneMorale, dateDAO.add(date))));
		participantDAO.update(participant, "IDENTREPRISE", entrepriseDAO.add(entreprise));
	}
	
	
	public void addBateau(int jour, int mois, int annee, String nom, String prenom, String pseudo, String motDePasse, String nomBateau, double tailleBateau, String pavillonBateau) {
		
		DatePerso date = new DatePerso(jour, mois, annee);
		PersonneMorale personneMorale = new PersonneMorale(nom, prenom, date);
		Participant participant = new Participant(pseudo, motDePasse, personneMorale);
		Bateau bateau = new Bateau(pseudo, motDePasse, nomBateau, tailleBateau, pavillonBateau, personneMorale);
		
		DatePersoDAO dateDAO = new DatePersoDAO();
		PersonneMoraleDAO personneMoraleDAO = new PersonneMoraleDAO();
		ParticipantDAO participantDAO = new ParticipantDAO();
		BateauDAO bateauDAO = new BateauDAO();
		
		
		participantDAO.add(participant,(personneMoraleDAO.add(personneMorale, dateDAO.add(date))));
		participantDAO.update(participant, "IDBATEAU", bateauDAO.add(bateau));
	}
	
	
	
	
}
