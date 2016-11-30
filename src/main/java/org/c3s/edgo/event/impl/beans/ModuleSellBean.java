package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class ModuleSellBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String Slot;
	/**
	 * 
	 */
	private String SellItem;
	/**
	 * 
	 */
	private String SellPrice;
	/**
	 * 
	 */
	private String Ship;
	/**
	 * 
	 */
	private int ShipID;

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
	public String getSlot() {
		return Slot;
	}

	/**
	 * @param slot
	 */
	public void setSlot(String slot) {
		this.Slot = slot;
	}

	/**
	 * @return
	 */
	public String getSellItem() {
		return SellItem;
	}

	/**
	 * @param sellitem
	 */
	public void setSellItem(String sellitem) {
		this.SellItem = sellitem;
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

	/**
	 * @return
	 */
	public String getShip() {
		return Ship;
	}

	/**
	 * @param ship
	 */
	public void setShip(String ship) {
		this.Ship = ship;
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

}
