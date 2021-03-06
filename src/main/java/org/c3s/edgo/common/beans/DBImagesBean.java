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


public class DBImagesBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"decription", "decription"})
	@DataTarget("decription")
	@XMLSimple("decription")
	private java.lang.String decription;
	
	public java.lang.String getDecription() {
		return decription;
	}
	
	public DBImagesBean setDecription(java.lang.String value) {
		this.decription = value;
		return this;
	}
	
	
	@DataSource({"is_active", "isActive"})
	@DataTarget("is_active")
	@XMLSimple("isActive")
	private java.lang.Integer isActive;
	
	public java.lang.Integer getIsActive() {
		return isActive;
	}
	
	public DBImagesBean setIsActive(java.lang.Integer value) {
		this.isActive = value;
		return this;
	}
	
	
	@DataSource({"create_time", "createTime"})
	@DataTarget("create_time")
	@XMLSimple("createTime")
	private java.sql.Timestamp createTime;
	
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}
	
	public DBImagesBean setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
		return this;
	}
	
	
	@DataSource({"station_history_id", "stationHistoryId"})
	@DataTarget("station_history_id")
	@XMLSimple("stationHistoryId")
	private java.math.BigInteger stationHistoryId;
	
	public java.math.BigInteger getStationHistoryId() {
		return stationHistoryId;
	}
	
	public DBImagesBean setStationHistoryId(java.math.BigInteger value) {
		this.stationHistoryId = value;
		return this;
	}
	
	
	@DataSource({"width", "width"})
	@DataTarget("width")
	@XMLSimple("width")
	private java.lang.Long width;
	
	public java.lang.Long getWidth() {
		return width;
	}
	
	public DBImagesBean setWidth(java.lang.Long value) {
		this.width = value;
		return this;
	}
	
	
	@DataSource({"image_id", "imageId"})
	@DataTarget("image_id")
	@XMLSimple("imageId")
	private java.lang.Long imageId;
	
	public java.lang.Long getImageId() {
		return imageId;
	}
	
	public DBImagesBean setImageId(java.lang.Long value) {
		this.imageId = value;
		return this;
	}
	
	
	@DataSource({"type", "type"})
	@DataTarget("type")
	@XMLSimple("type")
	private java.lang.String type;
	
	public java.lang.String getType() {
		return type;
	}
	
	public DBImagesBean setType(java.lang.String value) {
		this.type = value;
		return this;
	}
	
	
	@DataSource({"pilot_id", "pilotId"})
	@DataTarget("pilot_id")
	@XMLSimple("pilotId")
	private java.lang.Long pilotId;
	
	public java.lang.Long getPilotId() {
		return pilotId;
	}
	
	public DBImagesBean setPilotId(java.lang.Long value) {
		this.pilotId = value;
		return this;
	}
	
	
	@DataSource({"location_id", "locationId"})
	@DataTarget("location_id")
	@XMLSimple("locationId")
	private java.math.BigInteger locationId;
	
	public java.math.BigInteger getLocationId() {
		return locationId;
	}
	
	public DBImagesBean setLocationId(java.math.BigInteger value) {
		this.locationId = value;
		return this;
	}
	
	
	@DataSource({"height", "height"})
	@DataTarget("height")
	@XMLSimple("height")
	private java.lang.Long height;
	
	public java.lang.Long getHeight() {
		return height;
	}
	
	public DBImagesBean setHeight(java.lang.Long value) {
		this.height = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
		setImageId(new java.lang.Long(value.toString()));
		
	}	
	
}