package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class SellDronesBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String Type;
	/**
	 * 
	 */
	private String Count;
	/**
	 * 
	 */
	private String SellPrice;
	/**
	 * 
	 */
	private String TotalSale;
	
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
	
}	
	