package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class RankBean {

	private Date timestamp;
	private String event;
	/**
	 *  rank on scale 0-8
	 */
	private String Combat;
	/**
	 *  rank on scale 0-8
	 */
	private String Trade;
	/**
	 *  rank on scale 0-8
	 */
	private String Explore;
	/**
	 *  military rank
	 */
	private String Empire;
	/**
	 *  military rank
	 */
	private String Federation;
	/**
	 *  rank on scale 0-8
	 */
	private String CQC;
	
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
	public String getCombat() {
		return Combat;
	}
	/**
	 * @param combat
	 */
	public void setCombat(String combat) {
		this.Combat = combat;
	}
	/**
	 * @return
	 */
	public String getTrade() {
		return Trade;
	}
	/**
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.Trade = trade;
	}
	/**
	 * @return
	 */
	public String getExplore() {
		return Explore;
	}
	/**
	 * @param explore
	 */
	public void setExplore(String explore) {
		this.Explore = explore;
	}
	/**
	 * @return
	 */
	public String getEmpire() {
		return Empire;
	}
	/**
	 * @param empire
	 */
	public void setEmpire(String empire) {
		this.Empire = empire;
	}
	/**
	 * @return
	 */
	public String getFederation() {
		return Federation;
	}
	/**
	 * @param federation
	 */
	public void setFederation(String federation) {
		this.Federation = federation;
	}
	/**
	 * @return
	 */
	public String getCQC() {
		return CQC;
	}
	/**
	 * @param cqc
	 */
	public void setCQC(String cqc) {
		this.CQC = cqc;
	}
	
}	
	