package model;

public class Bateau extends Participant {
	private String nom;
	private double taille;
	private String pavillon;
	/**
	 * @param identifiant
	 * @param mdp
	 * @param nom
	 * @param taille
	 * @param pavillon
	 * @param unePersonneMorale
	 */
	public Bateau(String identifiant, String mdp, String nom, double taille, String pavillon, PersonneMorale unePersonneMorale) {
		super(identifiant, mdp, unePersonneMorale);
		this.nom      = nom;
		this.taille   = taille;
		this.pavillon = pavillon;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @return the taille
	 */
	public double getTaille() {
		return taille;
	}
	/**
	 * @return the pavillon
	 */
	public String getPavillon() {
		return pavillon;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @param taille the taille to set
	 */
	public void setTaille(double taille) {
		this.taille = taille;
	}
	/**
	 * @param pavillon the pavillon to set
	 */
	public void setPavillon(String pavillon) {
		this.pavillon = pavillon;
	}
	
	
	
	

}
