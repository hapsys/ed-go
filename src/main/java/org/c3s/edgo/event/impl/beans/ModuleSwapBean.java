package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class ModuleSwapBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String FromSlot;
	/**
	 * 
	 */
	private String ToSlot;
	/**
	 * 
	 */
	private String FromItem;
	/**
	 * 
	 */
	private String ToItem;
	/**
	 * 
	 */
	private String Ship;
	/**
	 * 
	 */
	private String ShipID;

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
	public String getFromSlot() {
		return FromSlot;
	}

	/**
	 * @param fromslot
	 */
	public void setFromSlot(String fromslot) {
		this.FromSlot = fromslot;
	}

	/**
	 * @return
	 */
	public String getToSlot() {
		return ToSlot;
	}

	/**
	 * @param toslot
	 */
	public void setToSlot(String toslot) {
		this.ToSlot = toslot;
	}

	/**
	 * @return
	 */
	public String getFromItem() {
		return FromItem;
	}

	/**
	 * @param fromitem
	 */
	public void setFromItem(String fromitem) {
		this.FromItem = fromitem;
	}

	/**
	 * @return
	 */
	public String getToItem() {
		return ToItem;
	}

	/**
	 * @param toitem
	 */
	public void setToItem(String toitem) {
		this.ToItem = toitem;
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
	public String getShipID() {
		return ShipID;
	}

	/**
	 * @param shipid
	 */
	public void setShipID(String shipid) {
		this.ShipID = shipid;
	}

}
