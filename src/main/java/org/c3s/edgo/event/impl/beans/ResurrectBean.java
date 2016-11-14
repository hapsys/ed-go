package org.c3s.edgo.event.impl.beans;

public class ResurrectBean {
	/**
	 *  the option selected on the insurance rebuy screen
	 */
	private String Option;
	/**
	 *  the price paid
	 */
	private String Cost;
	/**
	 *  whether the commander declared bankruptcy
	 */
	private String Bankrupt;
	/**
	 * @return
	 */
	public String getOption() {
		return Option;
	}
	/**
	 * @param option
	 */
	public void setOption(String option) {
		this.Option = option;
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
	public String getBankrupt() {
		return Bankrupt;
	}
	/**
	 * @param bankrupt
	 */
	public void setBankrupt(String bankrupt) {
		this.Bankrupt = bankrupt;
	}
	
}	
	