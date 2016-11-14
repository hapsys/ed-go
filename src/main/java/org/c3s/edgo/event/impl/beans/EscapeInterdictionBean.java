package org.c3s.edgo.event.impl.beans;

public class EscapeInterdictionBean {
	/**
	 *  interdicting pilot name
	 */
	private String Interdictor;
	/**
	 *  whether player or npc
	 */
	private String IsPlayer;
	/**
	 * @return
	 */
	public String getInterdictor() {
		return Interdictor;
	}
	/**
	 * @param interdictor
	 */
	public void setInterdictor(String interdictor) {
		this.Interdictor = interdictor;
	}
	/**
	 * @return
	 */
	public String getIsPlayer() {
		return IsPlayer;
	}
	/**
	 * @param isplayer
	 */
	public void setIsPlayer(String isplayer) {
		this.IsPlayer = isplayer;
	}
	
}	
	