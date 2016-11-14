package org.c3s.edgo.event.impl.beans;

public class EjectCargoBean {
	/**
	 *  cargo type
	 */
	private String Type;
	/**
	 *  number of units
	 */
	private String Count;
	/**
	 *  whether ‘abandoned’
	 */
	private String Abandoned;
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
	public String getCount() {
		return Count;
	}
	/**
	 * @param count
	 */
	public void setCount(String count) {
		this.Count = count;
	}
	/**
	 * @return
	 */
	public String getAbandoned() {
		return Abandoned;
	}
	/**
	 * @param abandoned
	 */
	public void setAbandoned(String abandoned) {
		this.Abandoned = abandoned;
	}
	
}	
	