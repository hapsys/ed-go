package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class ShipyardTransferBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * type of ship
	 */
	private String ShipType;
	/**
	 * 
	 */
	private String ShipID;
	/**
	 * where it is
	 */
	private String System;
	/**
	 * how far away
	 */
	private String Distance;
	/**
	 * cost of transfer
	 */
	private String TransferPrice;

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
	public String getShipType() {
		return ShipType;
	}

	/**
	 * @param shiptype
	 */
	public void setShipType(String shiptype) {
		this.ShipType = shiptype;
	}

	/**
	 * @return
	 */
	public String getShipID() {
		return ShipID;
	}

	/**
	 * @param shipid
	 */
	public void setShipID(String shipid) {
		this.ShipID = shipid;
	}

	/**
	 * @return
	 */
	public String getSystem() {
		return System;
	}

	/**
	 * @param system
	 */
	public void setSystem(String system) {
		this.System = system;
	}

	/**
	 * @return
	 */
	public String getDistance() {
		return Distance;
	}

	/**
	 * @param distance
	 */
	public void setDistance(String distance) {
		this.Distance = distance;
	}

	/**
	 * @return
	 */
	public String getTransferPrice() {
		return TransferPrice;
	}

	/**
	 * @param transferprice
	 */
	public void setTransferPrice(String transferprice) {
		this.TransferPrice = transferprice;
	}

}
