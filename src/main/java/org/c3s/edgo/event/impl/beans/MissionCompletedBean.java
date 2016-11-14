package org.c3s.edgo.event.impl.beans;

public class MissionCompletedBean {
	/**
	 *  mission type
	 */
	private String Name;
	/**
	 *  faction name
	 */
	private String Faction;
	/**
	 * 
	 */
	private String MissionID;
	/**
	 *  (depending on mission type)
	 */
	private String parameters;
	/**
	 * 
	 */
	private String Commodity;
	/**
	 * 
	 */
	private String Count;
	/**
	 * 
	 */
	private String Target;
	/**
	 * 
	 */
	private String TargetType;
	/**
	 * 
	 */
	private String TargetFaction;
	/**
	 *  value of reward
	 */
	private String Reward;
	/**
	 *  donation offered (for altruism missions)
	 */
	private String Donation;
	/**
	 * [] (names of any permits awarded, as a JSON array)
	 */
	private String PermitsAwarded;
	/**
	 * @return
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.Name = name;
	}
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
	public String getMissionID() {
		return MissionID;
	}
	/**
	 * @param missionid
	 */
	public void setMissionID(String missionid) {
		this.MissionID = missionid;
	}
	/**
	 * @return
	 */
	public String getparameters() {
		return parameters;
	}
	/**
	 * @param parameters
	 */
	public void setparameters(String parameters) {
		this.parameters = parameters;
	}
	/**
	 * @return
	 */
	public String getCommodity() {
		return Commodity;
	}
	/**
	 * @param commodity
	 */
	public void setCommodity(String commodity) {
		this.Commodity = commodity;
	}
	/**
	 * @return
	 */
	public String getCount() {
		return Count;
	}
	/**
	 * @param count
	 */
	public void setCount(String count) {
		this.Count = count;
	}
	/**
	 * @return
	 */
	public String getTarget() {
		return Target;
	}
	/**
	 * @param target
	 */
	public void setTarget(String target) {
		this.Target = target;
	}
	/**
	 * @return
	 */
	public String getTargetType() {
		return TargetType;
	}
	/**
	 * @param targettype
	 */
	public void setTargetType(String targettype) {
		this.TargetType = targettype;
	}
	/**
	 * @return
	 */
	public String getTargetFaction() {
		return TargetFaction;
	}
	/**
	 * @param targetfaction
	 */
	public void setTargetFaction(String targetfaction) {
		this.TargetFaction = targetfaction;
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
	public String getDonation() {
		return Donation;
	}
	/**
	 * @param donation
	 */
	public void setDonation(String donation) {
		this.Donation = donation;
	}
	/**
	 * @return
	 */
	public String getPermitsAwarded() {
		return PermitsAwarded;
	}
	/**
	 * @param permitsawarded
	 */
	public void setPermitsAwarded(String permitsawarded) {
		this.PermitsAwarded = permitsawarded;
	}
	
}	
	