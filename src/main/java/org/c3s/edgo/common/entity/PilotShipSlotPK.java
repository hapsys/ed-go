package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pilot_ship_slots database table.
 * 
 */
@Embeddable
public class PilotShipSlotPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pilot_ship_id", insertable=false, updatable=false)
	private int pilotShipId;

	@Column(name="slot_id", insertable=false, updatable=false)
	private int slotId;

	public PilotShipSlotPK() {
	}
	public int getPilotShipId() {
		return this.pilotShipId;
	}
	public void setPilotShipId(int pilotShipId) {
		this.pilotShipId = pilotShipId;
	}
	public int getSlotId() {
		return this.slotId;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PilotShipSlotPK)) {
			return false;
		}
		PilotShipSlotPK castOther = (PilotShipSlotPK)other;
		return 
			(this.pilotShipId == castOther.pilotShipId)
			&& (this.slotId == castOther.slotId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pilotShipId;
		hash = hash * prime + this.slotId;
		
		return hash;
	}
}