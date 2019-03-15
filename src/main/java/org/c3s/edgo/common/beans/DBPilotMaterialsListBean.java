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


public class DBPilotMaterialsListBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"update_time", "updateTime"})
	@DataTarget("update_time")
	@XMLSimple("updateTime")
	private java.lang.Long updateTime;
	
	public java.lang.Long getUpdateTime() {
		return updateTime;
	}
	
	public DBPilotMaterialsListBean setUpdateTime(java.lang.Long value) {
		this.updateTime = value;
		return this;
	}
	
	
	@DataSource({"quantity", "quantity"})
	@DataTarget("quantity")
	@XMLSimple("quantity")
	private java.lang.Integer quantity;
	
	public java.lang.Integer getQuantity() {
		return quantity;
	}
	
	public DBPilotMaterialsListBean setQuantity(java.lang.Integer value) {
		this.quantity = value;
		return this;
	}
	
	
	@DataSource({"matherial_category_id", "matherialCategoryId"})
	@DataTarget("matherial_category_id")
	@XMLSimple("matherialCategoryId")
	private java.lang.Long matherialCategoryId;
	
	public java.lang.Long getMatherialCategoryId() {
		return matherialCategoryId;
	}
	
	public DBPilotMaterialsListBean setMatherialCategoryId(java.lang.Long value) {
		this.matherialCategoryId = value;
		return this;
	}
	
	
	@DataSource({"material_max", "materialMax"})
	@DataTarget("material_max")
	@XMLSimple("materialMax")
	private java.lang.Long materialMax;
	
	public java.lang.Long getMaterialMax() {
		return materialMax;
	}
	
	public DBPilotMaterialsListBean setMaterialMax(java.lang.Long value) {
		this.materialMax = value;
		return this;
	}
	
	
	@DataSource({"localized", "localized"})
	@DataTarget("localized")
	@XMLSimple("localized")
	private java.lang.String localized;
	
	public java.lang.String getLocalized() {
		return localized;
	}
	
	public DBPilotMaterialsListBean setLocalized(java.lang.String value) {
		this.localized = value;
		return this;
	}
	
	
	@DataSource({"material_id", "materialId"})
	@DataTarget("material_id")
	@XMLSimple("materialId")
	private java.lang.Long materialId;
	
	public java.lang.Long getMaterialId() {
		return materialId;
	}
	
	public DBPilotMaterialsListBean setMaterialId(java.lang.Long value) {
		this.materialId = value;
		return this;
	}
	
	
	@DataSource({"material_category_id", "materialCategoryId"})
	@DataTarget("material_category_id")
	@XMLSimple("materialCategoryId")
	private java.lang.Long materialCategoryId;
	
	public java.lang.Long getMaterialCategoryId() {
		return materialCategoryId;
	}
	
	public DBPilotMaterialsListBean setMaterialCategoryId(java.lang.Long value) {
		this.materialCategoryId = value;
		return this;
	}
	
	
	@DataSource({"material_uniq", "materialUniq"})
	@DataTarget("material_uniq")
	@XMLSimple("materialUniq")
	private java.lang.String materialUniq;
	
	public java.lang.String getMaterialUniq() {
		return materialUniq;
	}
	
	public DBPilotMaterialsListBean setMaterialUniq(java.lang.String value) {
		this.materialUniq = value;
		return this;
	}
	
	
	@DataSource({"used", "used"})
	@DataTarget("used")
	@XMLSimple("used")
	private java.lang.Long used;
	
	public java.lang.Long getUsed() {
		return used;
	}
	
	public DBPilotMaterialsListBean setUsed(java.lang.Long value) {
		this.used = value;
		return this;
	}
	
	
	@DataSource({"material_grade", "materialGrade"})
	@DataTarget("material_grade")
	@XMLSimple("materialGrade")
	private java.lang.Integer materialGrade;
	
	public java.lang.Integer getMaterialGrade() {
		return materialGrade;
	}
	
	public DBPilotMaterialsListBean setMaterialGrade(java.lang.Integer value) {
		this.materialGrade = value;
		return this;
	}
	
	
	@DataSource({"material_category_name", "materialCategoryName"})
	@DataTarget("material_category_name")
	@XMLSimple("materialCategoryName")
	private java.lang.String materialCategoryName;
	
	public java.lang.String getMaterialCategoryName() {
		return materialCategoryName;
	}
	
	public DBPilotMaterialsListBean setMaterialCategoryName(java.lang.String value) {
		this.materialCategoryName = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
		setMaterialId(new java.lang.Long(value.toString()));
		
		setMaterialCategoryId(new java.lang.Long(value.toString()));
		
	}	
	
}