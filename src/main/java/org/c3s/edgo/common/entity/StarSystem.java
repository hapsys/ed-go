package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the systems database table.
 * 
 */
@Entity
@Table(name="systems")
@NamedQueries({
	@NamedQuery(name="StarSystem.findAll", query="SELECT s FROM StarSystem s"),
	@NamedQuery(name="StarSystem.findByUniq", query="SELECT s FROM StarSystem s WHERE s.nameUniq = :uniq"),
})

public class StarSystem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="system_id")
	private String systemId;

	@Column(name="is_populated")
	private byte isPopulated;

	private String name;

	@Column(name="name_stations")
	private String nameStations;

	@Column(name="name_uniq")
	private String nameUniq;

	private double x;

	private double y;

	private double z;

	public StarSystem() {
	}

	public String getSystemId() {
		return this.systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public byte getIsPopulated() {
		return this.isPopulated;
	}

	public void setIsPopulated(byte isPopulated) {
		this.isPopulated = isPopulated;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameStations() {
		return this.nameStations;
	}

	public void setNameStations(String nameStations) {
		this.nameStations = nameStations;
	}

	public String getNameUniq() {
		return this.nameUniq;
	}

	public void setNameUniq(String nameUniq) {
		this.nameUniq = nameUniq;
	}

	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return this.z;
	}

	public void setZ(double z) {
		this.z = z;
	}

}