package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class TouchdownBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String Latitude;
	/**
	 * 
	 */
	private String Longitude;

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
	public String getLatitude() {
		return Latitude;
	}

	/**
	 * @param latitude
	 */
	public void setLatitude(String latitude) {
		this.Latitude = latitude;
	}

	/**
	 * @return
	 */
	public String getLongitude() {
		return Longitude;
	}

	/**
	 * @param longitude
	 */
	public void setLongitude(String longitude) {
		this.Longitude = longitude;
	}

}
