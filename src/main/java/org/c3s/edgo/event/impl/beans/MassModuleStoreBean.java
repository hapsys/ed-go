package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class MassModuleStoreBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String Ship;
	/**
	 * 
	 */
	private String ShipId;
	/**
	 * Array of records
	 */
	private String Items;
	/**
	 * 
	 */
	private String Slot;
	/**
	 * 
	 */
	private String Name;
	/**
	 * (only present if modified)
	 */
	private String EngineerModifications;

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

	/**
	 * @return
	 */
	public String getItems() {
		return Items;
	}

	/**
	 * @param items
	 */
	public void setItems(String items) {
		this.Items = items;
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
	public String getName() {
		return Name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.Name = name;
	}

	/**
	 * @return
	 */
	public String getEngineerModifications() {
		return EngineerModifications;
	}

	/**
	 * @param engineermodifications
	 */
	public void setEngineerModifications(String engineermodifications) {
		this.EngineerModifications = engineermodifications;
	}

}
