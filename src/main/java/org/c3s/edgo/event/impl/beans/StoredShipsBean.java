package org.c3s.edgo.event.impl.beans;

import java.math.BigInteger;
import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;
import org.c3s.edgo.event.impl.beans.intl.StoredShipsHere;
import org.c3s.edgo.event.impl.beans.intl.StoredShipsRemote;

public class StoredShipsBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String StationName;

	private String StarSystem;
	
	private BigInteger MarketID;
	
	private StoredShipsHere[] ShipsHere;
	
	private StoredShipsRemote[] ShipsRemote;
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

	public String getStationName() {
		return StationName;
	}

	public void setStationName(String stationName) {
		StationName = stationName;
	}

	public String getStarSystem() {
		return StarSystem;
	}

	public void setStarSystem(String starSystem) {
		StarSystem = starSystem;
	}

	public BigInteger getMarketID() {
		return MarketID;
	}

	public void setMarketID(BigInteger marketID) {
		MarketID = marketID;
	}

	public StoredShipsHere[] getShipsHere() {
		return ShipsHere;
	}

	public void setShipsHere(StoredShipsHere[] shipsHere) {
		ShipsHere = shipsHere;
	}

	public StoredShipsRemote[] getShipsRemote() {
		return ShipsRemote;
	}

	public void setShipsRemote(StoredShipsRemote[] shipsRemote) {
		ShipsRemote = shipsRemote;
	}

	
}
