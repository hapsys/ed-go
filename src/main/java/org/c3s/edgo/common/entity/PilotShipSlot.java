package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pilot_ship_slots database table.
 * 
 */
@Entity
@Table(name="pilot_ship_slots")
@NamedQuery(name="PilotShipSlot.findAll", query="SELECT p FROM PilotShipSlot p")
public class PilotShipSlot implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PilotShipSlotPK id;

	//bi-directional many-to-one association to PilotShip
	@ManyToOne
	@JoinColumn(name="pilot_ship_id", insertable=false, updatable=false)
	private PilotShip pilotShip;

	//bi-directional many-to-one association to Slot
	@ManyToOne
	@JoinColumn(name="slot_id", insertable=false, updatable=false)
	private Slot slot;

	//bi-directional many-to-one association to PilotModule
	@ManyToOne
	@JoinColumn(name="pilot_module_id")
	private PilotModule pilotModule;

	public PilotShipSlot() {
	}

	public PilotShipSlotPK getId() {
		return this.id;
	}

	public void setId(PilotShipSlotPK id) {
		this.id = id;
	}

	public PilotShip getPilotShip() {
		return this.pilotShip;
	}

	public void setPilotShip(PilotShip pilotShip) {
		this.pilotShip = pilotShip;
	}

	public Slot getSlot() {
		return this.slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public PilotModule getPilotModule() {
		return this.pilotModule;
	}

	public void setPilotModule(PilotModule pilotModule) {
		this.pilotModule = pilotModule;
	}

}