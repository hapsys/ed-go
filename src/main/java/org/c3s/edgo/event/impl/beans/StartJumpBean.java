package org.c3s.edgo.event.impl.beans;

import java.util.Date;
import org.c3s.edgo.event.AbstractEventBean;

public class StartJumpBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 *  "Hyperspace" or "Supercruise"
	 */
	private String JumpType;
	/**
	 *  name of destination system (for a hyperspace jump)
	 */
	private String StarSystem;
	/**
	 *  star type (only for a hyperspace jump)
	 */
	private String StarClass;
	
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
	public String getJumpType() {
		return JumpType;
	}
	/**
	 * @param jumptype
	 */
	public void setJumpType(String jumptype) {
		this.JumpType = jumptype;
	}
	/**
	 * @return
	 */
	public String getStarSystem() {
		return StarSystem;
	}
	/**
	 * @param starsystem
	 */
	public void setStarSystem(String starsystem) {
		this.StarSystem = starsystem;
	}
	/**
	 * @return
	 */
	public String getStarClass() {
		return StarClass;
	}
	/**
	 * @param starclass
	 */
	public void setStarClass(String starclass) {
		this.StarClass = starclass;
	}
	
}	
	