package org.c3s.edgo.common.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the pilots database table.
 * 
 */
@Entity
@Table(name="pilots")
@NamedQueries({
	@NamedQuery(name="Pilot.findAll", query="SELECT p FROM Pilot p"),
	@NamedQuery(name="Pilot.findByName", query="SELECT p FROM Pilot p WHERE LOWER(p.pilotName) = LOWER(:name)"),
	@NamedQuery(name="Pilot.findByUserId", query="SELECT p FROM Pilot p WHERE p.userId = :user_id"),
})
public class Pilot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pilot_id")
	private int pilotId;

	@Column(name="pilot_name")
	private String pilotName;

	//bi-directional many-to-one association to PilotShip
	@OneToMany(mappedBy="pilot")
	private List<PilotShip> pilotShips;

	@Column(name="user_id")
	private int userId;
	
	
	@Column(name="is_current")
	private byte isCurrent;
	
	public Pilot() {
	}

	public int getPilotId() {
		return this.pilotId;
	}

	public void setPilotId(int pilotId) {
		this.pilotId = pilotId;
	}

	public String getPilotName() {
		return this.pilotName;
	}

	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}

	public List<PilotShip> getPilotShips() {
		return this.pilotShips;
	}

	public void setPilotShips(List<PilotShip> pilotShips) {
		this.pilotShips = pilotShips;
	}

	public PilotShip addPilotShip(PilotShip pilotShip) {
		getPilotShips().add(pilotShip);
		pilotShip.setPilot(this);

		return pilotShip;
	}

	public PilotShip removePilotShip(PilotShip pilotShip) {
		getPilotShips().remove(pilotShip);
		pilotShip.setPilot(null);

		return pilotShip;
	}

	public boolean hasPilotShip(final int id) {
		long result = 0;
		if (pilotShips != null) {
			result = pilotShips.stream().filter(p -> p.getLinkShipId() == id).count();
		}
		return result != 0;
	}
	
	public PilotShip getPilotShip(final int id) {
		return pilotShips.stream().filter(p -> p.getLinkShipId() == id).findFirst().orElse(null);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int user_id) {
		this.userId = user_id;
	}

	public byte getIsCurrent() {
		return isCurrent;
	}

	public void setIsCurrent(byte isCurrent) {
		this.isCurrent = isCurrent;
	}
	
}