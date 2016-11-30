package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class ShipyardSellBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * type of ship being sold
	 */
	private String ShipType;
	/**
	 * 
	 */
	private int SellShipID;
	/**
	 * sale price
	 */
	private String ShipPrice;
	/**
	 * (if ship is in another system) name of system
	 */
	private String System;

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
	public int getSellShipID() {
		return SellShipID;
	}

	/**
	 * @param sellshipid
	 */
	public void setSellShipID(int sellshipid) {
		this.SellShipID = sellshipid;
	}

	/**
	 * @return
	 */
	public String getShipPrice() {
		return ShipPrice;
	}

	/**
	 * @param shipprice
	 */
	public void setShipPrice(String shipprice) {
		this.ShipPrice = shipprice;
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

}
