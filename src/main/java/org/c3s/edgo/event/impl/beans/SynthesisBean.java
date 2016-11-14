package org.c3s.edgo.event.impl.beans;

public class SynthesisBean {
	/**
	 *  synthesis blueprint
	 */
	private String Name;
	/**
	 *  JSON object listing materials used and quantities
	 */
	private String Materials;
	/**
	 * @return
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.Name = name;
	}
	/**
	 * @return
	 */
	public String getMaterials() {
		return Materials;
	}
	/**
	 * @param materials
	 */
	public void setMaterials(String materials) {
		this.Materials = materials;
	}
	
}	
	