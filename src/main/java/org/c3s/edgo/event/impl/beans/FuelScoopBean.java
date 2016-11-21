package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class FuelScoopBean {

	private Date timestamp;
	private String event;
	/**
	 *  tons fuel scooped
	 */
	private String Scooped;
	/**
	 *  total fuel level after scooping
	 */
	private String Total;
	
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
	public String getScooped() {
		return Scooped;
	}
	/**
	 * @param scooped
	 */
	public void setScooped(String scooped) {
		this.Scooped = scooped;
	}
	/**
	 * @return
	 */
	public String getTotal() {
		return Total;
	}
	/**
	 * @param total
	 */
	public void setTotal(String total) {
		this.Total = total;
	}
	
}	
	