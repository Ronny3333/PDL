package model;

public class Vip extends Participant {
	private String nom;
	private String prenom;
	private DatePerso dateDeNaissance;
	private String metier;
	/**
	 * @param identifiant
	 * @param mdp
	 * @param unePersonneMorale
	 * @param nom
	 * @param prenom
	 * @param dateDeNaissance
	 * @param metier
	 */
	public Vip(String identifiant, String mdp, PersonneMorale unePersonneMorale, String nom, String prenom,
			DatePerso dateDeNaissance, String metier) {
		super(identifiant, mdp, unePersonneMorale);
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.metier = metier;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @return the dateDeNaissance
	 */
	public DatePerso getDateDeNaissance() {
		return dateDeNaissance;
	}
	/**
	 * @return the metier
	 */
	public String getMetier() {
		return metier;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @param dateDeNaissance the dateDeNaissance to set
	 */
	public void setDateDeNaissance(DatePerso dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	/**
	 * @param metier the metier to set
	 */
	public void setMetier(String metier) {
		this.metier = metier;
	}

	
	
}
