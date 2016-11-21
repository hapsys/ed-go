package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class RestockVehicleBean {

	private Date timestamp;
	private String event;
	/**
	 *  type of vehicle being purchased (SRV or fighter model)
	 */
	private String Type;
	/**
	 *  variant
	 */
	private String Loadout;
	/**
	 *  purchase cost
	 */
	private String Cost;
	/**
	 *  number of vehicles purchased
	 */
	private String Count;
	
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
	public String getType() {
		return Type;
	}
	/**
	 * @param type
	 */
	public void setType(String type) {
		this.Type = type;
	}
	/**
	 * @return
	 */
	public String getLoadout() {
		return Loadout;
	}
	/**
	 * @param loadout
	 */
	public void setLoadout(String loadout) {
		this.Loadout = loadout;
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
	/**
	 * @return
	 */
	public String getCount() {
		return Count;
	}
	/**
	 * @param count
	 */
	public void setCount(String count) {
		this.Count = count;
	}
	
}	
	