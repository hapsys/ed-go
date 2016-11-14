package org.c3s.edgo.event.impl.beans;

public class LocationBean {
	/**
	 *  name of destination starsystem
	 */
	private String StarSystem;
	/**
	 *  star position, as a Json array [x, y, z], in light years
	 */
	private String StarPos;
	/**
	 *  star’s body name
	 */
	private String Body;
	/**
	 *  true (if docked)
	 */
	private String Docked;
	/**
	 *  station name, (if docked)
	 */
	private String StationName;
	/**
	 *  (if docked)
	 */
	private String StationType;
	/**
	 *  star system controlling faction
	 */
	private String Faction;
	/**
	 * 
	 */
	private String FactionState;
	/**
	 * 
	 */
	private String Allegiance;
	/**
	 * 
	 */
	private String Economy;
	/**
	 * 
	 */
	private String Government;
	/**
	 * 
	 */
	private String Security;
	/**
	 * @return
	 */
	public String getStarSystem() {
		return StarSystem;
	}
	/**
	 * @param starsystem
	 */
	public void setStarSystem(String starsystem) {
		this.StarSystem = starsystem;
	}
	/**
	 * @return
	 */
	public String getStarPos() {
		return StarPos;
	}
	/**
	 * @param starpos
	 */
	public void setStarPos(String starpos) {
		this.StarPos = starpos;
	}
	/**
	 * @return
	 */
	public String getBody() {
		return Body;
	}
	/**
	 * @param body
	 */
	public void setBody(String body) {
		this.Body = body;
	}
	/**
	 * @return
	 */
	public String getDocked() {
		return Docked;
	}
	/**
	 * @param docked
	 */
	public void setDocked(String docked) {
		this.Docked = docked;
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
	public String getStationType() {
		return StationType;
	}
	/**
	 * @param stationtype
	 */
	public void setStationType(String stationtype) {
		this.StationType = stationtype;
	}
	/**
	 * @return
	 */
	public String getFaction() {
		return Faction;
	}
	/**
	 * @param faction
	 */
	public void setFaction(String faction) {
		this.Faction = faction;
	}
	/**
	 * @return
	 */
	public String getFactionState() {
		return FactionState;
	}
	/**
	 * @param factionstate
	 */
	public void setFactionState(String factionstate) {
		this.FactionState = factionstate;
	}
	/**
	 * @return
	 */
	public String getAllegiance() {
		return Allegiance;
	}
	/**
	 * @param allegiance
	 */
	public void setAllegiance(String allegiance) {
		this.Allegiance = allegiance;
	}
	/**
	 * @return
	 */
	public String getEconomy() {
		return Economy;
	}
	/**
	 * @param economy
	 */
	public void setEconomy(String economy) {
		this.Economy = economy;
	}
	/**
	 * @return
	 */
	public String getGovernment() {
		return Government;
	}
	/**
	 * @param government
	 */
	public void setGovernment(String government) {
		this.Government = government;
	}
	/**
	 * @return
	 */
	public String getSecurity() {
		return Security;
	}
	/**
	 * @param security
	 */
	public void setSecurity(String security) {
		this.Security = security;
	}
	
}	
	