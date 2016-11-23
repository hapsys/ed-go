package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class MaterialDiscardedBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String Category;
	/**
	 * 
	 */
	private String Name;
	/**
	 * 
	 */
	private String Count;

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
	public String getCategory() {
		return Category;
	}

	/**
	 * @param category
	 */
	public void setCategory(String category) {
		this.Category = category;
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
	public String getCount() {
		return Count;
	}

	/**
	 * @param count
	 */
	public void setCount(String count) {
		this.Count = count;
	}

}
