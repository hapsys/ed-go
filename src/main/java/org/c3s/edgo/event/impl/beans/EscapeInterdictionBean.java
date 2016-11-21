package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class EscapeInterdictionBean {

	private Date timestamp;
	private String event;
	/**
	 *  interdicting pilot name
	 */
	private String Interdictor;
	/**
	 *  whether player or npc
	 */
	private String IsPlayer;
	
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
	
}	
	