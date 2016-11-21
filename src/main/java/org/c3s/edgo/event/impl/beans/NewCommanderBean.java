package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class NewCommanderBean {

	private Date timestamp;
	private String event;
	/**
	 *  (new) commander name
	 */
	private String Name;
	/**
	 *  selected starter package
	 */
	private String Package;
	
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
	public String getPackage() {
		return Package;
	}
	/**
	 * @param package
	 */
	public void setPackage(String _package) {
		this.Package = _package;
	}
	
}	
	