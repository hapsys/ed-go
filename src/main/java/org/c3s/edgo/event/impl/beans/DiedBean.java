package org.c3s.edgo.event.impl.beans;

public class DiedBean {
	/**
	 *  a JSON array of objects containing player name, ship, and rank
	 */
	private String Killers;
	/**
	 * @return
	 */
	public String getKillers() {
		return Killers;
	}
	/**
	 * @param killers
	 */
	public void setKillers(String killers) {
		this.Killers = killers;
	}
	
}	
	