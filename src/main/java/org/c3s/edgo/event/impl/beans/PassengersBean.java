package org.c3s.edgo.event.impl.beans;

import java.util.Date;
import org.c3s.edgo.event.AbstractEventBean;

public class PassengersBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 *  array of passenger records, each containing:
	 */
	private String Manifest;
	/**
	 * 
	 */
	private String MissionID;
	/**
	 * 
	 */
	private String Type;
	/**
	 *  (bool)
	 */
	private String VIP;
	/**
	 *  (bool)
	 */
	private String Wanted;
	/**
	 * 
	 */
	private String Count;
	
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
	public String getManifest() {
		return Manifest;
	}
	/**
	 * @param manifest
	 */
	public void setManifest(String manifest) {
		this.Manifest = manifest;
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
	public String getType() {
		return Type;
	}
	/**
	 * @param type
	 */
	public void setType(String type) {
		this.Type = type;
	}
	/**
	 * @return
	 */
	public String getVIP() {
		return VIP;
	}
	/**
	 * @param vip
	 */
	public void setVIP(String vip) {
		this.VIP = vip;
	}
	/**
	 * @return
	 */
	public String getWanted() {
		return Wanted;
	}
	/**
	 * @param wanted
	 */
	public void setWanted(String wanted) {
		this.Wanted = wanted;
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
	
}	
	