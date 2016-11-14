package org.c3s.edgo.event.impl.beans;

public class NewCommanderBean {
	/**
	 *  (new) commander name
	 */
	private String Name;
	/**
	 *  selected starter package
	 */
	private String Package;
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
	public String getPackage() {
		return Package;
	}
	/**
	 * @param packageParam
	 */
	public void setPackage(String packageParam) {
		this.Package = packageParam;
	}
	
}	
	