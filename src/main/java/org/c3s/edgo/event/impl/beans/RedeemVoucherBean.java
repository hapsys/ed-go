package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;
import org.c3s.edgo.event.impl.beans.intl.FactionAmount;

public class RedeemVoucherBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String Type;
	/**
	 * (Net amount received, after any broker fee)
	 */
	private long Amount;
	/**
	 * (if redeemed through a broker)
	 */
	private int BrokerPercenentage;
	/**
	 * 
	 */
	private String Faction;
	
	/**
	 * 
	 */
	private FactionAmount[] Factions;
	
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
	public long getAmount() {
		return Amount;
	}

	/**
	 * @param amount
	 */
	public void setAmount(long amount) {
		this.Amount = amount;
	}

	/**
	 * @return
	 */
	public int getBrokerPercenentage() {
		return BrokerPercenentage;
	}

	/**
	 * @param brokerpercenentage
	 */
	public void setBrokerPercenentage(int brokerpercenentage) {
		this.BrokerPercenentage = brokerpercenentage;
	}

	public String getFaction() {
		return Faction;
	}

	public void setFaction(String faction) {
		Faction = faction;
	}

	public FactionAmount[] getFactions() {
		return Factions;
	}

	public void setFactions(FactionAmount[] factions) {
		Factions = factions;
	}
	
}
