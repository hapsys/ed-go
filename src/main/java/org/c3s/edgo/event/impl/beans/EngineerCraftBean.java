package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;
import org.c3s.edgo.event.impl.beans.intl.NameCount;

public class EngineerCraftBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * name of engineer
	 */
	private String Engineer;
	/**
	 * name of blueprint
	 */
	private String Blueprint;
	/**
	 * crafting level
	 */
	private int Level;
	/**
	 * JSON object with names and quantities of materials required
	 */
	private NameCount[] Ingredients;

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
	public String getEngineer() {
		return Engineer;
	}

	/**
	 * @param engineer
	 */
	public void setEngineer(String engineer) {
		this.Engineer = engineer;
	}

	/**
	 * @return
	 */
	public String getBlueprint() {
		return Blueprint;
	}

	/**
	 * @param blueprint
	 */
	public void setBlueprint(String blueprint) {
		this.Blueprint = blueprint;
	}

	/**
	 * @return
	 */
	public int getLevel() {
		return Level;
	}

	/**
	 * @param level
	 */
	public void setLevel(int level) {
		this.Level = level;
	}

	public NameCount[] getIngredients() {
		return Ingredients;
	}

	public void setIngredients(NameCount[] ingredients) {
		Ingredients = ingredients;
	}

	
}
