package model;

//import java.util.*;

public class Participant {
	
	protected String identifiant;
	protected String mdp;
	protected int possedeCompte;
	
	protected PersonneMorale unePersonneMorale;
	
	public Participant(String identifiant, String mdp, PersonneMorale unePersonneMorale){
		this.identifiant   = identifiant;
		this.mdp 		   = mdp;
		this.possedeCompte = 0; 
		this.unePersonneMorale = unePersonneMorale;
	}

	/**
	 * @return the identifiant
	 */
	public String getIdentifiant() {
		return identifiant;
	}

	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @return the possedeCompte
	 */
	public int getPossedeCompte() {
		return possedeCompte;
	}

	/**
	 * @return the unePersonneMorale
	 */
	public PersonneMorale getUnePersonneMorale() {
		return unePersonneMorale;
	}

	/**
	 * @param identifiant the identifiant to set
	 */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * @param possedeCompte the possedeCompte to set
	 */
	public void setPossedeCompte(int possedeCompte) {
		this.possedeCompte = possedeCompte;
	}

	/**
	 * @param unePersonneMorale the unePersonneMorale to set
	 */
	public void setUnePersonneMorale(PersonneMorale unePersonneMorale) {
		this.unePersonneMorale = unePersonneMorale;
	}

	
	
	
	
}
