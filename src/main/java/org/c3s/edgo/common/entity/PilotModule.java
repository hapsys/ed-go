package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pilot_modules database table.
 * 
 */
@Entity
@Table(name="pilot_modules")
@NamedQueries({
	@NamedQuery(name="PilotModule.findAll", query="SELECT p FROM PilotModule p"),
	@NamedQuery(name="PilotModule.findByPilotShipAndSlot", query="SELECT p FROM PilotModule p WHERE p.pilotShip = :pilotShip and p.slot = :slot"),
})
public class PilotModule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pilot_module_id")
	private int pilotModuleId;

	//bi-directional many-to-one association to ModuleRecipy
	@OneToMany(mappedBy="pilotModule")
	private List<ModuleRecipy> moduleRecipies;

	//bi-directional many-to-one association to Module
	@ManyToOne
	@JoinColumn(name="module_id")
	private Module module;

	//bi-directional many-to-one association to PilotShip
	@ManyToOne
	@JoinColumn(name="pilot_ship_id")
	private PilotShip pilotShip;

	//bi-directional many-to-one association to Slot
	@ManyToOne
	@JoinColumn(name="slot_id")
	private Slot slot;

	public PilotModule() {
	}

	public int getPilotModuleId() {
		return this.pilotModuleId;
	}

	public void setPilotModuleId(int pilotModuleId) {
		this.pilotModuleId = pilotModuleId;
	}

	public List<ModuleRecipy> getModuleRecipies() {
		return this.moduleRecipies;
	}

	public void setModuleRecipies(List<ModuleRecipy> moduleRecipies) {
		this.moduleRecipies = moduleRecipies;
	}

	public ModuleRecipy addModuleRecipy(ModuleRecipy moduleRecipy) {
		getModuleRecipies().add(moduleRecipy);
		moduleRecipy.setPilotModule(this);

		return moduleRecipy;
	}

	public ModuleRecipy removeModuleRecipy(ModuleRecipy moduleRecipy) {
		getModuleRecipies().remove(moduleRecipy);
		moduleRecipy.setPilotModule(null);

		return moduleRecipy;
	}

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
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

}