package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the modules database table.
 * 
 */
@Entity
@Table(name="modules")
@NamedQuery(name="Module.findAll", query="SELECT m FROM Module m")
public class Module implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="module_id")
	private int id;

	@Column(name="module_name")
	private String name;

	@Column(name="module_uniq")
	private String uniq;

	@Column(name="module_rating")
	private String rating; 
	
	@Column(name="module_class")
	private int clazz; 
	//uni-directional many-to-one association to ModuleGroup
	@ManyToOne
	@JoinColumn(name="module_group_id")
	private ModuleGroup moduleGroup;

	//bi-directional many-to-one association to ShipSlot
	@OneToMany(mappedBy="module")
	private List<ShipSlot> shipSlots;

	public Module() {
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

	public ModuleGroup getModuleGroup() {
		return this.moduleGroup;
	}

	public void setModuleGroup(ModuleGroup moduleGroup) {
		this.moduleGroup = moduleGroup;
	}

	public List<ShipSlot> getShipSlots() {
		return this.shipSlots;
	}

	public void setShipSlots(List<ShipSlot> shipSlots) {
		this.shipSlots = shipSlots;
	}

	public ShipSlot addShipSlot(ShipSlot shipSlot) {
		getShipSlots().add(shipSlot);
		shipSlot.setModule(this);

		return shipSlot;
	}

	public ShipSlot removeShipSlot(ShipSlot shipSlot) {
		getShipSlots().remove(shipSlot);
		shipSlot.setModule(null);

		return shipSlot;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getClazz() {
		return clazz;
	}

	public void setClazz(int clazz) {
		this.clazz = clazz;
	}
	
}