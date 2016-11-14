package org.c3s.edgo.event.impl.beans;

public class BountyBean {
	/**
	 *  the faction awarding the bounty
	 */
	private String Faction;
	/**
	 *  the reward value
	 */
	private String Reward;
	/**
	 *  the victim’s faction
	 */
	private String VictimFaction;
	/**
	 *  whether shared with other players
	 */
	private String SharedWithOthers;
	/**
	 * @return
	 */
	public String getFaction() {
		return Faction;
	}
	/**
	 * @param faction
	 */
	public void setFaction(String faction) {
		this.Faction = faction;
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
	public String getSharedWithOthers() {
		return SharedWithOthers;
	}
	/**
	 * @param sharedwithothers
	 */
	public void setSharedWithOthers(String sharedwithothers) {
		this.SharedWithOthers = sharedwithothers;
	}
	
}	
	