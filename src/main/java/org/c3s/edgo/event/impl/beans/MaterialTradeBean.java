package org.c3s.edgo.event.impl.beans;

import java.math.BigInteger;
import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;
import org.c3s.edgo.event.impl.beans.intl.MaterialTrade;

public class MaterialTradeBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	
	private BigInteger MarketID;
	
	private String TraderType;
	
	private MaterialTrade Paid;
	
	private MaterialTrade Received;
	
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

	public BigInteger getMarketID() {
		return MarketID;
	}

	public void setMarketID(BigInteger marketID) {
		MarketID = marketID;
	}

	public String getTraderType() {
		return TraderType;
	}

	public void setTraderType(String traderType) {
		TraderType = traderType;
	}

	public MaterialTrade getPaid() {
		return Paid;
	}

	public void setPaid(MaterialTrade paid) {
		Paid = paid;
	}

	public MaterialTrade getReceived() {
		return Received;
	}

	public void setReceived(MaterialTrade received) {
		Received = received;
	}

}
