package org.c3s.edgo.event.impl.beans;

public class PayFinesBean {
	/**
	 *  (total amount paid , including any broker fee)
	 */
	private String Amount;
	/**
	 *  (present if paid via a Broker)
	 */
	private String BrokerPercentage;
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
	