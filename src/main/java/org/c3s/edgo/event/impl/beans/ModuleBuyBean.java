package org.c3s.edgo.event.impl.beans;

public class ModuleBuyBean {
	/**
	 *  the outfitting slot
	 */
	private String Slot;
	/**
	 *  the module being purchased
	 */
	private String BuyItem;
	/**
	 *  price paid
	 */
	private String BuyPrice;
	/**
	 *  the players ship
	 */
	private String Ship;
	/**
	 * 
	 */
	private String ShipID;
	/**
	 *  an existing module:
	 */
	private String replacing;
	/**
	 *  item being sold
	 */
	private String SellItem;
	/**
	 *  sale price
	 */
	private String SellPrice;
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
	public String getBuyItem() {
		return BuyItem;
	}
	/**
	 * @param buyitem
	 */
	public void setBuyItem(String buyitem) {
		this.BuyItem = buyitem;
	}
	/**
	 * @return
	 */
	public String getBuyPrice() {
		return BuyPrice;
	}
	/**
	 * @param buyprice
	 */
	public void setBuyPrice(String buyprice) {
		this.BuyPrice = buyprice;
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
	public String getreplacing() {
		return replacing;
	}
	/**
	 * @param replacing
	 */
	public void setreplacing(String replacing) {
		this.replacing = replacing;
	}
	/**
	 * @return
	 */
	public String getSellItem() {
		return SellItem;
	}
	/**
	 * @param sellitem
	 */
	public void setSellItem(String sellitem) {
		this.SellItem = sellitem;
	}
	/**
	 * @return
	 */
	public String getSellPrice() {
		return SellPrice;
	}
	/**
	 * @param sellprice
	 */
	public void setSellPrice(String sellprice) {
		this.SellPrice = sellprice;
	}
	
}	
	