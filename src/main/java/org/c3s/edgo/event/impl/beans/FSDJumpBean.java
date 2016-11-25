package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class FSDJumpBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * name of destination starsystem
	 */
	private String StarSystem;
	/**
	 * star position, as a Json array [x, y, z], in light years
	 */
	private Float[] StarPos;
	/**
	 * stars body name
	 */
	private String Body;
	/**
	 * distance jumped
	 */
	private String JumpDist;
	/**
	 * 
	 */
	private String FuelUsed;
	/**
	 * 
	 */
	private String FuelLevel;
	/**
	 * whether FSD boost was used
	 */
	private String BoostUsed;
	/**
	 * system controlling faction
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

	
	public String getPowerplayState() {
		return PowerplayState;
	}

	public void setPowerplayState(String powerplayState) {
		PowerplayState = powerplayState;
	}

	public String[] getPowers() {
		return Powers;
	}

	public void setPowers(String[] powers) {
		Powers = powers;
	}

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
	public String getJumpDist() {
		return JumpDist;
	}

	/**
	 * @param jumpdist
	 */
	public void setJumpDist(String jumpdist) {
		this.JumpDist = jumpdist;
	}

	/**
	 * @return
	 */
	public String getFuelUsed() {
		return FuelUsed;
	}

	/**
	 * @param fuelused
	 */
	public void setFuelUsed(String fuelused) {
		this.FuelUsed = fuelused;
	}

	/**
	 * @return
	 */
	public String getFuelLevel() {
		return FuelLevel;
	}

	/**
	 * @param fuellevel
	 */
	public void setFuelLevel(String fuellevel) {
		this.FuelLevel = fuellevel;
	}

	/**
	 * @return
	 */
	public String getBoostUsed() {
		return BoostUsed;
	}

	/**
	 * @param boostused
	 */
	public void setBoostUsed(String boostused) {
		this.BoostUsed = boostused;
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

}
