package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class LoadGameBean extends AbstractEventBean {

	/**
	 * 
	 */
	private Date timestamp;
	private String event;
	private String Commander;
	private String Ship;
	private int ShipID;
	private String GameMode;
	private String Group;
	private int Credits;
	private int Loan;

	/**
	 * @return
	 */
	public String getCommander() {
		return Commander;
	}

	/**
	 * @param commander
	 */
	public void setCommander(String commander) {
		Commander = commander;
	}

	public String getShip() {
		return Ship;
	}

	public void setShip(String ship) {
		Ship = ship;
	}

	public int getShipID() {
		return ShipID;
	}

	public void setShipID(int shipID) {
		ShipID = shipID;
	}

	public String getGameMode() {
		return GameMode;
	}

	public void setGameMode(String gameMode) {
		GameMode = gameMode;
	}

	public String getGroup() {
		return Group;
	}

	public void setGroup(String group) {
		Group = group;
	}

	public int getCredits() {
		return Credits;
	}

	public void setCredits(int credits) {
		Credits = credits;
	}

	public int getLoan() {
		return Loan;
	}

	public void setLoan(int loan) {
		Loan = loan;
	}

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

}
