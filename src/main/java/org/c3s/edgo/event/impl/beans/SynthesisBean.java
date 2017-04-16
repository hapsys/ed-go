package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;
import org.c3s.edgo.event.impl.beans.intl.NameCount;

public class SynthesisBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * synthesis blueprint
	 */
	private String Name;
	/**
	 * JSON object listing materials used and quantities
	 */
	//private HashMap<String, Integer> Materials;
	private NameCount[] Materials;	

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

	public NameCount[] getMaterials() {
		return Materials;
	}

	public void setMaterials(NameCount[] materials) {
		Materials = materials;
	}
}
