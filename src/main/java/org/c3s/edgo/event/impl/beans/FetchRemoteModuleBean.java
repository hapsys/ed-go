package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class FetchRemoteModuleBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String StorageSlot;
	/**
	 * 
	 */
	private String StoredItem;
	/**
	 * 
	 */
	private String ServerId;
	/**
	 * 
	 */
	private String TransferCost;
	/**
	 * 
	 */
	private String Ship;
	/**
	 * 
	 */
	private String ShipId;

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
	public String getStorageSlot() {
		return StorageSlot;
	}

	/**
	 * @param storageslot
	 */
	public void setStorageSlot(String storageslot) {
		this.StorageSlot = storageslot;
	}

	/**
	 * @return
	 */
	public String getStoredItem() {
		return StoredItem;
	}

	/**
	 * @param storeditem
	 */
	public void setStoredItem(String storeditem) {
		this.StoredItem = storeditem;
	}

	/**
	 * @return
	 */
	public String getServerId() {
		return ServerId;
	}

	/**
	 * @param serverid
	 */
	public void setServerId(String serverid) {
		this.ServerId = serverid;
	}

	/**
	 * @return
	 */
	public String getTransferCost() {
		return TransferCost;
	}

	/**
	 * @param transfercost
	 */
	public void setTransferCost(String transfercost) {
		this.TransferCost = transfercost;
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
	public String getShipId() {
		return ShipId;
	}

	/**
	 * @param shipid
	 */
	public void setShipId(String shipid) {
		this.ShipId = shipid;
	}

}
