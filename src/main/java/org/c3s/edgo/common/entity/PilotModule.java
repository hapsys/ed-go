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
@NamedQuery(name="PilotModule.findAll", query="SELECT p FROM PilotModule p")
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

	//bi-directional many-to-one association to Pilot
	@ManyToOne
	@JoinColumn(name="pilot_id")
	private Pilot pilot;

	//bi-directional many-to-one association to PilotShipSlot
	@OneToMany(mappedBy="pilotModule")
	private List<PilotShipSlot> pilotShipSlots;

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

	public Pilot getPilot() {
		return this.pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public List<PilotShipSlot> getPilotShipSlots() {
		return this.pilotShipSlots;
	}

	public void setPilotShipSlots(List<PilotShipSlot> pilotShipSlots) {
		this.pilotShipSlots = pilotShipSlots;
	}

	public PilotShipSlot addPilotShipSlot(PilotShipSlot pilotShipSlot) {
		getPilotShipSlots().add(pilotShipSlot);
		pilotShipSlot.setPilotModule(this);

		return pilotShipSlot;
	}

	public PilotShipSlot removePilotShipSlot(PilotShipSlot pilotShipSlot) {
		getPilotShipSlots().remove(pilotShipSlot);
		pilotShipSlot.setPilotModule(null);

		return pilotShipSlot;
	}

}