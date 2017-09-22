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


public class DBSystemFactionInfluence1Bean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"faction_name", "factionName"})
	@DataTarget("name")
	@XMLSimple("factionName")
	private java.lang.String factionName;
	
	public java.lang.String getFactionName() {
		return factionName;
	}
	
	public DBSystemFactionInfluence1Bean setFactionName(java.lang.String value) {
		factionName = value;
		return this;
	}
	
	
	@DataSource({"state_name", "stateName"})
	@DataTarget("state_name")
	@XMLSimple("stateName")
	private java.lang.String stateName;
	
	public java.lang.String getStateName() {
		return stateName;
	}
	
	public DBSystemFactionInfluence1Bean setStateName(java.lang.String value) {
		stateName = value;
		return this;
	}
	
	
	@DataSource({"system_id", "systemId"})
	@DataTarget("system_id")
	@XMLSimple("systemId")
	private java.math.BigInteger systemId;
	
	public java.math.BigInteger getSystemId() {
		return systemId;
	}
	
	public DBSystemFactionInfluence1Bean setSystemId(java.math.BigInteger value) {
		systemId = value;
		return this;
	}
	
	
	@DataSource({"system_name", "systemName"})
	@DataTarget("name")
	@XMLSimple("systemName")
	private java.lang.String systemName;
	
	public java.lang.String getSystemName() {
		return systemName;
	}
	
	public DBSystemFactionInfluence1Bean setSystemName(java.lang.String value) {
		systemName = value;
		return this;
	}
	
	
	@DataSource({"faction_id", "factionId"})
	@DataTarget("faction_id")
	@XMLSimple("factionId")
	private java.lang.Long factionId;
	
	public java.lang.Long getFactionId() {
		return factionId;
	}
	
	public DBSystemFactionInfluence1Bean setFactionId(java.lang.Long value) {
		factionId = value;
		return this;
	}
	
	
	@DataSource({"state_id", "stateId"})
	@DataTarget("state_id")
	@XMLSimple("stateId")
	private java.lang.Long stateId;
	
	public java.lang.Long getStateId() {
		return stateId;
	}
	
	public DBSystemFactionInfluence1Bean setStateId(java.lang.Long value) {
		stateId = value;
		return this;
	}
	
	
	@DataSource({"create_date", "createDate"})
	@DataTarget("create_date")
	@XMLSimple("createDate")
	private java.sql.Timestamp createDate;
	
	public java.sql.Timestamp getCreateDate() {
		return createDate;
	}
	
	public DBSystemFactionInfluence1Bean setCreateDate(java.sql.Timestamp value) {
		createDate = value;
		return this;
	}
	
	
	@DataSource({"system_factions_history_id", "systemFactionsHistoryId"})
	@DataTarget("system_factions_history_id")
	@XMLSimple("systemFactionsHistoryId")
	private java.math.BigInteger systemFactionsHistoryId;
	
	public java.math.BigInteger getSystemFactionsHistoryId() {
		return systemFactionsHistoryId;
	}
	
	public DBSystemFactionInfluence1Bean setSystemFactionsHistoryId(java.math.BigInteger value) {
		systemFactionsHistoryId = value;
		return this;
	}
	
	
	@DataSource({"influence", "influence"})
	@DataTarget("influence")
	@XMLSimple("influence")
	private java.lang.Float influence;
	
	public java.lang.Float getInfluence() {
		return influence;
	}
	
	public DBSystemFactionInfluence1Bean setInfluence(java.lang.Float value) {
		influence = value;
		return this;
	}
	
	
	@DataSource({"state_uniq", "stateUniq"})
	@DataTarget("state_uniq")
	@XMLSimple("stateUniq")
	private java.lang.String stateUniq;
	
	public java.lang.String getStateUniq() {
		return stateUniq;
	}
	
	public DBSystemFactionInfluence1Bean setStateUniq(java.lang.String value) {
		stateUniq = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
		setStateId(new java.lang.Long(value.toString()));
		
		setSystemFactionsHistoryId(new java.math.BigInteger(value.toString()));
		
	}	
	
}