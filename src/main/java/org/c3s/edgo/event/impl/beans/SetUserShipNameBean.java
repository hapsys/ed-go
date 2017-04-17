package org.c3s.edgo.event.impl.beans;

import java.util.Date;
import org.c3s.edgo.event.AbstractEventBean;

public class SetUserShipNameBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 *  Ship model (eg CobraMkIII)
	 */
	private String Ship;
	/**
	 *  player's ship ID number
	 */
	private int ShipID;
	/**
	 *  selected name
	 */
	private String UserShipName;
	/**
	 *  selected ship id
	 */
	private String UserShipId;
	
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
	public String getUserShipName() {
		return UserShipName;
	}
	/**
	 * @param usershipname
	 */
	public void setUserShipName(String usershipname) {
		this.UserShipName = usershipname;
	}
	/**
	 * @return
	 */
	public String getUserShipId() {
		return UserShipId;
	}
	/**
	 * @param usershipid
	 */
	public void setUserShipId(String usershipid) {
		this.UserShipId = usershipid;
	}
	
}	
	