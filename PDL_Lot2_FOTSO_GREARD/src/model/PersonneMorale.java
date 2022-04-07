package model;

public class PersonneMorale {
	private String nom;
	private String prenom;
	private DatePerso birthdate;
	/**
	 * @param nom
	 * @param prenom
	 * @param birthdate
	 */
	public PersonneMorale(String nom, String prenom, DatePerso birthdate) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.birthdate = birthdate;
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
	 * @return the birthdate
	 */
	public DatePerso getBirthdate() {
		return birthdate;
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
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(DatePerso birthdate) {
		this.birthdate = birthdate;
	}

	
		
}
