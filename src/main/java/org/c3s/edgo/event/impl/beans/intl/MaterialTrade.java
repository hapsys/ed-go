package org.c3s.edgo.event.impl.beans.intl;

public class MaterialTrade {

	private String Material;
	
	private String Material_Localised;
	
	private int Quantity;

	public String getMaterial() {
		return Material;
	}

	public void setMaterial(String material) {
		Material = material;
	}

	public String getMaterial_Localised() {
		return Material_Localised;
	}

	public void setMaterial_Localised(String material_Localised) {
		Material_Localised = material_Localised;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
}
