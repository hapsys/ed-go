package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the powers database table.
 * 
 */
@Entity
@Table(name="powers")
@NamedQuery(name="Power.findAll", query="SELECT p FROM Power p")
public class Power implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="power_id")
	private int powerId;

	@Column(name="power_name")
	private String powerName;

	@Column(name="power_uniq")
	private String powerUniq;

	public Power() {
	}

	public int getPowerId() {
		return this.powerId;
	}

	public void setPowerId(int powerId) {
		this.powerId = powerId;
	}

	public String getPowerName() {
		return this.powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

	public String getPowerUniq() {
		return this.powerUniq;
	}

	public void setPowerUniq(String powerUniq) {
		this.powerUniq = powerUniq;
	}

}