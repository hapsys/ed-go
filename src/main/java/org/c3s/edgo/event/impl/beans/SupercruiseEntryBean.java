package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class SupercruiseEntryBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String Starsystem;
	
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
	public String getStarsystem() {
		return Starsystem;
	}
	/**
	 * @param starsystem
	 */
	public void setStarsystem(String starsystem) {
		this.Starsystem = starsystem;
	}
	
}	
	