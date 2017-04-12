/**
 * 
 */
package org.c3s.edgo.event.impl.beans.intl;

/**
 * @author admin
 *
 */
public class FactionBean {
	
	private String Name;
	private String FactionState;
	private String Government;
	private String Allegiance;
	private float Influence;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getFactionState() {
		return FactionState;
	}
	public void setFactionState(String factionState) {
		FactionState = factionState;
	}
	public String getGovernment() {
		return Government;
	}
	public void setGovernment(String government) {
		Government = government;
	}
	public String getAllegiance() {
		return Allegiance;
	}
	public void setAllegiance(String allegiance) {
		Allegiance = allegiance;
	}
	public float getInfluence() {
		return Influence;
	}
	public void setInfluence(float influence) {
		Influence = influence;
	}
	
}
