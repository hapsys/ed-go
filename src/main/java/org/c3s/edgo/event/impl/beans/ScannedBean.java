package org.c3s.edgo.event.impl.beans;

import java.util.Date;
import org.c3s.edgo.event.AbstractEventBean;

public class ScannedBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 *  Cargo, Crime, Cabin, Data or Unknown
	 */
	private String ScanType;
	
	/**
	 * @return
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return
	 */
	public String getEvent() {
		return event;
	}
	/**
	 * @param event
	 */
	public void setEvent(String event) {
		this.event = event;
	}
	/**
	 * @return
	 */
	public String getScanType() {
		return ScanType;
	}
	/**
	 * @param scantype
	 */
	public void setScanType(String scantype) {
		this.ScanType = scantype;
	}
	
}	
	