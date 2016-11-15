package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pilot_ships database table.
 * 
 */
@Entity
@Table(name="pilot_ships")
@NamedQuery(name="PilotShip.findAll", query="SELECT p FROM PilotShip p")
public class PilotShip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pilot_ship_id")
	private int pilotShipId;

	@Column(name="is_main")
	private byte isMain;

	@Column(name="link_ship_id")
	private int linkShipId;

	//bi-directional many-to-one association to PilotShipSlot
	@OneToMany(mappedBy="pilotShip")
	private List<PilotShipSlot> pilotShipSlots;

	//bi-directional many-to-one association to Pilot
	@ManyToOne
	@JoinColumn(name="pilot_id")
	private Pilot pilot;

	//bi-directional many-to-one association to Ship
	@ManyToOne
	@JoinColumn(name="ship_id")
	private Ship ship;

	public PilotShip() {
	}

	public int getPilotShipId() {
		return this.pilotShipId;
	}

	public void setPilotShipId(int pilotShipId) {
		this.pilotShipId = pilotShipId;
	}

	public byte getIsMain() {
		return this.isMain;
	}

	public void setIsMain(byte isMain) {
		this.isMain = isMain;
	}

	public int getLinkShipId() {
		return this.linkShipId;
	}

	public void setLinkShipId(int linkShipId) {
		this.linkShipId = linkShipId;
	}

	public List<PilotShipSlot> getPilotShipSlots() {
		return this.pilotShipSlots;
	}

	public void setPilotShipSlots(List<PilotShipSlot> pilotShipSlots) {
		this.pilotShipSlots = pilotShipSlots;
	}

	public PilotShipSlot addPilotShipSlot(PilotShipSlot pilotShipSlot) {
		getPilotShipSlots().add(pilotShipSlot);
		pilotShipSlot.setPilotShip(this);

		return pilotShipSlot;
	}

	public PilotShipSlot removePilotShipSlot(PilotShipSlot pilotShipSlot) {
		getPilotShipSlots().remove(pilotShipSlot);
		pilotShipSlot.setPilotShip(null);

		return pilotShipSlot;
	}

	public Pilot getPilot() {
		return this.pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public Ship getShip() {
		return this.ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

}