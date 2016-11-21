package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class PVPKillBean {

	private Date timestamp;
	private String event;
	/**
	 *  name of victim
	 */
	private String Victim;
	/**
	 *  victims rank in range 0..8
	 */
	private String CombatRank;
	
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
	public String getCombatRank() {
		return CombatRank;
	}
	/**
	 * @param combatrank
	 */
	public void setCombatRank(String combatrank) {
		this.CombatRank = combatrank;
	}
	
}	
	