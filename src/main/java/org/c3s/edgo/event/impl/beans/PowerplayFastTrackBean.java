package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class PowerplayFastTrackBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String Power;
	/**
	 * 
	 */
	private int Cost;

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
	public int getCost() {
		return Cost;
	}

	/**
	 * @param cost
	 */
	public void setCost(int cost) {
		this.Cost = cost;
	}

}
