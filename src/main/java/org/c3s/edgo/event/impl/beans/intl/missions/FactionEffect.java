package org.c3s.edgo.event.impl.beans.intl.missions;

public class FactionEffect {
	
	private String Faction;
	
	private Effect[] Effects;
	
	private MissionInfluence[] Influence; 
	
	private String Reputation;

	public String getFaction() {
		return Faction;
	}

	public void setFaction(String faction) {
		Faction = faction;
	}

	public Effect[] getEffects() {
		return Effects;
	}

	public void setEffects(Effect[] effects) {
		Effects = effects;
	}

	public MissionInfluence[] getInfluence() {
		return Influence;
	}

	public void setInfluence(MissionInfluence[] influence) {
		Influence = influence;
	}

	public String getReputation() {
		return Reputation;
	}

	public void setReputation(String reputation) {
		Reputation = reputation;
	}
	
	
}
