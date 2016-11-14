package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ships database table.
 * 
 */
@Entity
@Table(name="ships")
@NamedQuery(name="Ship.findAll", query="SELECT s FROM Ship s")
public class Ship implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ship_id", updatable=false)
	private int id;

	@Column(name="ship_name")
	private String name;

	@Column(name="ship_uniq", updatable=false)
	private String uniq;

	//uni-directional many-to-many association to Slot
	@ManyToMany
	@JoinTable(
		name="ship_slots"
		, joinColumns={
			@JoinColumn(name="ship_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="slot_id")
			}
		)
	private List<Slot> slots;

	//bi-directional many-to-one association to ShipSlot
	@OneToMany(mappedBy="ship")
	private List<ShipSlot> shipSlots;

	public Ship() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUniq() {
		return this.uniq;
	}

	public void setUniq(String uniq) {
		this.uniq = uniq;
	}

	public List<Slot> getSlots() {
		return this.slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	public List<ShipSlot> getShipSlots() {
		return this.shipSlots;
	}

	public void setShipSlots(List<ShipSlot> shipSlots) {
		this.shipSlots = shipSlots;
	}

	public ShipSlot addShipSlot(ShipSlot shipSlot) {
		getShipSlots().add(shipSlot);
		shipSlot.setShip(this);

		return shipSlot;
	}

	public ShipSlot removeShipSlot(ShipSlot shipSlot) {
		getShipSlots().remove(shipSlot);
		shipSlot.setShip(null);

		return shipSlot;
	}

}