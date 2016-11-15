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
@NamedQueries({
	@NamedQuery(name="Module.findAll", query="SELECT m FROM Module m"),
	@NamedQuery(name="Module.findByUniq", query="SELECT m FROM Module m WHERE LOWER(m.uniq) = LOWER(:uniq)"),
})
public class Module implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="module_id")
	private int id;

	@Column(name="module_class")
	private byte moduleClass;

	@Column(name="module_name")
	private String name;

	@Column(name="module_rating")
	private String moduleRating;

	@Column(name="module_uniq")
	private String uniq;

	//uni-directional many-to-one association to ModuleGroup
	@ManyToOne
	@JoinColumn(name="module_group_id")
	private ModuleGroup moduleGroup;

	//bi-directional many-to-one association to PilotModule
	@OneToMany(mappedBy="module")
	private List<PilotModule> pilotModules;

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

	public byte getModuleClass() {
		return this.moduleClass;
	}

	public void setModuleClass(byte moduleClass) {
		this.moduleClass = moduleClass;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModuleRating() {
		return this.moduleRating;
	}

	public void setModuleRating(String moduleRating) {
		this.moduleRating = moduleRating;
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

	public List<PilotModule> getPilotModules() {
		return this.pilotModules;
	}

	public void setPilotModules(List<PilotModule> pilotModules) {
		this.pilotModules = pilotModules;
	}

	public PilotModule addPilotModule(PilotModule pilotModule) {
		getPilotModules().add(pilotModule);
		pilotModule.setModule(this);

		return pilotModule;
	}

	public PilotModule removePilotModule(PilotModule pilotModule) {
		getPilotModules().remove(pilotModule);
		pilotModule.setModule(null);

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
		shipSlot.setModule(this);

		return shipSlot;
	}

	public ShipSlot removeShipSlot(ShipSlot shipSlot) {
		getShipSlots().remove(shipSlot);
		shipSlot.setModule(null);

		return shipSlot;
	}

}