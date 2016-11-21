package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class CrewHireBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String Name;
	/**
	 * 
	 */
	private String Faction;
	/**
	 * 
	 */
	private String Cost;
	/**
	 *  Rank
	 */
	private String Combat;
	
	/**
	 * @return
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return
	 */
	public String getEvent() {
		return event;
	}
	/**
	 * @param event
	 */
	public void setEvent(String event) {
		this.event = event;
	}
	/**
	 * @return
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.Name = name;
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
	public String getCost() {
		return Cost;
	}
	/**
	 * @param cost
	 */
	public void setCost(String cost) {
		this.Cost = cost;
	}
	/**
	 * @return
	 */
	public String getCombat() {
		return Combat;
	}
	/**
	 * @param combat
	 */
	public void setCombat(String combat) {
		this.Combat = combat;
	}
	
}	
	