package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the recipies database table.
 * 
 */
@Entity
@Table(name="recipies")
@NamedQuery(name="Recipy.findAll", query="SELECT r FROM Recipy r")
public class Recipy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="recipe_id")
	private int recipeId;

	@Column(name="recipe_name")
	private String recipeName;

	//bi-directional many-to-one association to ModuleRecipy
	@OneToMany(mappedBy="recipy")
	private List<ModuleRecipy> moduleRecipies;

	public Recipy() {
	}

	public int getRecipeId() {
		return this.recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return this.recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public List<ModuleRecipy> getModuleRecipies() {
		return this.moduleRecipies;
	}

	public void setModuleRecipies(List<ModuleRecipy> moduleRecipies) {
		this.moduleRecipies = moduleRecipies;
	}

	public ModuleRecipy addModuleRecipy(ModuleRecipy moduleRecipy) {
		getModuleRecipies().add(moduleRecipy);
		moduleRecipy.setRecipy(this);

		return moduleRecipy;
	}

	public ModuleRecipy removeModuleRecipy(ModuleRecipy moduleRecipy) {
		getModuleRecipies().remove(moduleRecipy);
		moduleRecipy.setRecipy(null);

		return moduleRecipy;
	}

}