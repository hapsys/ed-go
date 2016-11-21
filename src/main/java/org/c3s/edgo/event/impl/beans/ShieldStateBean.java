package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class ShieldStateBean {

	private Date timestamp;
	private String event;
	/**
	 *  0 when disabled, 1 when restored
	 */
	private String ShieldsUp;
	
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
	public String getShieldsUp() {
		return ShieldsUp;
	}
	/**
	 * @param shieldsup
	 */
	public void setShieldsUp(String shieldsup) {
		this.ShieldsUp = shieldsup;
	}
	
}	
	