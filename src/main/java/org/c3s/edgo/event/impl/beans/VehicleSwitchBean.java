package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class VehicleSwitchBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * ( Mothership/Fighter)
	 */
	private String To;

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
	public String getTo() {
		return To;
	}

	/**
	 * @param to
	 */
	public void setTo(String to) {
		this.To = to;
	}

}
