package org.c3s.edgo.event.impl.beans;

import java.math.BigInteger;
import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;
import org.c3s.edgo.event.impl.beans.intl.FactionBean;
import org.c3s.edgo.utils.json.SystemFactionAdapter;

import com.google.gson.annotations.JsonAdapter;

public class DockedBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * name of station
	 */
	private String StationName;
	/**
	 * type of station
	 */
	private String StationType;
	/**
	 * name of system
	 */
	private String StarSystem;
	/**
	 * true (only if landing with breached cockpit)
	 */
	private String CockpitBreach;
	/**
	 * stations controlling faction
	 */
	@JsonAdapter(SystemFactionAdapter.class)
	private FactionBean StationFaction;
	/**
	 * 
	 */
	private String FactionState;
	/**
	 * 
	 */
	private String StationAllegiance;
	/**
	 * 
	 */
	private String StationEconomy;
	/**
	 * 
	 */
	private String StationGovernment;
	
	/**
	 * 
	 */
	private Float DistFromStarLS;

	/**
	 * 
	 */
	private BigInteger SystemAddress;
	
	/**
	 * 
	 */
	private BigInteger MarketID;
	
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
	public String getCockpitBreach() {
		return CockpitBreach;
	}

	/**
	 * @param cockpitbreach
	 */
	public void setCockpitBreach(String cockpitbreach) {
		this.CockpitBreach = cockpitbreach;
	}

	/**
	 * @return
	 */
	public FactionBean getStationFaction() {
		return StationFaction;
	}

	/**
	 * @param stationfaction
	 */
	public void setStationFaction(FactionBean stationfaction) {
		this.StationFaction = stationfaction;
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
	public String getStationAllegiance() {
		return StationAllegiance;
	}

	/**
	 * @param stationallegiance
	 */
	public void setStationAllegiance(String stationallegiance) {
		this.StationAllegiance = stationallegiance;
	}

	/**
	 * @return
	 */
	public String getStationEconomy() {
		return StationEconomy;
	}

	/**
	 * @param stationeconomy
	 */
	public void setStationEconomy(String stationeconomy) {
		this.StationEconomy = stationeconomy;
	}

	/**
	 * @return
	 */
	public String getStationGovernment() {
		return StationGovernment;
	}

	/**
	 * @param stationgovernment
	 */
	public void setStationGovernment(String stationgovernment) {
		this.StationGovernment = stationgovernment;
	}

	public Float getDistFromStarLS() {
		return DistFromStarLS;
	}

	public void setDistFromStarLS(Float distFromStarLS) {
		DistFromStarLS = distFromStarLS;
	}

	public BigInteger getSystemAddress() {
		return SystemAddress;
	}

	public void setSystemAddress(BigInteger systemAddress) {
		SystemAddress = systemAddress;
	}

	public BigInteger getMarketID() {
		return MarketID;
	}

	public void setMarketID(BigInteger marketID) {
		MarketID = marketID;
	}
}
