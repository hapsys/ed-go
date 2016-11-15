package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the module_modifiers database table.
 * 
 */
@Entity
@Table(name="module_modifiers")
@NamedQuery(name="ModuleModifier.findAll", query="SELECT m FROM ModuleModifier m")
public class ModuleModifier implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ModuleModifierPK id;

	private byte type;

	private float value;

	//bi-directional many-to-one association to Modifier
	@ManyToOne
	@JoinColumn(name="modifier_id", insertable=false, updatable=false)
	private Modifier modifier;

	//bi-directional many-to-one association to ModuleRecipy
	@ManyToOne
	@JoinColumn(name="module_recipe_id", insertable=false, updatable=false)
	private ModuleRecipy moduleRecipy;

	public ModuleModifier() {
	}

	public ModuleModifierPK getId() {
		return this.id;
	}

	public void setId(ModuleModifierPK id) {
		this.id = id;
	}

	public byte getType() {
		return this.type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public float getValue() {
		return this.value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public Modifier getModifier() {
		return this.modifier;
	}

	public void setModifier(Modifier modifier) {
		this.modifier = modifier;
	}

	public ModuleRecipy getModuleRecipy() {
		return this.moduleRecipy;
	}

	public void setModuleRecipy(ModuleRecipy moduleRecipy) {
		this.moduleRecipy = moduleRecipy;
	}

}