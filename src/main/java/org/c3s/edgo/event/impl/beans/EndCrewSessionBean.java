package org.c3s.edgo.event.impl.beans;

import java.util.Date;
import org.c3s.edgo.event.AbstractEventBean;

public class EndCrewSessionBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 *  (bool) true if crew disbanded as a result of a crime in a lawful session
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
	