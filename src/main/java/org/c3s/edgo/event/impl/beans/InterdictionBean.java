package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class InterdictionBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * : true or false
	 */
	private String Success;
	/**
	 * victim pilot name
	 */
	private String Interdicted;
	/**
	 * whether player or npc
	 */
	private String IsPlayer;
	/**
	 * if a player
	 */
	private String CombatRank;
	/**
	 * if an npc
	 */
	private String Faction;
	/**
	 * if npc working for power
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
	public String getSuccess() {
		return Success;
	}

	/**
	 * @param success
	 */
	public void setSuccess(String success) {
		this.Success = success;
	}

	/**
	 * @return
	 */
	public String getInterdicted() {
		return Interdicted;
	}

	/**
	 * @param interdicted
	 */
	public void setInterdicted(String interdicted) {
		this.Interdicted = interdicted;
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
