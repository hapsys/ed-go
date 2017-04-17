package org.c3s.edgo.event.impl.beans;

import java.util.Date;
import org.c3s.edgo.event.AbstractEventBean;

public class CrewLaunchFighterBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 *  name of crew member launching in fighter
	 */
	private String Crew;
	
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
	
}	
	