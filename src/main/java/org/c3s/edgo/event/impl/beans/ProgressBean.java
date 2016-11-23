package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class ProgressBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * percent progress to next rank
	 */
	private int Combat;
	/**
	 * "
	 */
	private int Trade;
	/**
	 * "
	 */
	private int Explore;
	/**
	 * "
	 */
	private int Empire;
	/**
	 * "
	 */
	private int Federation;
	/**
	 * "
	 */
	private int CQC;

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
	public int getCombat() {
		return Combat;
	}

	/**
	 * @param combat
	 */
	public void setCombat(int combat) {
		this.Combat = combat;
	}

	/**
	 * @return
	 */
	public int getTrade() {
		return Trade;
	}

	/**
	 * @param trade
	 */
	public void setTrade(int trade) {
		this.Trade = trade;
	}

	/**
	 * @return
	 */
	public int getExplore() {
		return Explore;
	}

	/**
	 * @param explore
	 */
	public void setExplore(int explore) {
		this.Explore = explore;
	}

	/**
	 * @return
	 */
	public int getEmpire() {
		return Empire;
	}

	/**
	 * @param empire
	 */
	public void setEmpire(int empire) {
		this.Empire = empire;
	}

	/**
	 * @return
	 */
	public int getFederation() {
		return Federation;
	}

	/**
	 * @param federation
	 */
	public void setFederation(int federation) {
		this.Federation = federation;
	}

	/**
	 * @return
	 */
	public int getCQC() {
		return CQC;
	}

	/**
	 * @param cqc
	 */
	public void setCQC(int cqc) {
		this.CQC = cqc;
	}

}
