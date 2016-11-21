package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class DatalinkVoucherBean {

	private Date timestamp;
	private String event;
	/**
	 *  value in credits
	 */
	private String Reward;
	/**
	 * 
	 */
	private String VictimFaction;
	/**
	 * 
	 */
	private String PayeeFaction;
	
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
	public String getReward() {
		return Reward;
	}
	/**
	 * @param reward
	 */
	public void setReward(String reward) {
		this.Reward = reward;
	}
	/**
	 * @return
	 */
	public String getVictimFaction() {
		return VictimFaction;
	}
	/**
	 * @param victimfaction
	 */
	public void setVictimFaction(String victimfaction) {
		this.VictimFaction = victimfaction;
	}
	/**
	 * @return
	 */
	public String getPayeeFaction() {
		return PayeeFaction;
	}
	/**
	 * @param payeefaction
	 */
	public void setPayeeFaction(String payeefaction) {
		this.PayeeFaction = payeefaction;
	}
	
}	
	