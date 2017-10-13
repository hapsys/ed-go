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


public class DBShipSlotsByShipUniqBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"slot_order", "slotOrder"})
	@DataTarget("slot_order")
	@XMLSimple("slotOrder")
	private java.lang.Integer slotOrder;
	
	public java.lang.Integer getSlotOrder() {
		return slotOrder;
	}
	
	public DBShipSlotsByShipUniqBean setSlotOrder(java.lang.Integer value) {
		this.slotOrder = value;
		return this;
	}
	
	
	@DataSource({"size", "size"})
	@DataTarget("size")
	@XMLSimple("size")
	private java.lang.Integer size;
	
	public java.lang.Integer getSize() {
		return size;
	}
	
	public DBShipSlotsByShipUniqBean setSize(java.lang.Integer value) {
		this.size = value;
		return this;
	}
	
	
	@DataSource({"used_count", "usedCount"})
	@DataTarget("used_count")
	@XMLSimple("usedCount")
	private java.lang.Long usedCount;
	
	public java.lang.Long getUsedCount() {
		return usedCount;
	}
	
	public DBShipSlotsByShipUniqBean setUsedCount(java.lang.Long value) {
		this.usedCount = value;
		return this;
	}
	
	
	@DataSource({"slot_id", "slotId"})
	@DataTarget("slot_id")
	@XMLSimple("slotId")
	private java.lang.Long slotId;
	
	public java.lang.Long getSlotId() {
		return slotId;
	}
	
	public DBShipSlotsByShipUniqBean setSlotId(java.lang.Long value) {
		this.slotId = value;
		return this;
	}
	
	
	@DataSource({"slot_uniq", "slotUniq"})
	@DataTarget("slot_uniq")
	@XMLSimple("slotUniq")
	private java.lang.String slotUniq;
	
	public java.lang.String getSlotUniq() {
		return slotUniq;
	}
	
	public DBShipSlotsByShipUniqBean setSlotUniq(java.lang.String value) {
		this.slotUniq = value;
		return this;
	}
	
	
	@DataSource({"slot_type_id", "slotTypeId"})
	@DataTarget("slot_type_id")
	@XMLSimple("slotTypeId")
	private java.lang.Long slotTypeId;
	
	public java.lang.Long getSlotTypeId() {
		return slotTypeId;
	}
	
	public DBShipSlotsByShipUniqBean setSlotTypeId(java.lang.Long value) {
		this.slotTypeId = value;
		return this;
	}
	
	
	@DataSource({"link_size", "linkSize"})
	@DataTarget("link_size")
	@XMLSimple("linkSize")
	private java.lang.String linkSize;
	
	public java.lang.String getLinkSize() {
		return linkSize;
	}
	
	public DBShipSlotsByShipUniqBean setLinkSize(java.lang.String value) {
		this.linkSize = value;
		return this;
	}
	
	
	@DataSource({"slot_type_name", "slotTypeName"})
	@DataTarget("slot_type_name")
	@XMLSimple("slotTypeName")
	private java.lang.String slotTypeName;
	
	public java.lang.String getSlotTypeName() {
		return slotTypeName;
	}
	
	public DBShipSlotsByShipUniqBean setSlotTypeName(java.lang.String value) {
		this.slotTypeName = value;
		return this;
	}
	
	
	@DataSource({"modules", "modules"})
	@DataTarget("modules")
	@XMLSimple("modules")
	private java.lang.String modules;
	
	public java.lang.String getModules() {
		return modules;
	}
	
	public DBShipSlotsByShipUniqBean setModules(java.lang.String value) {
		this.modules = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
		setSlotId(new java.lang.Long(value.toString()));
		
		setSlotTypeId(new java.lang.Long(value.toString()));
		
	}	
	
}