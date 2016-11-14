package org.c3s.edgo.event.impl.beans;

public class LoadGameBean {

	/**
	 * 
	 */
	String Commander;
	String Ship;
	int ShipID;
	String GameMode;
	String Group;
	int Credits;
	int Loan;
	
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
	
}
