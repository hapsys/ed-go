package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class BountyBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * an array of Faction names and the Reward values, as the target can have
	 * multiple bounties payable by different factions
	 */
	private Reward[] Rewards;
	/**
	 * the victims faction
	 */
	private String VictimFaction;
	/**
	 * 
	 */
	private int TotalReward;
	/**
	 * if credit for the kill is shared with other players, this has the number
	 * of other players involved
	 */
	private String SharedWithOthers;

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
	public Reward[] getRewards() {
		return Rewards;
	}

	/**
	 * @param rewards
	 */
	public void setRewards(Reward[] rewards) {
		this.Rewards = rewards;
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
	public int getTotalReward() {
		return TotalReward;
	}

	/**
	 * @param totalreward
	 */
	public void setTotalReward(int totalreward) {
		this.TotalReward = totalreward;
	}

	/**
	 * @return
	 */
	public String getSharedWithOthers() {
		return SharedWithOthers;
	}

	/**
	 * @param sharedwithothers
	 */
	public void setSharedWithOthers(String sharedwithothers) {
		this.SharedWithOthers = sharedwithothers;
	}

	public static class Reward {
		public String Faction;
		public int Reward;
	}
}
