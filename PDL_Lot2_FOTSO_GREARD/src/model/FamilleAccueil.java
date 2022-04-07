package model;

public class FamilleAccueil extends Participant {
	private String adresse;
	private int nbPlaces;
	/**
	 * @param identifiant
	 * @param mdp
	 * @param adresse
	 * @param nbPlaces
	 * @param unePersonneMorale
	 */
	public FamilleAccueil(String identifiant, String mdp, String adresse, int nbPlaces, PersonneMorale unePersonneMorale) {
		super(identifiant, mdp, unePersonneMorale);
		this.adresse = adresse;
		this.nbPlaces = nbPlaces;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @return the nbPlaces
	 */
	public int getNbPlaces() {
		return nbPlaces;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @param nbPlaces the nbPlaces to set
	 */
	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	
	

}
