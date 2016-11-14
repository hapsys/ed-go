package org.c3s.edgo.event.impl.beans;

public class MarketBuyBean {
	/**
	 *  cargo type
	 */
	private String Type;
	/**
	 *  number of units
	 */
	private String Count;
	/**
	 *  cost per unit
	 */
	private String BuyPrice;
	/**
	 *  total cost
	 */
	private String TotalCost;
	/**
	 * @return
	 */
	public String getType() {
		return Type;
	}
	/**
	 * @param type
	 */
	public void setType(String type) {
		this.Type = type;
	}
	/**
	 * @return
	 */
	public String getCount() {
		return Count;
	}
	/**
	 * @param count
	 */
	public void setCount(String count) {
		this.Count = count;
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
	public String getTotalCost() {
		return TotalCost;
	}
	/**
	 * @param totalcost
	 */
	public void setTotalCost(String totalcost) {
		this.TotalCost = totalcost;
	}
	
}	
	