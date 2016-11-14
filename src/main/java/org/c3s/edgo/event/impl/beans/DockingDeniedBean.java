package org.c3s.edgo.event.impl.beans;

public class DockingDeniedBean {
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
	