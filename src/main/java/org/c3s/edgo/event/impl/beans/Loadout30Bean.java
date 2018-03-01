package org.c3s.edgo.event.impl.beans;

import java.util.Date;
import org.c3s.edgo.event.AbstractEventBean;
import org.c3s.edgo.event.impl.beans.intl.loadout30.Module;

public class Loadout30Bean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * current ship type
	 */
	private String Ship;
	/**
	 * ship id number (indicates which of your ships you are in)
	 */
	private int ShipID;
	/**
	 * user-defined ship name
	 */
	private String ShipName;
	/**
	 * user-defined ship ID string
	 */
	private String ShipIdent;

	private Module[] Modules;

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
	public String getShipName() {
		return ShipName;
	}

	/**
	 * @param shipname
	 */
	public void setShipName(String shipname) {
		this.ShipName = shipname;
	}

	/**
	 * @return
	 */
	public String getShipIdent() {
		return ShipIdent;
	}

	/**
	 * @param shipident
	 */
	public void setShipIdent(String shipident) {
		this.ShipIdent = shipident;
	}

	public Module[] getModules() {
		return Modules;
	}

	public void setModules(Module[] modules) {
		Modules = modules;
	}

}
