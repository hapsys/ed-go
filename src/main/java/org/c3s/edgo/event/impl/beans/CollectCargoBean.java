package org.c3s.edgo.event.impl.beans;

public class CollectCargoBean {
	/**
	 *  cargo type
	 */
	private String Type;
	/**
	 *  whether stolen goods
	 */
	private String Stolen;
	/**
	 * @return
	 */
	public String getType() {
		return Type;
	}
	/**
	 * @param type
	 */
	public void setType(String type) {
		this.Type = type;
	}
	/**
	 * @return
	 */
	public String getStolen() {
		return Stolen;
	}
	/**
	 * @param stolen
	 */
	public void setStolen(String stolen) {
		this.Stolen = stolen;
	}
	
}	
	