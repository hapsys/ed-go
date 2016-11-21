package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the system_factions database table.
 * 
 */
@Embeddable
public class SystemFactionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="system_id")
	private String systemId;

	@Column(name="faction_id")
	private int factionId;

	public SystemFactionPK() {
	}
	public String getSystemId() {
		return this.systemId;
	}
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public int getFactionId() {
		return this.factionId;
	}
	public void setFactionId(int factionId) {
		this.factionId = factionId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SystemFactionPK)) {
			return false;
		}
		SystemFactionPK castOther = (SystemFactionPK)other;
		return 
			this.systemId.equals(castOther.systemId)
			&& (this.factionId == castOther.factionId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.systemId.hashCode();
		hash = hash * prime + this.factionId;
		
		return hash;
	}
}