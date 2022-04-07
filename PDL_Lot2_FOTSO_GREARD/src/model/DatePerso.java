package model;

public class DatePerso {
	
	private int jour;
	private int mois;
	private int annee;
	/**
	 * @param jour
	 * @param mois
	 * @param annee
	 */
	public DatePerso(int jour, int mois, int annee) {
		super();
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}
	/**
	 * @return the jour
	 */
	public int getJour() {
		return jour;
	}
	/**
	 * @return the mois
	 */
	public int getMois() {
		return mois;
	}
	/**
	 * @return the annee
	 */
	public int getAnnee() {
		return annee;
	}
	/**
	 * @param jour the jour to set
	 */
	public void setJour(int jour) {
		this.jour = jour;
	}
	/**
	 * @param mois the mois to set
	 */
	public void setMois(int mois) {
		this.mois = mois;
	}
	/**
	 * @param annee the annee to set
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}

}
