package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class SendTextBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String To;
	/**
	 * 
	 */
	private String Message;

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
	public String getTo() {
		return To;
	}

	/**
	 * @param to
	 */
	public void setTo(String to) {
		this.To = to;
	}

	/**
	 * @return
	 */
	public String getMessage() {
		return Message;
	}

	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.Message = message;
	}

}
