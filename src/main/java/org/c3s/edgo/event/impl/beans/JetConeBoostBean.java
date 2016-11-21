package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class JetConeBoostBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String BoostValue;
	
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
	public String getBoostValue() {
		return BoostValue;
	}
	/**
	 * @param boostvalue
	 */
	public void setBoostValue(String boostvalue) {
		this.BoostValue = boostvalue;
	}
	
}	
	