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
@NamedQuery(name="Slot.findAll", query="SELECT s FROM Slot s")
public class Slot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="slot_id")
	private int id;

	private int size;

	@Column(name="slot_uniq")
	private String uniq;

	//uni-directional many-to-many association to Ship
	@ManyToMany
	@JoinTable(
		name="ship_slots"
		, joinColumns={
			@JoinColumn(name="slot_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ship_id")
			}
		)
	private List<Ship> ships;

	//bi-directional many-to-one association to SlotType
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

	public List<Ship> getShips() {
		return this.ships;
	}

	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}

	public SlotType getSlotType() {
		return this.slotType;
	}

	public void setSlotType(SlotType slotType) {
		this.slotType = slotType;
	}

}