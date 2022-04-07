package model;

public class Planning {
	private DatePerso arrivee;
	private DatePerso depart;
	/**
	 * @param arrivee
	 * @param depart
	 */
	public Planning(DatePerso arrivee, DatePerso depart) {
		super();
		this.arrivee = arrivee;
		this.depart = depart;
	}
	/**
	 * @return the arrivee
	 */
	public DatePerso getArrivee() {
		return arrivee;
	}
	/**
	 * @return the depart
	 */
	public DatePerso getDepart() {
		return depart;
	}
	/**
	 * @param arrivee the arrivee to set
	 */
	public void setArrivee(DatePerso arrivee) {
		this.arrivee = arrivee;
	}
	/**
	 * @param depart the depart to set
	 */
	public void setDepart(DatePerso depart) {
		this.depart = depart;
	}
	
}
