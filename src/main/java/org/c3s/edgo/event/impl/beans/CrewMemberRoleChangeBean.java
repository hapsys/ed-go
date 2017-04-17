package org.c3s.edgo.event.impl.beans;

import java.util.Date;
import org.c3s.edgo.event.AbstractEventBean;

public class CrewMemberRoleChangeBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 *  player name
	 */
	private String Crew;
	/**
	 *  selected role
	 */
	private String Role;
	
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
	public String getCrew() {
		return Crew;
	}
	/**
	 * @param crew
	 */
	public void setCrew(String crew) {
		this.Crew = crew;
	}
	/**
	 * @return
	 */
	public String getRole() {
		return Role;
	}
	/**
	 * @param role
	 */
	public void setRole(String role) {
		this.Role = role;
	}
	
}	
	