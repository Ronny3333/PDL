package model;

public class Commercant extends Participant {
	private String activite;

	/**
	 * @param identifiant
	 * @param mdp
	 * @param activite
	 * @param unePersonneMorale
	 */
	public Commercant(String identifiant, String mdp, String activite, PersonneMorale unePersonneMorale) {
		super(identifiant, mdp, unePersonneMorale);
		this.activite = activite;
	}

	/**
	 * @return the activite
	 */
	public String getActivite() {
		return activite;
	}

	/**
	 * @param activite the activite to set
	 */
	public void setActivite(String activite) {
		this.activite = activite;
	}
	
	

}
