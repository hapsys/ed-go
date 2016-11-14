package org.c3s.edgo.event.impl.beans;

public class MarketSellBean {
	/**
	 *  cargo type
	 */
	private String Type;
	/**
	 *  number of units
	 */
	private String Count;
	/**
	 *  price per unit
	 */
	private String SellPrice;
	/**
	 *  total sale value
	 */
	private String TotalSale;
	/**
	 *  average price paid
	 */
	private String AvgPricePaid;
	/**
	 *  (not always present) whether goods are illegal here
	 */
	private String IllegalGoods;
	/**
	 *  (not always present) whether goods were stolen
	 */
	private String StolenGoods;
	/**
	 *  (not always present) whether selling in a black market
	 */
	private String BlackMarket;
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
	public String getSellPrice() {
		return SellPrice;
	}
	/**
	 * @param sellprice
	 */
	public void setSellPrice(String sellprice) {
		this.SellPrice = sellprice;
	}
	/**
	 * @return
	 */
	public String getTotalSale() {
		return TotalSale;
	}
	/**
	 * @param totalsale
	 */
	public void setTotalSale(String totalsale) {
		this.TotalSale = totalsale;
	}
	/**
	 * @return
	 */
	public String getAvgPricePaid() {
		return AvgPricePaid;
	}
	/**
	 * @param avgpricepaid
	 */
	public void setAvgPricePaid(String avgpricepaid) {
		this.AvgPricePaid = avgpricepaid;
	}
	/**
	 * @return
	 */
	public String getIllegalGoods() {
		return IllegalGoods;
	}
	/**
	 * @param illegalgoods
	 */
	public void setIllegalGoods(String illegalgoods) {
		this.IllegalGoods = illegalgoods;
	}
	/**
	 * @return
	 */
	public String getStolenGoods() {
		return StolenGoods;
	}
	/**
	 * @param stolengoods
	 */
	public void setStolenGoods(String stolengoods) {
		this.StolenGoods = stolengoods;
	}
	/**
	 * @return
	 */
	public String getBlackMarket() {
		return BlackMarket;
	}
	/**
	 * @param blackmarket
	 */
	public void setBlackMarket(String blackmarket) {
		this.BlackMarket = blackmarket;
	}
	
}	
	