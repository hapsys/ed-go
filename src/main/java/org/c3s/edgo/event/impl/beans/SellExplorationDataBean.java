package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class SellExplorationDataBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * JSON array of system names
	 */
	private String[] Systems;
	/**
	 * JSON array of discovered bodies
	 */
	private String[] Discovered;
	/**
	 * value of systems
	 */
	private String BaseValue;
	/**
	 * bonus for first discoveries
	 */
	private String Bonus;

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
	public String[] getSystems() {
		return Systems;
	}

	/**
	 * @param systems
	 */
	public void setSystems(String[] systems) {
		this.Systems = systems;
	}

	/**
	 * @return
	 */
	public String[] getDiscovered() {
		return Discovered;
	}

	/**
	 * @param discovered
	 */
	public void setDiscovered(String[] discovered) {
		this.Discovered = discovered;
	}

	/**
	 * @return
	 */
	public String getBaseValue() {
		return BaseValue;
	}

	/**
	 * @param basevalue
	 */
	public void setBaseValue(String basevalue) {
		this.BaseValue = basevalue;
	}

	/**
	 * @return
	 */
	public String getBonus() {
		return Bonus;
	}

	/**
	 * @param bonus
	 */
	public void setBonus(String bonus) {
		this.Bonus = bonus;
	}

}
