package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class JetConeDamageBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * the name of the module that has taken some damage
	 */
	private String Module;

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
	public String getModule() {
		return Module;
	}

	/**
	 * @param module
	 */
	public void setModule(String module) {
		this.Module = module;
	}

}
