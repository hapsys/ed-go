package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class DiedBean {

	private Date timestamp;
	private String event;
	/**
	 *  a JSON array of objects containing player name, ship, and rank
	 */
	private String Killers;
	
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
	