package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class MissionFailedBean {

	private Date timestamp;
	private String event;
	/**
	 *  name of mission
	 */
	private String Name;
	/**
	 * 
	 */
	private String MissionID;
	
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
	public String getMissionID() {
		return MissionID;
	}
	/**
	 * @param missionid
	 */
	public void setMissionID(String missionid) {
		this.MissionID = missionid;
	}
	
}	
	