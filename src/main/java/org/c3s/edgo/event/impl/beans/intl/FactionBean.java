/**
 * 
 */
package org.c3s.edgo.event.impl.beans.intl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.c3s.edgo.utils.EDUtils;

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
	private FactionPRState[] PendingStates;
	private FactionPRState[] RecovingStates;

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
	public FactionPRState[] getPendingStates() {
		return PendingStates;
	}
	public void setPendingStates(FactionPRState[] pendingStates) {
		PendingStates = pendingStates;
	}
	public FactionPRState[] getRecovingStates() {
		return RecovingStates;
	}
	public void setRecovingStates(FactionPRState[] recovingStates) {
		RecovingStates = recovingStates;
	}
	

	public String getPendingStatesAsString() {
		String result = "";
		if (PendingStates != null) {
			List<String> states = new ArrayList<>();
			for(FactionPRState state: PendingStates) {
				states.add(EDUtils.cutFull(state.getState()));
			}
			states.sort(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
			result = String.join(",", states);
		}
		return result;
	}
	
	public String getRecovingStatesAsString() {
		String result = "";
		if (RecovingStates != null) {
			List<String> states = new ArrayList<>();
			for(FactionPRState state: RecovingStates) {
				states.add(EDUtils.cutFull(state.getState()));
			}
			states.sort(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
			result = String.join(",", states);
		}
		return result;
	}
}
