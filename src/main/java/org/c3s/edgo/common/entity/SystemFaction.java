package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the system_factions database table.
 * 
 */
@Entity
@Table(name="system_factions")
@NamedQuery(name="SystemFaction.findAll", query="SELECT s FROM SystemFaction s")
public class SystemFaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SystemFactionPK id;

	private String influence;

	@Column(name="is_controlled")
	private byte isControlled;

	private String state;

	public SystemFaction() {
	}

	public SystemFactionPK getId() {
		return this.id;
	}

	public void setId(SystemFactionPK id) {
		this.id = id;
	}

	public String getInfluence() {
		return this.influence;
	}

	public void setInfluence(String influence) {
		this.influence = influence;
	}

	public byte getIsControlled() {
		return this.isControlled;
	}

	public void setIsControlled(byte isControlled) {
		this.isControlled = isControlled;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}