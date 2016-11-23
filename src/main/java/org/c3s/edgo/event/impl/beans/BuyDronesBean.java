package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class BuyDronesBean extends AbstractEventBean {

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
	private String BuyPrice;
	/**
	 * 
	 */
	private String TotalCost;

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
