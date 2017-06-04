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


public class DBUserLevelsBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"user_id", "userId"})
	@DataTarget("user_id")
	@XMLSimple("userId")
	private Long userId;
	
	public Long getUserId() {
		return userId;
	}
	
	public DBUserLevelsBean setUserId(Long value) {
		userId = value;
		return this;
	}
	
	
	@DataSource({"info_id", "infoId"})
	@DataTarget("info_id")
	@XMLSimple("infoId")
	private Long infoId;
	
	public Long getInfoId() {
		return infoId;
	}
	
	public DBUserLevelsBean setInfoId(Long value) {
		infoId = value;
		return this;
	}
	
	
	@DataSource({"relate_to", "relateTo"})
	@DataTarget("relate_to")
	@XMLSimple("relateTo")
	private String relateTo;
	
	public String getRelateTo() {
		return relateTo;
	}
	
	public DBUserLevelsBean setRelateTo(String value) {
		relateTo = value;
		return this;
	}
	
	
	@DataSource({"mask", "mask"})
	@DataTarget("mask")
	@XMLSimple("mask")
	private Long mask;
	
	public Long getMask() {
		return mask;
	}
	
	public DBUserLevelsBean setMask(Long value) {
		mask = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
	}	
	
}