package org.c3s.edgo.event.impl.beans;

public class EngineerCraftBean {
	/**
	 *  name of engineer
	 */
	private String Engineer;
	/**
	 *  name of blueprint
	 */
	private String Blueprint;
	/**
	 *  crafting level
	 */
	private String Level;
	/**
	 *  JSON object with names and quantities of materials required
	 */
	private String Ingredients;
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
	public String getLevel() {
		return Level;
	}
	/**
	 * @param level
	 */
	public void setLevel(String level) {
		this.Level = level;
	}
	/**
	 * @return
	 */
	public String getIngredients() {
		return Ingredients;
	}
	/**
	 * @param ingredients
	 */
	public void setIngredients(String ingredients) {
		this.Ingredients = ingredients;
	}
	
}	
	