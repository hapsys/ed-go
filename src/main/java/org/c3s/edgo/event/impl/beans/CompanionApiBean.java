package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.companion.CompanionBean;
import org.c3s.edgo.event.AbstractEventBean;

public class CompanionApiBean extends AbstractEventBean {
	
	private Date timestamp;
	private String event;

	/**
	 * 
	 */
	private CompanionBean CompanionData;
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

	public CompanionBean getCompanionData() {
		return CompanionData;
	}

	public void setCompanionData(CompanionBean companionData) {
		CompanionData = companionData;
	}
	
}
