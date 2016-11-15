package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the module_modifiers database table.
 * 
 */
@Embeddable
public class ModuleModifierPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="modifier_id", insertable=false, updatable=false)
	private int modifierId;

	@Column(name="module_recipe_id", insertable=false, updatable=false)
	private int moduleRecipeId;

	public ModuleModifierPK() {
	}
	public int getModifierId() {
		return this.modifierId;
	}
	public void setModifierId(int modifierId) {
		this.modifierId = modifierId;
	}
	public int getModuleRecipeId() {
		return this.moduleRecipeId;
	}
	public void setModuleRecipeId(int moduleRecipeId) {
		this.moduleRecipeId = moduleRecipeId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ModuleModifierPK)) {
			return false;
		}
		ModuleModifierPK castOther = (ModuleModifierPK)other;
		return 
			(this.modifierId == castOther.modifierId)
			&& (this.moduleRecipeId == castOther.moduleRecipeId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.modifierId;
		hash = hash * prime + this.moduleRecipeId;
		
		return hash;
	}
}