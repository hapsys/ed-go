package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class RefuelPartialBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * cost of fuel
	 */
	private String Cost;
	/**
	 * tons of fuel purchased
	 */
	private String Amount;

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
	public String getAmount() {
		return Amount;
	}

	/**
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.Amount = amount;
	}

}
