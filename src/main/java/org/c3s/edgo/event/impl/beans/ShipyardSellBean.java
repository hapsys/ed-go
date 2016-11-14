package org.c3s.edgo.event.impl.beans;

public class ShipyardSellBean {
	/**
	 *  type of ship being sold
	 */
	private String ShipType;
	/**
	 * 
	 */
	private String SellShipID;
	/**
	 *  sale price
	 */
	private String ShipPrice;
	/**
	 *  (if ship is in another system) name of system
	 */
	private String System;
	/**
	 * @return
	 */
	public String getShipType() {
		return ShipType;
	}
	/**
	 * @param shiptype
	 */
	public void setShipType(String shiptype) {
		this.ShipType = shiptype;
	}
	/**
	 * @return
	 */
	public String getSellShipID() {
		return SellShipID;
	}
	/**
	 * @param sellshipid
	 */
	public void setSellShipID(String sellshipid) {
		this.SellShipID = sellshipid;
	}
	/**
	 * @return
	 */
	public String getShipPrice() {
		return ShipPrice;
	}
	/**
	 * @param shipprice
	 */
	public void setShipPrice(String shipprice) {
		this.ShipPrice = shipprice;
	}
	/**
	 * @return
	 */
	public String getSystem() {
		return System;
	}
	/**
	 * @param system
	 */
	public void setSystem(String system) {
		this.System = system;
	}
	
}	
	