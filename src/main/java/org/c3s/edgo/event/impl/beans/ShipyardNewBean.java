package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class ShipyardNewBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String ShipType;
	/**
	 * 
	 */
	private int NewShipID;

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
	public int getNewShipID() {
		return NewShipID;
	}

	/**
	 * @param shipid
	 */
	public void setNewShipID(int shipid) {
		this.NewShipID = shipid;
	}

}
