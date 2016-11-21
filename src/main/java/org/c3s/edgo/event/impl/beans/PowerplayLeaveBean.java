package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class PowerplayLeaveBean {

	private Date timestamp;
	private String event;
	/**
	 * 
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
	