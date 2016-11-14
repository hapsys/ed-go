package org.c3s.edgo.event.impl.beans;

public class FuelScoopBean {
	/**
	 *  tons fuel scooped
	 */
	private String Scooped;
	/**
	 *  total fuel level after scooping
	 */
	private String Total;
	/**
	 * @return
	 */
	public String getScooped() {
		return Scooped;
	}
	/**
	 * @param scooped
	 */
	public void setScooped(String scooped) {
		this.Scooped = scooped;
	}
	/**
	 * @return
	 */
	public String getTotal() {
		return Total;
	}
	/**
	 * @param total
	 */
	public void setTotal(String total) {
		this.Total = total;
	}
	
}	
	