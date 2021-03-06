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


public class DBPilotShipsBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"link_ship_id", "linkShipId"})
	@DataTarget("link_ship_id")
	@XMLSimple("linkShipId")
	private java.lang.Long linkShipId;
	
	public java.lang.Long getLinkShipId() {
		return linkShipId;
	}
	
	public DBPilotShipsBean setLinkShipId(java.lang.Long value) {
		this.linkShipId = value;
		return this;
	}
	
	
	@DataSource({"pilot_ship_id", "pilotShipId"})
	@DataTarget("pilot_ship_id")
	@XMLSimple("pilotShipId")
	private java.lang.Long pilotShipId;
	
	public java.lang.Long getPilotShipId() {
		return pilotShipId;
	}
	
	public DBPilotShipsBean setPilotShipId(java.lang.Long value) {
		this.pilotShipId = value;
		return this;
	}
	
	
	@DataSource({"pilot_ship_ident", "pilotShipIdent"})
	@DataTarget("pilot_ship_ident")
	@XMLSimple("pilotShipIdent")
	private java.lang.String pilotShipIdent;
	
	public java.lang.String getPilotShipIdent() {
		return pilotShipIdent;
	}
	
	public DBPilotShipsBean setPilotShipIdent(java.lang.String value) {
		this.pilotShipIdent = value;
		return this;
	}
	
	
	@DataSource({"system_id", "systemId"})
	@DataTarget("system_id")
	@XMLSimple("systemId")
	private java.math.BigInteger systemId;
	
	public java.math.BigInteger getSystemId() {
		return systemId;
	}
	
	public DBPilotShipsBean setSystemId(java.math.BigInteger value) {
		this.systemId = value;
		return this;
	}
	
	
	@DataSource({"is_main", "isMain"})
	@DataTarget("is_main")
	@XMLSimple("isMain")
	private java.lang.Integer isMain;
	
	public java.lang.Integer getIsMain() {
		return isMain;
	}
	
	public DBPilotShipsBean setIsMain(java.lang.Integer value) {
		this.isMain = value;
		return this;
	}
	
	
	@DataSource({"station_id", "stationId"})
	@DataTarget("station_id")
	@XMLSimple("stationId")
	private java.lang.Long stationId;
	
	public java.lang.Long getStationId() {
		return stationId;
	}
	
	public DBPilotShipsBean setStationId(java.lang.Long value) {
		this.stationId = value;
		return this;
	}
	
	
	@DataSource({"can_deleted", "canDeleted"})
	@DataTarget("can_deleted")
	@XMLSimple("canDeleted")
	private java.lang.Integer canDeleted;
	
	public java.lang.Integer getCanDeleted() {
		return canDeleted;
	}
	
	public DBPilotShipsBean setCanDeleted(java.lang.Integer value) {
		this.canDeleted = value;
		return this;
	}
	
	
	@DataSource({"pilot_id", "pilotId"})
	@DataTarget("pilot_id")
	@XMLSimple("pilotId")
	private java.lang.Long pilotId;
	
	public java.lang.Long getPilotId() {
		return pilotId;
	}
	
	public DBPilotShipsBean setPilotId(java.lang.Long value) {
		this.pilotId = value;
		return this;
	}
	
	
	@DataSource({"ship_id", "shipId"})
	@DataTarget("ship_id")
	@XMLSimple("shipId")
	private java.lang.Long shipId;
	
	public java.lang.Long getShipId() {
		return shipId;
	}
	
	public DBPilotShipsBean setShipId(java.lang.Long value) {
		this.shipId = value;
		return this;
	}
	
	
	@DataSource({"pilot_ship_name", "pilotShipName"})
	@DataTarget("pilot_ship_name")
	@XMLSimple("pilotShipName")
	private java.lang.String pilotShipName;
	
	public java.lang.String getPilotShipName() {
		return pilotShipName;
	}
	
	public DBPilotShipsBean setPilotShipName(java.lang.String value) {
		this.pilotShipName = value;
		return this;
	}
	
	
	@DataSource({"ship", "ship"})
	@DataTarget("ship")
	@XMLReflectionField

	private DBShipsBean ship;
	
	public DBShipsBean getShip() {
		return ship;
	}
	
	public DBPilotShipsBean setShip(DBShipsBean value) {
		this.ship = value;
		return this;
	}
	
	
	@DataSource({"modules", "modules"})
	@DataTarget("modules")
	@XMLFieldList

	private List<? extends Object> modules;
	
	public List<? extends Object> getModules() {
		return modules;
	}
	
	public DBPilotShipsBean setModules(List<? extends Object> value) {
		this.modules = value;
		return this;
	}
	
	
	@DataSource({"system_name", "systemName"})
	@DataTarget("system_name")
	@XMLSimple("systemName")

	private String systemName;
	
	public String getSystemName() {
		return systemName;
	}
	
	public DBPilotShipsBean setSystemName(String value) {
		this.systemName = value;
		return this;
	}
	
	
	@DataSource({"station_name", "stationName"})
	@DataTarget("station_name")
	@XMLSimple("stationName")

	private String stationName;
	
	public String getStationName() {
		return stationName;
	}
	
	public DBPilotShipsBean setStationName(String value) {
		this.stationName = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
		setPilotShipId(new java.lang.Long(value.toString()));
		
	}	
	
}