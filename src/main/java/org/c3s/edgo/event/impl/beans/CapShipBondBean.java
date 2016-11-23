package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class CapShipBondBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * value of award
	 */
	private String Reward;
	/**
	 * 
	 */
	private String AwardingFaction;
	/**
	 * 
	 */
	private String VictimFaction;

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
	public String getAwardingFaction() {
		return AwardingFaction;
	}

	/**
	 * @param awardingfaction
	 */
	public void setAwardingFaction(String awardingfaction) {
		this.AwardingFaction = awardingfaction;
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

}
