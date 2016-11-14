package org.c3s.edgo.event.impl.beans;

public class RepairBean {
	/**
	 *  all, wear, hull, paint, or name of module
	 */
	private String Item;
	/**
	 *  cost of repair
	 */
	private String Cost;
	/**
	 * @return
	 */
	public String getItem() {
		return Item;
	}
	/**
	 * @param item
	 */
	public void setItem(String item) {
		this.Item = item;
	}
	/**
	 * @return
	 */
	public String getCost() {
		return Cost;
	}
	/**
	 * @param cost
	 */
	public void setCost(String cost) {
		this.Cost = cost;
	}
	
}	
	