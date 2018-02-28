package org.c3s.edgo.event.impl.beans;

import java.math.BigInteger;
import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;
import org.c3s.edgo.event.impl.beans.intl.FactionBean;

public class LocationBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * name of destination starsystem
	 */
	private String StarSystem;
	
	/**
	 * 
	 */
	private BigInteger SystemAddress;
	
	/**
	 * star position, as a Json array [x, y, z], in light years
	 */
	private Float[] StarPos;
	/**
	 * star or planets body name
	 */
	private String Body;
	/**
	 * 
	 */
	private String BodyType;
	/**
	 * (bool)
	 */
	private String Docked;
	/**
	 * station name, (if docked)
	 */
	private String StationName;
	/**
	 * (if docked)
	 */
	private String StationType;
	/**
	 * star system controlling faction
	 */
	private String SystemFaction;
	/**
	 * 
	 */
	private String FactionState;
	/**
	 * 
	 */
	private String SystemAllegiance;
	/**
	 * 
	 */
	private String SystemEconomy;
	/**
	 * 
	 */
	private String SystemGovernment;
	/**
	 * 
	 */
	private String SystemSecurity;
	/**
	 * player is pledged to a Power in Powerplay, and the star system is
	 * involved in powerplay,
	 */
	private String PowerplayState;
	/**
	 * a json array with the names of any powers contesting the system, or the
	 * name of the controlling power
	 */
	private String[] Powers;
	/**
	 * 
	 */
	private FactionBean[] Factions;
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
	public Float[] getStarPos() {
		return StarPos;
	}

	/**
	 * @param starpos
	 */
	public void setStarPos(Float[] starpos) {
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
	public String getBodyType() {
		return BodyType;
	}

	/**
	 * @param bodytype
	 */
	public void setBodyType(String bodytype) {
		this.BodyType = bodytype;
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
	public String getSystemFaction() {
		return SystemFaction;
	}

	/**
	 * @param systemfaction
	 */
	public void setSystemFaction(String systemfaction) {
		this.SystemFaction = systemfaction;
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
	public String getSystemAllegiance() {
		return SystemAllegiance;
	}

	/**
	 * @param systemallegiance
	 */
	public void setSystemAllegiance(String systemallegiance) {
		this.SystemAllegiance = systemallegiance;
	}

	/**
	 * @return
	 */
	public String getSystemEconomy() {
		return SystemEconomy;
	}

	/**
	 * @param systemeconomy
	 */
	public void setSystemEconomy(String systemeconomy) {
		this.SystemEconomy = systemeconomy;
	}

	/**
	 * @return
	 */
	public String getSystemGovernment() {
		return SystemGovernment;
	}

	/**
	 * @param systemgovernment
	 */
	public void setSystemGovernment(String systemgovernment) {
		this.SystemGovernment = systemgovernment;
	}

	/**
	 * @return
	 */
	public String getSystemSecurity() {
		return SystemSecurity;
	}

	/**
	 * @param systemsecurity
	 */
	public void setSystemSecurity(String systemsecurity) {
		this.SystemSecurity = systemsecurity;
	}

	/**
	 * @return
	 */
	public String getPowerplayState() {
		return PowerplayState;
	}

	/**
	 * @param the
	 */
	public void setPowerplayState(String the) {
		this.PowerplayState = the;
	}

	/**
	 * @return
	 */
	public String[] getPowers() {
		return Powers;
	}

	/**
	 * @param powers
	 */
	public void setPowers(String[] powers) {
		this.Powers = powers;
	}

	public FactionBean[] getFactions() {
		return Factions;
	}

	public void setFactions(FactionBean[] factions) {
		Factions = factions;
	}

	public BigInteger getSystemAddress() {
		return SystemAddress;
	}

	public void setSystemAddress(BigInteger systemAddress) {
		SystemAddress = systemAddress;
	}

}
