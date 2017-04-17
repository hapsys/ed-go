package org.c3s.edgo.event.impl.beans;

import java.util.Date;
import org.c3s.edgo.event.AbstractEventBean;

public class CargoBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 *  array of cargo, with Name and Count for each
	 */
	private String Inventory;
	
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
	public String getInventory() {
		return Inventory;
	}
	/**
	 * @param inventory
	 */
	public void setInventory(String inventory) {
		this.Inventory = inventory;
	}
	
}	
	