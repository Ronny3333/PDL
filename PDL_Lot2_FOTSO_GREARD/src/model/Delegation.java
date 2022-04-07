package model;

public class Delegation extends Participant {
	private String pays;
	private int nbPersonnes;
	/**
	 * @param identifiant
	 * @param mdp
	 * @param pays
	 * @param nbPersonnes
	 * @param unePersonneMorale
	 */
	public Delegation(String identifiant, String mdp, String pays, int nbPersonnes, PersonneMorale unePersonneMorale) {
		super(identifiant, mdp, unePersonneMorale);
		this.pays        = pays;
		this.nbPersonnes = nbPersonnes;
	}
	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}
	/**
	 * @return the nbPersonnes
	 */
	public int getNbPersonnes() {
		return nbPersonnes;
	}
	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}
	/**
	 * @param nbPersonnes the nbPersonnes to set
	 */
	public void setNbPersonnes(int nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}
	
	
	

}
