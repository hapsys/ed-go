package org.c3s.edgo.event.impl.beans;

public class SellExplorationDataBean {
	/**
	 *  JSON array of system names
	 */
	private String Systems;
	/**
	 *  JSON array of discovered bodies
	 */
	private String Discovered;
	/**
	 *  value of systems
	 */
	private String BaseValue;
	/**
	 *  bonus for first discoveries
	 */
	private String Bonus;
	/**
	 * @return
	 */
	public String getSystems() {
		return Systems;
	}
	/**
	 * @param systems
	 */
	public void setSystems(String systems) {
		this.Systems = systems;
	}
	/**
	 * @return
	 */
	public String getDiscovered() {
		return Discovered;
	}
	/**
	 * @param discovered
	 */
	public void setDiscovered(String discovered) {
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
	