package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class BuyTradeDataBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * star system requested
	 */
	private String System;
	/**
	 * cost of data
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
	public String getSystem() {
		return System;
	}

	/**
	 * @param system
	 */
	public void setSystem(String system) {
		this.System = system;
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
