package org.c3s.edgo.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the location_history database table.
 * 
 */
@Entity
@Table(name="location_history")
@NamedQueries({
	@NamedQuery(name="LocationHistory.findAll", query="SELECT l FROM LocationHistory l"),
	@NamedQuery(name="LocationHistory.findLastByPilotId", query="SELECT l FROM LocationHistory l WHERE l.pilotId = :pilot_id ORDER BY l.locationTime DESC"),
})
public class LocationHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="location_id")
	private int locationId;

	@Column(name="location_time")
	private Timestamp locationTime;

	@Column(name="pilot_id")
	private int pilotId;

	@OneToOne
	@JoinColumn(name="station_id")
	private Station station;

	@OneToOne
	@JoinColumn(name="system_id")
	private StarSystem system;

	public LocationHistory() {
	}

	public int getLocationId() {
		return this.locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public Timestamp getLocationTime() {
		return this.locationTime;
	}

	public void setLocationTime(Timestamp locationTime) {
		this.locationTime = locationTime;
	}

	public int getPilotId() {
		return this.pilotId;
	}

	public void setPilotId(int pilotId) {
		this.pilotId = pilotId;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public StarSystem getSystem() {
		return system;
	}

	public void setSystem(StarSystem system) {
		this.system = system;
	}

}