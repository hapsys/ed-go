package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class MissionAcceptedBean {

	private Date timestamp;
	private String event;
	/**
	 *  name of mission
	 */
	private String Name;
	/**
	 *  faction offering mission
	 */
	private String Faction;
	/**
	 * 
	 */
	private String MissionID;
	/**
	 *  (depending on mission type)
	 */
	private String Parameters;
	/**
	 *  commodity type
	 */
	private String Commodity;
	/**
	 *  number required / to deliver
	 */
	private String Count;
	/**
	 *  name of target
	 */
	private String Target;
	/**
	 *  type of target
	 */
	private String TargetType;
	/**
	 *  targets faction
	 */
	private String TargetFaction;
	/**
	 *  mission expiry time, in ISO 8601
	 */
	private String Expiry;
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
	private String PassengerCount;
	/**
	 *  bool
	 */
	private String PassengerVIPs;
	/**
	 *  bool
	 */
	private String PassengerWanted;
	/**
	 *  eg Tourist, Soldier, Explorer,...
	 */
	private String PassengerType;
	
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
	public String getParameters() {
		return Parameters;
	}
	/**
	 * @param parameters
	 */
	public void setParameters(String parameters) {
		this.Parameters = parameters;
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
	public String getExpiry() {
		return Expiry;
	}
	/**
	 * @param expiry
	 */
	public void setExpiry(String expiry) {
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
	public String getPassengerCount() {
		return PassengerCount;
	}
	/**
	 * @param passengercount
	 */
	public void setPassengerCount(String passengercount) {
		this.PassengerCount = passengercount;
	}
	/**
	 * @return
	 */
	public String getPassengerVIPs() {
		return PassengerVIPs;
	}
	/**
	 * @param passengervips
	 */
	public void setPassengerVIPs(String passengervips) {
		this.PassengerVIPs = passengervips;
	}
	/**
	 * @return
	 */
	public String getPassengerWanted() {
		return PassengerWanted;
	}
	/**
	 * @param passengerwanted
	 */
	public void setPassengerWanted(String passengerwanted) {
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
	
}	
	