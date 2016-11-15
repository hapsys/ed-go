package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the modifiers database table.
 * 
 */
@Entity
@Table(name="modifiers")
@NamedQuery(name="Modifier.findAll", query="SELECT m FROM Modifier m")
public class Modifier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="modifier_id")
	private int modifierId;

	@Column(name="modifier_name")
	private String modifierName;

	//bi-directional many-to-many association to ModuleRecipy
	@ManyToMany
	@JoinTable(
		name="module_modifiers"
		, joinColumns={
			@JoinColumn(name="modifier_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="module_recipe_id")
			}
		)
	private List<ModuleRecipy> moduleRecipies;

	//bi-directional many-to-one association to ModuleModifier
	@OneToMany(mappedBy="modifier")
	private List<ModuleModifier> moduleModifiers;

	public Modifier() {
	}

	public int getModifierId() {
		return this.modifierId;
	}

	public void setModifierId(int modifierId) {
		this.modifierId = modifierId;
	}

	public String getModifierName() {
		return this.modifierName;
	}

	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
	}

	public List<ModuleRecipy> getModuleRecipies() {
		return this.moduleRecipies;
	}

	public void setModuleRecipies(List<ModuleRecipy> moduleRecipies) {
		this.moduleRecipies = moduleRecipies;
	}

	public List<ModuleModifier> getModuleModifiers() {
		return this.moduleModifiers;
	}

	public void setModuleModifiers(List<ModuleModifier> moduleModifiers) {
		this.moduleModifiers = moduleModifiers;
	}

	public ModuleModifier addModuleModifier(ModuleModifier moduleModifier) {
		getModuleModifiers().add(moduleModifier);
		moduleModifier.setModifier(this);

		return moduleModifier;
	}

	public ModuleModifier removeModuleModifier(ModuleModifier moduleModifier) {
		getModuleModifiers().remove(moduleModifier);
		moduleModifier.setModifier(null);

		return moduleModifier;
	}

}