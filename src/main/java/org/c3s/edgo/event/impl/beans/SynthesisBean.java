package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class SynthesisBean {

	private Date timestamp;
	private String event;
	/**
	 *  synthesis blueprint
	 */
	private String Name;
	/**
	 *  JSON object listing materials used and quantities
	 */
	private String Materials;
	
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
	public String getMaterials() {
		return Materials;
	}
	/**
	 * @param materials
	 */
	public void setMaterials(String materials) {
		this.Materials = materials;
	}
	
}	
	