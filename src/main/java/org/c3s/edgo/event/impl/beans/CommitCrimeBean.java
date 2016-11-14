package org.c3s.edgo.event.impl.beans;

public class CommitCrimeBean {
	/**
	 * 
	 */
	private String CrimeType;
	/**
	 * 
	 */
	private String Faction;
	/**
	 *  (depending on crime)
	 */
	private String parameters;
	/**
	 * 
	 */
	private String Victim;
	/**
	 * 
	 */
	private String Fine;
	/**
	 * 
	 */
	private String Bounty;
	/**
	 * @return
	 */
	public String getCrimeType() {
		return CrimeType;
	}
	/**
	 * @param crimetype
	 */
	public void setCrimeType(String crimetype) {
		this.CrimeType = crimetype;
	}
	/**
	 * @return
	 */
	public String getFaction() {
		return Faction;
	}
	/**
	 * @param faction
	 */
	public void setFaction(String faction) {
		this.Faction = faction;
	}
	/**
	 * @return
	 */
	public String getparameters() {
		return parameters;
	}
	/**
	 * @param parameters
	 */
	public void setparameters(String parameters) {
		this.parameters = parameters;
	}
	/**
	 * @return
	 */
	public String getVictim() {
		return Victim;
	}
	/**
	 * @param victim
	 */
	public void setVictim(String victim) {
		this.Victim = victim;
	}
	/**
	 * @return
	 */
	public String getFine() {
		return Fine;
	}
	/**
	 * @param fine
	 */
	public void setFine(String fine) {
		this.Fine = fine;
	}
	/**
	 * @return
	 */
	public String getBounty() {
		return Bounty;
	}
	/**
	 * @param bounty
	 */
	public void setBounty(String bounty) {
		this.Bounty = bounty;
	}
	
}	
	