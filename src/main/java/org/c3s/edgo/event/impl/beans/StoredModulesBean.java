package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;
import org.c3s.edgo.event.impl.beans.intl.StoredModule;

public class StoredModulesBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	
	private StoredModule[] Items; 
	
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

	public StoredModule[] getItems() {
		return Items;
	}

	public void setItems(StoredModule[] items) {
		Items = items;
	}


}
