package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class MissionAcceptedBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * name of mission
	 */
	private String Name;
	/**
	 * faction offering mission
	 */
	private String Faction;
	/**
	 * 
	 */
	private int MissionID;
	/**
	 * commodity type
	 */
	private String Commodity;
	/**
	 * number required / to deliver
	 */
	private int Count;
	/**
	 * name of target
	 */
	private String Target;
	/**
	 * type of target
	 */
	private String TargetType;
	/**
	 * targets faction
	 */
	private String TargetFaction;
	/**
	 * mission expiry time, in ISO 8601
	 */
	private Date Expiry;
	/**
	 * 
	 */
	private String DestinationSystem;
	/**
	 * 
	 */
	private String DestinationStation;
	/**
	 * 
	 */
	private int PassengerCount;
	/**
	 * bool
	 */
	private boolean PassengerVIPs;
	/**
	 * bool
	 */
	private boolean PassengerWanted;
	/**
	 * eg Tourist, Soldier, Explorer,...
	 */
	private String PassengerType;
	/**
	 * 
	 */
	private String Influence;
	/**
	 * 
	 */
	private String Reputation;
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
	public Date getExpiry() {
		return Expiry;
	}

	/**
	 * @param expiry
	 */
	public void setExpiry(Date expiry) {
		this.Expiry = expiry;
	}

	/**
	 * @return
	 */
	public String getDestinationSystem() {
		return DestinationSystem;
	}

	/**
	 * @param destinationsystem
	 */
	public void setDestinationSystem(String destinationsystem) {
		this.DestinationSystem = destinationsystem;
	}

	/**
	 * @return
	 */
	public String getDestinationStation() {
		return DestinationStation;
	}

	/**
	 * @param destinationstation
	 */
	public void setDestinationStation(String destinationstation) {
		this.DestinationStation = destinationstation;
	}

	/**
	 * @return
	 */
	public int getPassengerCount() {
		return PassengerCount;
	}

	/**
	 * @param passengercount
	 */
	public void setPassengerCount(int passengercount) {
		this.PassengerCount = passengercount;
	}

	/**
	 * @return
	 */
	public boolean getPassengerVIPs() {
		return PassengerVIPs;
	}

	/**
	 * @param passengervips
	 */
	public void setPassengerVIPs(boolean passengervips) {
		this.PassengerVIPs = passengervips;
	}

	/**
	 * @return
	 */
	public boolean getPassengerWanted() {
		return PassengerWanted;
	}

	/**
	 * @param passengerwanted
	 */
	public void setPassengerWanted(boolean passengerwanted) {
		this.PassengerWanted = passengerwanted;
	}

	/**
	 * @return
	 */
	public String getPassengerType() {
		return PassengerType;
	}

	/**
	 * @param passengertype
	 */
	public void setPassengerType(String passengertype) {
		this.PassengerType = passengertype;
	}

	public String getInfluence() {
		return Influence;
	}

	public void setInfluence(String influence) {
		Influence = influence;
	}

	public String getReputation() {
		return Reputation;
	}

	public void setReputation(String reputation) {
		Reputation = reputation;
	}

}
