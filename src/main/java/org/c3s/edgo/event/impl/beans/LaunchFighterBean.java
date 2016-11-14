package org.c3s.edgo.event.impl.beans;

public class LaunchFighterBean {
	/**
	 * 
	 */
	private String Loadout;
	/**
	 *  whether player is controlling the fighter from launch
	 */
	private String PlayerControlled;
	/**
	 * @return
	 */
	public String getLoadout() {
		return Loadout;
	}
	/**
	 * @param loadout
	 */
	public void setLoadout(String loadout) {
		this.Loadout = loadout;
	}
	/**
	 * @return
	 */
	public String getPlayerControlled() {
		return PlayerControlled;
	}
	/**
	 * @param playercontrolled
	 */
	public void setPlayerControlled(String playercontrolled) {
		this.PlayerControlled = playercontrolled;
	}
	
}	
	