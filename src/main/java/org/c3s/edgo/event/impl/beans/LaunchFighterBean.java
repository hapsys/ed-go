package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class LaunchFighterBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String Loadout;
	/**
	 *  whether player is controlling the fighter from launch
	 */
	private String PlayerControlled;
	
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
	public String getLoadout() {
		return Loadout;
	}
	/**
	 * @param loadout
	 */
	public void setLoadout(String loadout) {
		this.Loadout = loadout;
	}
	/**
	 * @return
	 */
	public String getPlayerControlled() {
		return PlayerControlled;
	}
	/**
	 * @param playercontrolled
	 */
	public void setPlayerControlled(String playercontrolled) {
		this.PlayerControlled = playercontrolled;
	}
	
}	
	