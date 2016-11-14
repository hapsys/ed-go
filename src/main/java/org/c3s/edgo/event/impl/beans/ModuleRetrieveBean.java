package org.c3s.edgo.event.impl.beans;

public class ModuleRetrieveBean {
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
	private String RetrievedItem;
	/**
	 *  name of modification blueprint, if any
	 */
	private String EngineerModifications;
	/**
	 *  (if slot was not empty)
	 */
	private String SwapOutItem;
	/**
	 * 
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
	public String getRetrievedItem() {
		return RetrievedItem;
	}
	/**
	 * @param retrieveditem
	 */
	public void setRetrievedItem(String retrieveditem) {
		this.RetrievedItem = retrieveditem;
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
	public String getSwapOutItem() {
		return SwapOutItem;
	}
	/**
	 * @param swapoutitem
	 */
	public void setSwapOutItem(String swapoutitem) {
		this.SwapOutItem = swapoutitem;
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
	