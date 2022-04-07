package model;

public class Entreprise extends Participant {
	private String nom;
	private String immatriculation;
	/**
	 * @param identifiant
	 * @param mdp
	 * @param nom
	 * @param immatriculation
	 * @param unePersonneMorale
	 */
	public Entreprise(String identifiant, String mdp, String nom, String immatriculation, PersonneMorale unePersonneMorale) {
		super(identifiant, mdp, unePersonneMorale);
		this.nom 			 = nom;
		this.immatriculation = immatriculation;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @return the immatriculation
	 */
	public String getImmatriculation() {
		return immatriculation;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @param immatriculation the immatriculation to set
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	
	

}
