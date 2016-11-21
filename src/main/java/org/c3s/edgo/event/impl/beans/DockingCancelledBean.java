package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class DockingCancelledBean {

	private Date timestamp;
	private String event;
	/**
	 *  name of station
	 */
	private String StationName;
	
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
	
}	
	