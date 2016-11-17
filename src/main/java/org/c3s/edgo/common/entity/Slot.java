package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the slots database table.
 * 
 */
@Entity
@Table(name="slots")
@NamedQueries({
	@NamedQuery(name="Slot.findAll", query="SELECT s FROM Slot s"),
	@NamedQuery(name="Slot.findByUniq", query="SELECT s FROM Slot s WHERE LOWER(s.uniq) = LOWER(:uniq)"),
})

public class Slot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="slot_id")
	private int id;

	private int size;

	@Column(name="slot_uniq")
	private String uniq;

	//bi-directional many-to-one association to PilotModule
	@OneToMany(mappedBy="slot")
	private List<PilotModule> pilotModules;

	//bi-directional many-to-one association to ShipSlot
	@OneToMany(mappedBy="slot")
	private List<ShipSlot> shipSlots;

	//uni-directional many-to-one association to SlotType
	@ManyToOne
	@JoinColumn(name="slot_type_id")
	private SlotType slotType;

	public Slot() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getUniq() {
		return this.uniq;
	}

	public void setUniq(String uniq) {
		this.uniq = uniq;
	}

	public List<PilotModule> getPilotModules() {
		return this.pilotModules;
	}

	public void setPilotModules(List<PilotModule> pilotModules) {
		this.pilotModules = pilotModules;
	}

	public PilotModule addPilotModule(PilotModule pilotModule) {
		getPilotModules().add(pilotModule);
		pilotModule.setSlot(this);

		return pilotModule;
	}

	public PilotModule removePilotModule(PilotModule pilotModule) {
		getPilotModules().remove(pilotModule);
		pilotModule.setSlot(null);

		return pilotModule;
	}

	public List<ShipSlot> getShipSlots() {
		return this.shipSlots;
	}

	public void setShipSlots(List<ShipSlot> shipSlots) {
		this.shipSlots = shipSlots;
	}

	public ShipSlot addShipSlot(ShipSlot shipSlot) {
		getShipSlots().add(shipSlot);
		shipSlot.setSlot(this);

		return shipSlot;
	}

	public ShipSlot removeShipSlot(ShipSlot shipSlot) {
		getShipSlots().remove(shipSlot);
		shipSlot.setSlot(null);

		return shipSlot;
	}

	public SlotType getSlotType() {
		return this.slotType;
	}

	public void setSlotType(SlotType slotType) {
		this.slotType = slotType;
	}

}