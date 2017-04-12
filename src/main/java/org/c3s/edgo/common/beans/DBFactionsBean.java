/**
 *  Autogenerated class
 */
package org.c3s.edgo.common.beans;

import java.io.Serializable;
import java.util.*;
import org.c3s.db.beans.DbBean;
import org.c3s.data.annotations.DataSource;
import org.c3s.data.annotations.DataTarget;
import org.c3s.reflection.annotation.*;


public class DBFactionsBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"allegiance_id", "allegianceId"})
	@DataTarget("allegiance_id")
	@XMLSimple("allegianceId")
	private java.lang.Long allegianceId;
	
	public java.lang.Long getAllegianceId() {
		return allegianceId;
	}
	
	public DBFactionsBean setAllegianceId(java.lang.Long value) {
		allegianceId = value;
		return this;
	}
	
	
	@DataSource({"faction_id", "factionId"})
	@DataTarget("faction_id")
	@XMLSimple("factionId")
	private java.lang.Long factionId;
	
	public java.lang.Long getFactionId() {
		return factionId;
	}
	
	public DBFactionsBean setFactionId(java.lang.Long value) {
		factionId = value;
		return this;
	}
	
	
	@DataSource({"allegiance", "allegiance"})
	@DataTarget("allegiance")
	@XMLSimple("allegiance")
	private java.lang.String allegiance;
	
	public java.lang.String getAllegiance() {
		return allegiance;
	}
	
	public DBFactionsBean setAllegiance(java.lang.String value) {
		allegiance = value;
		return this;
	}
	
	
	@DataSource({"government_id", "governmentId"})
	@DataTarget("government_id")
	@XMLSimple("governmentId")
	private java.lang.Long governmentId;
	
	public java.lang.Long getGovernmentId() {
		return governmentId;
	}
	
	public DBFactionsBean setGovernmentId(java.lang.Long value) {
		governmentId = value;
		return this;
	}
	
	
	@DataSource({"government", "government"})
	@DataTarget("government")
	@XMLSimple("government")
	private java.lang.String government;
	
	public java.lang.String getGovernment() {
		return government;
	}
	
	public DBFactionsBean setGovernment(java.lang.String value) {
		government = value;
		return this;
	}
	
	
	@DataSource({"updated_at", "updatedAt"})
	@DataTarget("updated_at")
	@XMLSimple("updatedAt")
	private java.lang.Long updatedAt;
	
	public java.lang.Long getUpdatedAt() {
		return updatedAt;
	}
	
	public DBFactionsBean setUpdatedAt(java.lang.Long value) {
		updatedAt = value;
		return this;
	}
	
	
	@DataSource({"uniq", "uniq"})
	@DataTarget("uniq")
	@XMLSimple("uniq")
	private java.lang.String uniq;
	
	public java.lang.String getUniq() {
		return uniq;
	}
	
	public DBFactionsBean setUniq(java.lang.String value) {
		uniq = value;
		return this;
	}
	
	
	@DataSource({"is_player_faction", "isPlayerFaction"})
	@DataTarget("is_player_faction")
	@XMLSimple("isPlayerFaction")
	private java.lang.Integer isPlayerFaction;
	
	public java.lang.Integer getIsPlayerFaction() {
		return isPlayerFaction;
	}
	
	public DBFactionsBean setIsPlayerFaction(java.lang.Integer value) {
		isPlayerFaction = value;
		return this;
	}
	
	
	@DataSource({"name", "name"})
	@DataTarget("name")
	@XMLSimple("name")
	private java.lang.String name;
	
	public java.lang.String getName() {
		return name;
	}
	
	public DBFactionsBean setName(java.lang.String value) {
		name = value;
		return this;
	}
	
	
	@DataSource({"state_id", "stateId"})
	@DataTarget("state_id")
	@XMLSimple("stateId")
	private java.lang.Long stateId;
	
	public java.lang.Long getStateId() {
		return stateId;
	}
	
	public DBFactionsBean setStateId(java.lang.Long value) {
		stateId = value;
		return this;
	}
	
	
	@DataSource({"state", "state"})
	@DataTarget("state")
	@XMLSimple("state")
	private java.lang.String state;
	
	public java.lang.String getState() {
		return state;
	}
	
	public DBFactionsBean setState(java.lang.String value) {
		state = value;
		return this;
	}
	
	
	@DataSource({"home_system_id", "homeSystemId"})
	@DataTarget("home_system_id")
	@XMLSimple("homeSystemId")
	private java.lang.Long homeSystemId;
	
	public java.lang.Long getHomeSystemId() {
		return homeSystemId;
	}
	
	public DBFactionsBean setHomeSystemId(java.lang.Long value) {
		homeSystemId = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
		setFactionId(new java.lang.Long(value.toString()));
		
	}	
	
}