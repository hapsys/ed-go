package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the module_recipies database table.
 * 
 */
@Entity
@Table(name="module_recipies")
@NamedQuery(name="ModuleRecipy.findAll", query="SELECT m FROM ModuleRecipy m")
public class ModuleRecipy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="module_recipe_id")
	private int moduleRecipeId;

	@Column(name="recipie_level")
	private byte recipieLevel;

	//bi-directional many-to-many association to Modifier
	@ManyToMany(mappedBy="moduleRecipies")
	private List<Modifier> modifiers;

	//bi-directional many-to-one association to ModuleModifier
	@OneToMany(mappedBy="moduleRecipy")
	private List<ModuleModifier> moduleModifiers;

	//bi-directional many-to-one association to PilotModule
	@ManyToOne
	@JoinColumn(name="pilot_module_id")
	private PilotModule pilotModule;

	//bi-directional many-to-one association to Recipy
	@ManyToOne
	@JoinColumn(name="recipe_id")
	private Recipy recipy;

	public ModuleRecipy() {
	}

	public int getModuleRecipeId() {
		return this.moduleRecipeId;
	}

	public void setModuleRecipeId(int moduleRecipeId) {
		this.moduleRecipeId = moduleRecipeId;
	}

	public byte getRecipieLevel() {
		return this.recipieLevel;
	}

	public void setRecipieLevel(byte recipieLevel) {
		this.recipieLevel = recipieLevel;
	}

	public List<Modifier> getModifiers() {
		return this.modifiers;
	}

	public void setModifiers(List<Modifier> modifiers) {
		this.modifiers = modifiers;
	}

	public List<ModuleModifier> getModuleModifiers() {
		return this.moduleModifiers;
	}

	public void setModuleModifiers(List<ModuleModifier> moduleModifiers) {
		this.moduleModifiers = moduleModifiers;
	}

	public ModuleModifier addModuleModifier(ModuleModifier moduleModifier) {
		getModuleModifiers().add(moduleModifier);
		moduleModifier.setModuleRecipy(this);

		return moduleModifier;
	}

	public ModuleModifier removeModuleModifier(ModuleModifier moduleModifier) {
		getModuleModifiers().remove(moduleModifier);
		moduleModifier.setModuleRecipy(null);

		return moduleModifier;
	}

	public PilotModule getPilotModule() {
		return this.pilotModule;
	}

	public void setPilotModule(PilotModule pilotModule) {
		this.pilotModule = pilotModule;
	}

	public Recipy getRecipy() {
		return this.recipy;
	}

	public void setRecipy(Recipy recipy) {
		this.recipy = recipy;
	}

}