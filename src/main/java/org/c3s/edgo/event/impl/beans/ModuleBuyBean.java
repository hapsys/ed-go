package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class ModuleBuyBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * the outfitting slot
	 */
	private String Slot;
	/**
	 * the module being purchased
	 */
	private String BuyItem;
	/**
	 * price paid
	 */
	private String BuyPrice;
	/**
	 * the players ship
	 */
	private String Ship;
	/**
	 * 
	 */
	private int ShipID;
	/**
	 * an existing module:
	 */
	private String replacing;
	/**
	 * item being sold
	 */
	private String SellItem;
	/**
	 * sale price
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
	public String getBuyItem() {
		return BuyItem;
	}

	/**
	 * @param buyitem
	 */
	public void setBuyItem(String buyitem) {
		this.BuyItem = buyitem;
	}

	/**
	 * @return
	 */
	public String getBuyPrice() {
		return BuyPrice;
	}

	/**
	 * @param buyprice
	 */
	public void setBuyPrice(String buyprice) {
		this.BuyPrice = buyprice;
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

	/**
	 * @return
	 */
	public String getreplacing() {
		return replacing;
	}

	/**
	 * @param replacing
	 */
	public void setreplacing(String replacing) {
		this.replacing = replacing;
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

}
