package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class ShipyardBuyBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * ship being purchased
	 */
	private String ShipType;
	/**
	 * purchase cost
	 */
	private String ShipPrice;
	/**
	 * (if storing old ship) ship type being stored
	 */
	private String StoreOldShip;
	/**
	 * 
	 */
	private int StoreShipID;
	/**
	 * (if selling current ship) ship type being sold
	 */
	private String SellOldShip;
	/**
	 * 
	 */
	private int SellShipID;
	/**
	 * (if selling current ship) ship sale price
	 */
	private String SellPrice;

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

	/**
	 * @return
	 */
	public String getSellPrice() {
		return SellPrice;
	}

	/**
	 * @param sellprice
	 */
	public void setSellPrice(String sellprice) {
		this.SellPrice = sellprice;
	}

}
