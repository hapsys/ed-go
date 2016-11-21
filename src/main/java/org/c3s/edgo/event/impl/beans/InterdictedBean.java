package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class InterdictedBean {

	private Date timestamp;
	private String event;
	/**
	 *  true or false
	 */
	private String Submitted;
	/**
	 *  interdicting pilot name
	 */
	private String Interdictor;
	/**
	 *  whether player or npc
	 */
	private String IsPlayer;
	/**
	 *  if player
	 */
	private String CombatRank;
	/**
	 *  if npc
	 */
	private String Faction;
	/**
	 *  if npc working for a power
	 */
	private String Power;
	
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
	public String getSubmitted() {
		return Submitted;
	}
	/**
	 * @param submitted
	 */
	public void setSubmitted(String submitted) {
		this.Submitted = submitted;
	}
	/**
	 * @return
	 */
	public String getInterdictor() {
		return Interdictor;
	}
	/**
	 * @param interdictor
	 */
	public void setInterdictor(String interdictor) {
		this.Interdictor = interdictor;
	}
	/**
	 * @return
	 */
	public String getIsPlayer() {
		return IsPlayer;
	}
	/**
	 * @param isplayer
	 */
	public void setIsPlayer(String isplayer) {
		this.IsPlayer = isplayer;
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
	public String getPower() {
		return Power;
	}
	/**
	 * @param power
	 */
	public void setPower(String power) {
		this.Power = power;
	}
	
}	
	