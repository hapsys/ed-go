package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class CommanderBean extends AbstractEventBean {

	/**
	 * 
	 */
	private Date timestamp;
	private String event;
	private String Name;
	

	/**
	 * @return
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param commander
	 */
	public void setName(String name) {
		Name = name;
	}

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

}
