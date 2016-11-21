package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class SupercruiseExitBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String Starsystem;
	/**
	 * 
	 */
	private String Body;
	/**
	 * 
	 */
	private String BodyType;
	
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
	public String getStarsystem() {
		return Starsystem;
	}
	/**
	 * @param starsystem
	 */
	public void setStarsystem(String starsystem) {
		this.Starsystem = starsystem;
	}
	/**
	 * @return
	 */
	public String getBody() {
		return Body;
	}
	/**
	 * @param body
	 */
	public void setBody(String body) {
		this.Body = body;
	}
	/**
	 * @return
	 */
	public String getBodyType() {
		return BodyType;
	}
	/**
	 * @param bodytype
	 */
	public void setBodyType(String bodytype) {
		this.BodyType = bodytype;
	}
	
}	
	