package org.c3s.edgo.event.impl.beans;

public class DockingGrantedBean {
	/**
	 *  name of station
	 */
	private String StationName;
	/**
	 *  pad number
	 */
	private String LandingPad;
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
	public String getLandingPad() {
		return LandingPad;
	}
	/**
	 * @param landingpad
	 */
	public void setLandingPad(String landingpad) {
		this.LandingPad = landingpad;
	}
	
}	
	