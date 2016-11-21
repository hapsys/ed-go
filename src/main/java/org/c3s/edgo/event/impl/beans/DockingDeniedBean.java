package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class DockingDeniedBean {

	private Date timestamp;
	private String event;
	/**
	 *  name of station
	 */
	private String StationName;
	/**
	 *  reason for denial
	 */
	private String Reason;
	
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
	public String getStationName() {
		return StationName;
	}
	/**
	 * @param stationname
	 */
	public void setStationName(String stationname) {
		this.StationName = stationname;
	}
	/**
	 * @return
	 */
	public String getReason() {
		return Reason;
	}
	/**
	 * @param reason
	 */
	public void setReason(String reason) {
		this.Reason = reason;
	}
	
}	
	