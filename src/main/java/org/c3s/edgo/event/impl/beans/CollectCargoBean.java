package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class CollectCargoBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * cargo type
	 */
	private String Type;
	/**
	 * whether stolen goods
	 */
	private String Stolen;

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
	public String getType() {
		return Type;
	}

	/**
	 * @param type
	 */
	public void setType(String type) {
		this.Type = type;
	}

	/**
	 * @return
	 */
	public String getStolen() {
		return Stolen;
	}

	/**
	 * @param stolen
	 */
	public void setStolen(String stolen) {
		this.Stolen = stolen;
	}

}
