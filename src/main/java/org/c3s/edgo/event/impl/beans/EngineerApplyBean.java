package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class EngineerApplyBean {

	private Date timestamp;
	private String event;
	/**
	 *  name of engineer
	 */
	private String Engineer;
	/**
	 *  blueprint being applied
	 */
	private String Blueprint;
	/**
	 *  crafting level
	 */
	private String Level;
	/**
	 *  whether overriding special effect
	 */
	private String Override;
	
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
	public String getEngineer() {
		return Engineer;
	}
	/**
	 * @param engineer
	 */
	public void setEngineer(String engineer) {
		this.Engineer = engineer;
	}
	/**
	 * @return
	 */
	public String getBlueprint() {
		return Blueprint;
	}
	/**
	 * @param blueprint
	 */
	public void setBlueprint(String blueprint) {
		this.Blueprint = blueprint;
	}
	/**
	 * @return
	 */
	public String getLevel() {
		return Level;
	}
	/**
	 * @param level
	 */
	public void setLevel(String level) {
		this.Level = level;
	}
	/**
	 * @return
	 */
	public String getOverride() {
		return Override;
	}
	/**
	 * @param override
	 */
	public void setOverride(String override) {
		this.Override = override;
	}
	
}	
	