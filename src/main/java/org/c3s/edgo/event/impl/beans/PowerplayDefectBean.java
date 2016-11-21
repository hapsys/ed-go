package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class PowerplayDefectBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String FromPower;
	/**
	 * 
	 */
	private String ToPower;
	
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
	public String getFromPower() {
		return FromPower;
	}
	/**
	 * @param frompower
	 */
	public void setFromPower(String frompower) {
		this.FromPower = frompower;
	}
	/**
	 * @return
	 */
	public String getToPower() {
		return ToPower;
	}
	/**
	 * @param topower
	 */
	public void setToPower(String topower) {
		this.ToPower = topower;
	}
	
}	
	