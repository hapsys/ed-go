package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the slot_types database table.
 * 
 */
@Entity
@Table(name="slot_types")
@NamedQuery(name="SlotType.findAll", query="SELECT s FROM SlotType s")
public class SlotType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="slot_type_id", updatable=false)
	private int id;

	@Column(name="slot_type_name")
	private String name;

	public SlotType() {
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

}