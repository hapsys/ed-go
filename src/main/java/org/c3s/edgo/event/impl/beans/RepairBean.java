package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class RepairBean {

	private Date timestamp;
	private String event;
	/**
	 *  all, wear, hull, paint, or name of module
	 */
	private String Item;
	/**
	 *  cost of repair
	 */
	private String Cost;
	
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
	public String getItem() {
		return Item;
	}
	/**
	 * @param item
	 */
	public void setItem(String item) {
		this.Item = item;
	}
	/**
	 * @return
	 */
	public String getCost() {
		return Cost;
	}
	/**
	 * @param cost
	 */
	public void setCost(String cost) {
		this.Cost = cost;
	}
	
}	
	