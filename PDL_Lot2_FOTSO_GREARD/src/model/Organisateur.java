package model;

public class Organisateur {
	private String identifiant;
	private String mdp;
	
	public Organisateur(String identifiant, String mdp) {
		this.identifiant = identifiant;
		this.mdp 		 = mdp;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public String getMdp() {
		return mdp;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
}	
