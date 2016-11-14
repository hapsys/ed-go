package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the slot_types database table.
 * 
 */
@Entity
@Table(name="slot_types")
@NamedQueries({
	@NamedQuery(name="SlotType.findAll", query="SELECT s FROM SlotType s"),
	@NamedQuery(name="SlotType.findById", query="SELECT s FROM SlotType s WHERE s.id=:id")
})
public class SlotType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="slot_type_id", updatable=false)
	private int id;

	@Column(name="slot_type_name")
	private String name;

	//bi-directional many-to-one association to Slot
	@OneToMany(mappedBy="slotType")
	private List<Slot> slots;

	public SlotType() {
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

	public List<Slot> getSlots() {
		return this.slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	public Slot addSlot(Slot slot) {
		getSlots().add(slot);
		slot.setSlotType(this);

		return slot;
	}

	public Slot removeSlot(Slot slot) {
		getSlots().remove(slot);
		slot.setSlotType(null);

		return slot;
	}

}