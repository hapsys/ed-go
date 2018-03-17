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


public class DBPilotStoredModulesListBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"module_rating", "moduleRating"})
	@DataTarget("module_rating")
	@XMLSimple("moduleRating")
	private java.lang.String moduleRating;
	
	public java.lang.String getModuleRating() {
		return moduleRating;
	}
	
	public DBPilotStoredModulesListBean setModuleRating(java.lang.String value) {
		this.moduleRating = value;
		return this;
	}
	
	
	@DataSource({"module_weapon_mode", "moduleWeaponMode"})
	@DataTarget("module_weapon_mode")
	@XMLSimple("moduleWeaponMode")
	private java.lang.String moduleWeaponMode;
	
	public java.lang.String getModuleWeaponMode() {
		return moduleWeaponMode;
	}
	
	public DBPilotStoredModulesListBean setModuleWeaponMode(java.lang.String value) {
		this.moduleWeaponMode = value;
		return this;
	}
	
	
	@DataSource({"module_place", "modulePlace"})
	@DataTarget("module_place")
	@XMLSimple("modulePlace")
	private java.lang.String modulePlace;
	
	public java.lang.String getModulePlace() {
		return modulePlace;
	}
	
	public DBPilotStoredModulesListBean setModulePlace(java.lang.String value) {
		this.modulePlace = value;
		return this;
	}
	
	
	@DataSource({"recipie_grade", "recipieGrade"})
	@DataTarget("recipie_grade")
	@XMLSimple("recipieGrade")
	private java.lang.Integer recipieGrade;
	
	public java.lang.Integer getRecipieGrade() {
		return recipieGrade;
	}
	
	public DBPilotStoredModulesListBean setRecipieGrade(java.lang.Integer value) {
		this.recipieGrade = value;
		return this;
	}
	
	
	@DataSource({"module_count", "moduleCount"})
	@DataTarget("module_count")
	@XMLSimple("moduleCount")
	private java.lang.Long moduleCount;
	
	public java.lang.Long getModuleCount() {
		return moduleCount;
	}
	
	public DBPilotStoredModulesListBean setModuleCount(java.lang.Long value) {
		this.moduleCount = value;
		return this;
	}
	
	
	@DataSource({"common_module_name", "commonModuleName"})
	@DataTarget("common_module_name")
	@XMLSimple("commonModuleName")
	private java.lang.String commonModuleName;
	
	public java.lang.String getCommonModuleName() {
		return commonModuleName;
	}
	
	public DBPilotStoredModulesListBean setCommonModuleName(java.lang.String value) {
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
	
	public DBPilotStoredModulesListBean setModuleClass(java.lang.Integer value) {
		this.moduleClass = value;
		return this;
	}
	
	
	@DataSource({"recipie_name", "recipieName"})
	@DataTarget("recipie_name")
	@XMLSimple("recipieName")
	private java.lang.String recipieName;
	
	public java.lang.String getRecipieName() {
		return recipieName;
	}
	
	public DBPilotStoredModulesListBean setRecipieName(java.lang.String value) {
		this.recipieName = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
	}	
	
}