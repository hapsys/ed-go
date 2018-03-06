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


public class DBPilotModulesListBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"ships_count", "shipsCount"})
	@DataTarget("ships_count")
	@XMLSimple("shipsCount")
	private java.lang.Long shipsCount;
	
	public java.lang.Long getShipsCount() {
		return shipsCount;
	}
	
	public DBPilotModulesListBean setShipsCount(java.lang.Long value) {
		this.shipsCount = value;
		return this;
	}
	
	
	@DataSource({"module_rating", "moduleRating"})
	@DataTarget("module_rating")
	@XMLSimple("moduleRating")
	private java.lang.String moduleRating;
	
	public java.lang.String getModuleRating() {
		return moduleRating;
	}
	
	public DBPilotModulesListBean setModuleRating(java.lang.String value) {
		this.moduleRating = value;
		return this;
	}
	
	
	@DataSource({"ships", "ships"})
	@DataTarget("ships")
	@XMLSimple("ships")
	private java.lang.String ships;
	
	public java.lang.String getShips() {
		return ships;
	}
	
	public DBPilotModulesListBean setShips(java.lang.String value) {
		this.ships = value;
		return this;
	}
	
	
	@DataSource({"module_weapon_mode", "moduleWeaponMode"})
	@DataTarget("module_weapon_mode")
	@XMLSimple("moduleWeaponMode")
	private java.lang.String moduleWeaponMode;
	
	public java.lang.String getModuleWeaponMode() {
		return moduleWeaponMode;
	}
	
	public DBPilotModulesListBean setModuleWeaponMode(java.lang.String value) {
		this.moduleWeaponMode = value;
		return this;
	}
	
	
	@DataSource({"common_module_name", "commonModuleName"})
	@DataTarget("common_module_name")
	@XMLSimple("commonModuleName")
	private java.lang.String commonModuleName;
	
	public java.lang.String getCommonModuleName() {
		return commonModuleName;
	}
	
	public DBPilotModulesListBean setCommonModuleName(java.lang.String value) {
		this.commonModuleName = value;
		return this;
	}
	
	
	@DataSource({"module_class", "moduleClass"})
	@DataTarget("module_class")
	@XMLSimple("moduleClass")
	private java.lang.Integer moduleClass;
	
	public java.lang.Integer getModuleClass() {
		return moduleClass;
	}
	
	public DBPilotModulesListBean setModuleClass(java.lang.Integer value) {
		this.moduleClass = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
	}	
	
}