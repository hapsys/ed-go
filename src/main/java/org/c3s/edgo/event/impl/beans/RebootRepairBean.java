package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class RebootRepairBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * JSON array of names of modules repaired
	 */
	private String Modules;

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
	public String getModules() {
		return Modules;
	}

	/**
	 * @param modules
	 */
	public void setModules(String modules) {
		this.Modules = modules;
	}

}
