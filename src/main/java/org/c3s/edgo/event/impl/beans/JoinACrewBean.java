package org.c3s.edgo.event.impl.beans;

import java.util.Date;
import org.c3s.edgo.event.AbstractEventBean;

public class JoinACrewBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 *  Helm player's commander name
	 */
	private String Captain;
	
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
	public String getCaptain() {
		return Captain;
	}
	/**
	 * @param captain
	 */
	public void setCaptain(String captain) {
		this.Captain = captain;
	}
	
}	
	