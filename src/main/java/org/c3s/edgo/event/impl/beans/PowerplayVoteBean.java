package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class PowerplayVoteBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String Power;
	/**
	 * 
	 */
	private String Votes;
	/**
	 * 
	 */
	private String System;
	
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
	/**
	 * @return
	 */
	public String getVotes() {
		return Votes;
	}
	/**
	 * @param votes
	 */
	public void setVotes(String votes) {
		this.Votes = votes;
	}
	/**
	 * @return
	 */
	public String getSystem() {
		return System;
	}
	/**
	 * @param system
	 */
	public void setSystem(String system) {
		this.System = system;
	}
	
}	
	