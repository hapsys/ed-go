package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the factions database table.
 * 
 */
@Entity
@Table(name="factions")
@NamedQuery(name="Faction.findAll", query="SELECT f FROM Faction f")
public class Faction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="faction_id")
	private int factionId;

	private String allegiance;

	@Column(name="allegiance_id")
	private int allegianceId;

	private String government;

	@Column(name="government_id")
	private int governmentId;

	@Column(name="home_system_id")
	private int homeSystemId;

	@Column(name="is_player_faction")
	private byte isPlayerFaction;

	private String name;

	private String state;

	@Column(name="state_id")
	private int stateId;

	private String uniq;

	@Column(name="updated_at")
	private int updatedAt;

	public Faction() {
	}

	public int getFactionId() {
		return this.factionId;
	}

	public void setFactionId(int factionId) {
		this.factionId = factionId;
	}

	public String getAllegiance() {
		return this.allegiance;
	}

	public void setAllegiance(String allegiance) {
		this.allegiance = allegiance;
	}

	public int getAllegianceId() {
		return this.allegianceId;
	}

	public void setAllegianceId(int allegianceId) {
		this.allegianceId = allegianceId;
	}

	public String getGovernment() {
		return this.government;
	}

	public void setGovernment(String government) {
		this.government = government;
	}

	public int getGovernmentId() {
		return this.governmentId;
	}

	public void setGovernmentId(int governmentId) {
		this.governmentId = governmentId;
	}

	public int getHomeSystemId() {
		return this.homeSystemId;
	}

	public void setHomeSystemId(int homeSystemId) {
		this.homeSystemId = homeSystemId;
	}

	public byte getIsPlayerFaction() {
		return this.isPlayerFaction;
	}

	public void setIsPlayerFaction(byte isPlayerFaction) {
		this.isPlayerFaction = isPlayerFaction;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getStateId() {
		return this.stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getUniq() {
		return this.uniq;
	}

	public void setUniq(String uniq) {
		this.uniq = uniq;
	}

	public int getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(int updatedAt) {
		this.updatedAt = updatedAt;
	}

}