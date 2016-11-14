package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ship_slots database table.
 * 
 */
@Embeddable
public class ShipSlotPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ship_id", insertable=false, updatable=false)
	private int shipId;

	@Column(name="slot_id", insertable=false, updatable=false)
	private int slotId;

	public ShipSlotPK() {
	}
	public int getShipId() {
		return this.shipId;
	}
	public void setShipId(int shipId) {
		this.shipId = shipId;
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
		if (!(other instanceof ShipSlotPK)) {
			return false;
		}
		ShipSlotPK castOther = (ShipSlotPK)other;
		return 
			(this.shipId == castOther.shipId)
			&& (this.slotId == castOther.slotId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.shipId;
		hash = hash * prime + this.slotId;
		
		return hash;
	}
}