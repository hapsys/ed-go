package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class PowerplaySalaryBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String Power;
	/**
	 * 
	 */
	private String Amount;
	
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
	public String getAmount() {
		return Amount;
	}
	/**
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.Amount = amount;
	}
	
}	
	