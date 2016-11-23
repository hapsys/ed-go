package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class PayLegacyFinesBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * (total amount paid, including any broker fee)
	 */
	private String Amount;
	/**
	 * (present if paid through a broker)
	 */
	private String BrokerPercentage;

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
	public String getAmount() {
		return Amount;
	}

	/**
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.Amount = amount;
	}

	/**
	 * @return
	 */
	public String getBrokerPercentage() {
		return BrokerPercentage;
	}

	/**
	 * @param brokerpercentage
	 */
	public void setBrokerPercentage(String brokerpercentage) {
		this.BrokerPercentage = brokerpercentage;
	}

}
