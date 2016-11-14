package org.c3s.edgo.event.impl.beans;

public class ModuleStoreBean {
	/**
	 * 
	 */
	private String Slot;
	/**
	 * 
	 */
	private String Ship;
	/**
	 * 
	 */
	private String ShipID;
	/**
	 * 
	 */
	private String StoredItem;
	/**
	 *  name of modification blueprint, if any
	 */
	private String EngineerModifications;
	/**
	 *  (if a core module)
	 */
	private String ReplacementItem;
	/**
	 *  (if any)
	 */
	private String Cost;
	/**
	 * @return
	 */
	public String getSlot() {
		return Slot;
	}
	/**
	 * @param slot
	 */
	public void setSlot(String slot) {
		this.Slot = slot;
	}
	/**
	 * @return
	 */
	public String getShip() {
		return Ship;
	}
	/**
	 * @param ship
	 */
	public void setShip(String ship) {
		this.Ship = ship;
	}
	/**
	 * @return
	 */
	public String getShipID() {
		return ShipID;
	}
	/**
	 * @param shipid
	 */
	public void setShipID(String shipid) {
		this.ShipID = shipid;
	}
	/**
	 * @return
	 */
	public String getStoredItem() {
		return StoredItem;
	}
	/**
	 * @param storeditem
	 */
	public void setStoredItem(String storeditem) {
		this.StoredItem = storeditem;
	}
	/**
	 * @return
	 */
	public String getEngineerModifications() {
		return EngineerModifications;
	}
	/**
	 * @param engineermodifications
	 */
	public void setEngineerModifications(String engineermodifications) {
		this.EngineerModifications = engineermodifications;
	}
	/**
	 * @return
	 */
	public String getReplacementItem() {
		return ReplacementItem;
	}
	/**
	 * @param replacementitem
	 */
	public void setReplacementItem(String replacementitem) {
		this.ReplacementItem = replacementitem;
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
	