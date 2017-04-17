package org.c3s.edgo.event.impl.beans;

import java.util.Date;
import org.c3s.edgo.event.AbstractEventBean;

public class KickCrewMemberBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 *  player's commander name
	 */
	private String Crew;
	/**
	 *  (bool) true if player is automatically kicked for committing a crime in a lawful session
	 */
	private String OnCrime;
	
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
	public String getOnCrime() {
		return OnCrime;
	}
	/**
	 * @param oncrime
	 */
	public void setOnCrime(String oncrime) {
		this.OnCrime = oncrime;
	}
	
}	
	