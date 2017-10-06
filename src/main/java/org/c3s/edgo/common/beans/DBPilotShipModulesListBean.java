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


public class DBPilotShipModulesListBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"pilot_ship_id", "pilotShipId"})
	@DataTarget("pilot_ship_id")
	@XMLSimple("pilotShipId")
	private java.lang.Long pilotShipId;
	
	public java.lang.Long getPilotShipId() {
		return pilotShipId;
	}
	
	public DBPilotShipModulesListBean setPilotShipId(java.lang.Long value) {
		pilotShipId = value;
		return this;
	}
	
	
	@DataSource({"module_rating", "moduleRating"})
	@DataTarget("module_rating")
	@XMLSimple("moduleRating")
	private java.lang.String moduleRating;
	
	public java.lang.String getModuleRating() {
		return moduleRating;
	}
	
	public DBPilotShipModulesListBean setModuleRating(java.lang.String value) {
		moduleRating = value;
		return this;
	}
	
	
	@DataSource({"slot_type_id", "slotTypeId"})
	@DataTarget("slot_type_id")
	@XMLSimple("slotTypeId")
	private java.lang.Long slotTypeId;
	
	public java.lang.Long getSlotTypeId() {
		return slotTypeId;
	}
	
	public DBPilotShipModulesListBean setSlotTypeId(java.lang.Long value) {
		slotTypeId = value;
		return this;
	}
	
	
	@DataSource({"link_size", "linkSize"})
	@DataTarget("link_size")
	@XMLSimple("linkSize")
	private java.lang.String linkSize;
	
	public java.lang.String getLinkSize() {
		return linkSize;
	}
	
	public DBPilotShipModulesListBean setLinkSize(java.lang.String value) {
		linkSize = value;
		return this;
	}
	
	
	@DataSource({"slot_type_name", "slotTypeName"})
	@DataTarget("slot_type_name")
	@XMLSimple("slotTypeName")
	private java.lang.String slotTypeName;
	
	public java.lang.String getSlotTypeName() {
		return slotTypeName;
	}
	
	public DBPilotShipModulesListBean setSlotTypeName(java.lang.String value) {
		slotTypeName = value;
		return this;
	}
	
	
	@DataSource({"module_group_id", "moduleGroupId"})
	@DataTarget("module_group_id")
	@XMLSimple("moduleGroupId")
	private java.lang.Long moduleGroupId;
	
	public java.lang.Long getModuleGroupId() {
		return moduleGroupId;
	}
	
	public DBPilotShipModulesListBean setModuleGroupId(java.lang.Long value) {
		moduleGroupId = value;
		return this;
	}
	
	
	@DataSource({"module_group_name", "moduleGroupName"})
	@DataTarget("module_group_name")
	@XMLSimple("moduleGroupName")
	private java.lang.String moduleGroupName;
	
	public java.lang.String getModuleGroupName() {
		return moduleGroupName;
	}
	
	public DBPilotShipModulesListBean setModuleGroupName(java.lang.String value) {
		moduleGroupName = value;
		return this;
	}
	
	
	@DataSource({"module_id", "moduleId"})
	@DataTarget("module_id")
	@XMLSimple("moduleId")
	private java.lang.Long moduleId;
	
	public java.lang.Long getModuleId() {
		return moduleId;
	}
	
	public DBPilotShipModulesListBean setModuleId(java.lang.Long value) {
		moduleId = value;
		return this;
	}
	
	
	@DataSource({"module_weapon_mode", "moduleWeaponMode"})
	@DataTarget("module_weapon_mode")
	@XMLSimple("moduleWeaponMode")
	private java.lang.String moduleWeaponMode;
	
	public java.lang.String getModuleWeaponMode() {
		return moduleWeaponMode;
	}
	
	public DBPilotShipModulesListBean setModuleWeaponMode(java.lang.String value) {
		moduleWeaponMode = value;
		return this;
	}
	
	
	@DataSource({"slot_uniq", "slotUniq"})
	@DataTarget("slot_uniq")
	@XMLSimple("slotUniq")
	private java.lang.String slotUniq;
	
	public java.lang.String getSlotUniq() {
		return slotUniq;
	}
	
	public DBPilotShipModulesListBean setSlotUniq(java.lang.String value) {
		slotUniq = value;
		return this;
	}
	
	
	@DataSource({"module_name", "moduleName"})
	@DataTarget("module_name")
	@XMLSimple("moduleName")
	private java.lang.String moduleName;
	
	public java.lang.String getModuleName() {
		return moduleName;
	}
	
	public DBPilotShipModulesListBean setModuleName(java.lang.String value) {
		moduleName = value;
		return this;
	}
	
	
	@DataSource({"ship_name", "shipName"})
	@DataTarget("ship_name")
	@XMLSimple("shipName")
	private java.lang.String shipName;
	
	public java.lang.String getShipName() {
		return shipName;
	}
	
	public DBPilotShipModulesListBean setShipName(java.lang.String value) {
		shipName = value;
		return this;
	}
	
	
	@DataSource({"module_uniq", "moduleUniq"})
	@DataTarget("module_uniq")
	@XMLSimple("moduleUniq")
	private java.lang.String moduleUniq;
	
	public java.lang.String getModuleUniq() {
		return moduleUniq;
	}
	
	public DBPilotShipModulesListBean setModuleUniq(java.lang.String value) {
		moduleUniq = value;
		return this;
	}
	
	
	@DataSource({"module_class", "moduleClass"})
	@DataTarget("module_class")
	@XMLSimple("moduleClass")
	private java.lang.Integer moduleClass;
	
	public java.lang.Integer getModuleClass() {
		return moduleClass;
	}
	
	public DBPilotShipModulesListBean setModuleClass(java.lang.Integer value) {
		moduleClass = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
		setPilotShipId(new java.lang.Long(value.toString()));
		
	}	
	
}