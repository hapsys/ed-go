package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ship_slots database table.
 * 
 */
@Entity
@Table(name="ship_slots")
@NamedQuery(name="ShipSlot.findAll", query="SELECT s FROM ShipSlot s")
public class ShipSlot implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ShipSlotPK id;

	//bi-directional many-to-one association to Module
	@ManyToOne
	@JoinColumn(name="module_id")
	private Module module;

	//bi-directional many-to-one association to Ship
	@ManyToOne
	@JoinColumn(name="ship_id", insertable=false, updatable=false)
	private Ship ship;

	//bi-directional many-to-one association to Slot
	@ManyToOne
	@JoinColumn(name="slot_id", insertable=false, updatable=false)
	private Slot slot;

	public ShipSlot() {
	}

	public ShipSlotPK getId() {
		return this.id;
	}

	public void setId(ShipSlotPK id) {
		this.id = id;
	}

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Ship getShip() {
		return this.ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public Slot getSlot() {
		return this.slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

}