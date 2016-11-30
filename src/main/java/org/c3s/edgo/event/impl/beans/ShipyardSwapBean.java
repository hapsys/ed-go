package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class ShipyardSwapBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * type of ship being switched to
	 */
	private String ShipType;
	/**
	 * 
	 */
	private int ShipID;
	/**
	 * (if storing old ship) type of ship being stored
	 */
	private String StoreOldShip;
	/**
	 * 
	 */
	private int StoreShipID;
	/**
	 * (if selling old ship) type of ship being sold
	 */
	private String SellOldShip;
	/**
	 * 
	 */
	private int SellShipID;

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
	public int getShipID() {
		return ShipID;
	}

	/**
	 * @param shipid
	 */
	public void setShipID(int shipid) {
		this.ShipID = shipid;
	}

	/**
	 * @return
	 */
	public String getStoreOldShip() {
		return StoreOldShip;
	}

	/**
	 * @param storeoldship
	 */
	public void setStoreOldShip(String storeoldship) {
		this.StoreOldShip = storeoldship;
	}

	/**
	 * @return
	 */
	public int getStoreShipID() {
		return StoreShipID;
	}

	/**
	 * @param storeshipid
	 */
	public void setStoreShipID(int storeshipid) {
		this.StoreShipID = storeshipid;
	}

	/**
	 * @return
	 */
	public String getSellOldShip() {
		return SellOldShip;
	}

	/**
	 * @param selloldship
	 */
	public void setSellOldShip(String selloldship) {
		this.SellOldShip = selloldship;
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

}
