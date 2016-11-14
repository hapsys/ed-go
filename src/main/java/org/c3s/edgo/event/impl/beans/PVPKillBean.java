package org.c3s.edgo.event.impl.beans;

public class PVPKillBean {
	/**
	 *  name of victim
	 */
	private String Victim;
	/**
	 *  victim’s rank in range 0..8
	 */
	private String CombatRank;
	/**
	 * @return
	 */
	public String getVictim() {
		return Victim;
	}
	/**
	 * @param victim
	 */
	public void setVictim(String victim) {
		this.Victim = victim;
	}
	/**
	 * @return
	 */
	public String getCombatRank() {
		return CombatRank;
	}
	/**
	 * @param combatrank
	 */
	public void setCombatRank(String combatrank) {
		this.CombatRank = combatrank;
	}
	
}	
	