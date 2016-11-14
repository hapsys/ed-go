package org.c3s.edgo.event.impl.beans;

public class ScanBean {
	/**
	 *  type of material (Raw/Encoded/Manufactured)
	 */
	private String Category;
	/**
	 *  name of material
	 */
	private String Name;
	/**
	 * @return
	 */
	public String getCategory() {
		return Category;
	}
	/**
	 * @param category
	 */
	public void setCategory(String category) {
		this.Category = category;
	}
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
	
}	
	