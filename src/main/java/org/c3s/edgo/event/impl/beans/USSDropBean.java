package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class USSDropBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * description of USS
	 */
	private String USSType;
	/**
	 * threat level
	 */
	private String USSThreat;

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
	public String getUSSType() {
		return USSType;
	}

	/**
	 * @param usstype
	 */
	public void setUSSType(String usstype) {
		this.USSType = usstype;
	}

	/**
	 * @return
	 */
	public String getUSSThreat() {
		return USSThreat;
	}

	/**
	 * @param ussthreat
	 */
	public void setUSSThreat(String ussthreat) {
		this.USSThreat = ussthreat;
	}

}
