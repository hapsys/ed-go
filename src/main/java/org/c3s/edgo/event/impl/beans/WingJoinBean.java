package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class WingJoinBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * JSON array of other player names already in wing
	 */
	private String[] Others;

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
	public String[] getOthers() {
		return Others;
	}

	/**
	 * @param others
	 */
	public void setOthers(String[] others) {
		this.Others = others;
	}

}
