package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the module_groups database table.
 * 
 */
@Entity
@Table(name="module_groups")
@NamedQuery(name="ModuleGroup.findAll", query="SELECT m FROM ModuleGroup m")
public class ModuleGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="module_group_id")
	private int id;

	@Column(name="module_group_name")
	private String name;

	//uni-directional many-to-one association to SlotType
	@ManyToOne
	@JoinColumn(name="slot_type_id")
	private SlotType slotType;

	public ModuleGroup() {
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

	public SlotType getSlotType() {
		return this.slotType;
	}

	public void setSlotType(SlotType slotType) {
		this.slotType = slotType;
	}

}