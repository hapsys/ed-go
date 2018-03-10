package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;
import org.c3s.edgo.event.impl.beans.intl.MaterialNameCount;
import org.c3s.edgo.event.impl.beans.intl.NameCount;

public class MissionCompletedBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * mission type
	 */
	private String Name;
	/**
	 * faction name
	 */
	private String Faction;
	/**
	 * 
	 */
	private int MissionID;
	/**
	 * 
	 */
	private String Commodity;
	/**
	 * 
	 */
	private int Count;
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
	 * value of reward
	 */
	private int Reward;
	/**
	 * donation offered (for altruism missions)
	 */
	private int Donation;
	/**
	 * [] (names of any permits awarded, as a JSON array)
	 */
	private String[] PermitsAwarded;
	/**
	 * [] (names and counts of any commodity rewards)
	 */
	private Commodity[] CommodityReward;

	private MaterialNameCount[] MaterialsReward;
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
	public int getMissionID() {
		return MissionID;
	}

	/**
	 * @param missionid
	 */
	public void setMissionID(int missionid) {
		this.MissionID = missionid;
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
	public int getCount() {
		return Count;
	}

	/**
	 * @param count
	 */
	public void setCount(int count) {
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
	public int getReward() {
		return Reward;
	}

	/**
	 * @param reward
	 */
	public void setReward(int reward) {
		this.Reward = reward;
	}

	/**
	 * @return
	 */
	public int getDonation() {
		return Donation;
	}

	/**
	 * @param donation
	 */
	public void setDonation(int donation) {
		this.Donation = donation;
	}

	/**
	 * @return
	 */
	public String[] getPermitsAwarded() {
		return PermitsAwarded;
	}

	/**
	 * @param permitsawarded
	 */
	public void setPermitsAwarded(String[] permitsawarded) {
		this.PermitsAwarded = permitsawarded;
	}

	/**
	 * @return
	 */
	public Commodity[] getCommodityReward() {
		return CommodityReward;
	}

	/**
	 * @param commodityreward
	 */
	public void setCommodityReward(Commodity[] commodityreward) {
		this.CommodityReward = commodityreward;
	}

	public static class Commodity {
		
		private String Name;
		private int Count;
		
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public int getCount() {
			return Count;
		}
		public void setCount(int count) {
			Count = count;
		}
	}

	public MaterialNameCount[] getMaterialsReward() {
		return MaterialsReward;
	}

	public void setMaterialsReward(MaterialNameCount[] materialsReward) {
		MaterialsReward = materialsReward;
	}
	
}
