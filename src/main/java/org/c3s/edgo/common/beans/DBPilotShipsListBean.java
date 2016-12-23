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


public class DBPilotShipsListBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"station_name", "stationName"})
	@DataTarget("name")
	@XMLSimple("stationName")
	private java.lang.String stationName;
	
	public java.lang.String getStationName() {
		return stationName;
	}
	
	public DBPilotShipsListBean setStationName(java.lang.String value) {
		stationName = value;
		return this;
	}
	
	
	@DataSource({"link_ship_id", "linkShipId"})
	@DataTarget("link_ship_id")
	@XMLSimple("linkShipId")
	private java.lang.Long linkShipId;
	
	public java.lang.Long getLinkShipId() {
		return linkShipId;
	}
	
	public DBPilotShipsListBean setLinkShipId(java.lang.Long value) {
		linkShipId = value;
		return this;
	}
	
	
	@DataSource({"pilot_ship_id", "pilotShipId"})
	@DataTarget("pilot_ship_id")
	@XMLSimple("pilotShipId")
	private java.lang.Long pilotShipId;
	
	public java.lang.Long getPilotShipId() {
		return pilotShipId;
	}
	
	public DBPilotShipsListBean setPilotShipId(java.lang.Long value) {
		pilotShipId = value;
		return this;
	}
	
	
	@DataSource({"system_id", "systemId"})
	@DataTarget("system_id")
	@XMLSimple("systemId")
	private java.math.BigInteger systemId;
	
	public java.math.BigInteger getSystemId() {
		return systemId;
	}
	
	public DBPilotShipsListBean setSystemId(java.math.BigInteger value) {
		systemId = value;
		return this;
	}
	
	
	@DataSource({"station_id", "stationId"})
	@DataTarget("station_id")
	@XMLSimple("stationId")
	private java.lang.Long stationId;
	
	public java.lang.Long getStationId() {
		return stationId;
	}
	
	public DBPilotShipsListBean setStationId(java.lang.Long value) {
		stationId = value;
		return this;
	}
	
	
	@DataSource({"system_name", "systemName"})
	@DataTarget("name")
	@XMLSimple("systemName")
	private java.lang.String systemName;
	
	public java.lang.String getSystemName() {
		return systemName;
	}
	
	public DBPilotShipsListBean setSystemName(java.lang.String value) {
		systemName = value;
		return this;
	}
	
	
	@DataSource({"can_deleted", "canDeleted"})
	@DataTarget("can_deleted")
	@XMLSimple("canDeleted")
	private java.lang.Integer canDeleted;
	
	public java.lang.Integer getCanDeleted() {
		return canDeleted;
	}
	
	public DBPilotShipsListBean setCanDeleted(java.lang.Integer value) {
		canDeleted = value;
		return this;
	}
	
	
	@DataSource({"pilot_id", "pilotId"})
	@DataTarget("pilot_id")
	@XMLSimple("pilotId")
	private java.lang.Long pilotId;
	
	public java.lang.Long getPilotId() {
		return pilotId;
	}
	
	public DBPilotShipsListBean setPilotId(java.lang.Long value) {
		pilotId = value;
		return this;
	}
	
	
	@DataSource({"ship_uniq", "shipUniq"})
	@DataTarget("ship_uniq")
	@XMLSimple("shipUniq")
	private java.lang.String shipUniq;
	
	public java.lang.String getShipUniq() {
		return shipUniq;
	}
	
	public DBPilotShipsListBean setShipUniq(java.lang.String value) {
		shipUniq = value;
		return this;
	}
	
	
	@DataSource({"is_special", "isSpecial"})
	@DataTarget("is_special")
	@XMLSimple("isSpecial")
	private java.lang.Integer isSpecial;
	
	public java.lang.Integer getIsSpecial() {
		return isSpecial;
	}
	
	public DBPilotShipsListBean setIsSpecial(java.lang.Integer value) {
		isSpecial = value;
		return this;
	}
	
	
	@DataSource({"is_main", "isMain"})
	@DataTarget("is_main")
	@XMLSimple("isMain")
	private java.lang.Integer isMain;
	
	public java.lang.Integer getIsMain() {
		return isMain;
	}
	
	public DBPilotShipsListBean setIsMain(java.lang.Integer value) {
		isMain = value;
		return this;
	}
	
	
	@DataSource({"ship_name", "shipName"})
	@DataTarget("ship_name")
	@XMLSimple("shipName")
	private java.lang.String shipName;
	
	public java.lang.String getShipName() {
		return shipName;
	}
	
	public DBPilotShipsListBean setShipName(java.lang.String value) {
		shipName = value;
		return this;
	}
	
	
	@DataSource({"ship_id", "shipId"})
	@DataTarget("ship_id")
	@XMLSimple("shipId")
	private java.lang.Long shipId;
	
	public java.lang.Long getShipId() {
		return shipId;
	}
	
	public DBPilotShipsListBean setShipId(java.lang.Long value) {
		shipId = value;
		return this;
	}
	
	
	@DataSource({"pilot_ship_name", "pilotShipName"})
	@DataTarget("pilot_ship_name")
	@XMLSimple("pilotShipName")
	private java.lang.String pilotShipName;
	
	public java.lang.String getPilotShipName() {
		return pilotShipName;
	}
	
	public DBPilotShipsListBean setPilotShipName(java.lang.String value) {
		pilotShipName = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
	}	
	
}