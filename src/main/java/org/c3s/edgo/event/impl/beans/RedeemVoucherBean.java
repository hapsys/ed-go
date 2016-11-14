package org.c3s.edgo.event.impl.beans;

public class RedeemVoucherBean {
	/**
	 * 
	 */
	private String Type;
	/**
	 *  (Net amount received, after any broker fee)
	 */
	private String Amount;
	/**
	 *  (if redeemed through a broker)
	 */
	private String BrokerPercenentage;
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
	public String getBrokerPercenentage() {
		return BrokerPercenentage;
	}
	/**
	 * @param brokerpercenentage
	 */
	public void setBrokerPercenentage(String brokerpercenentage) {
		this.BrokerPercenentage = brokerpercenentage;
	}
	
}	
	