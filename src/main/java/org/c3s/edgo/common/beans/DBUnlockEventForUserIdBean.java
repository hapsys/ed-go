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


public class DBUnlockEventForUserIdBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"check_hash", "checkHash"})
	@DataTarget("check_hash")
	@XMLSimple("checkHash")
	private java.lang.String checkHash;
	
	public java.lang.String getCheckHash() {
		return checkHash;
	}
	
	public DBUnlockEventForUserIdBean setCheckHash(java.lang.String value) {
		this.checkHash = value;
		return this;
	}
	
	
	@DataSource({"is_locked", "isLocked"})
	@DataTarget("is_locked")
	@XMLSimple("isLocked")
	private java.lang.Integer isLocked;
	
	public java.lang.Integer getIsLocked() {
		return isLocked;
	}
	
	public DBUnlockEventForUserIdBean setIsLocked(java.lang.Integer value) {
		this.isLocked = value;
		return this;
	}
	
	
	@DataSource({"event_id", "eventId"})
	@DataTarget("event_id")
	@XMLSimple("eventId")
	private java.math.BigInteger eventId;
	
	public java.math.BigInteger getEventId() {
		return eventId;
	}
	
	public DBUnlockEventForUserIdBean setEventId(java.math.BigInteger value) {
		this.eventId = value;
		return this;
	}
	
	
	@DataSource({"user_id", "userId"})
	@DataTarget("user_id")
	@XMLSimple("userId")
	private java.lang.Long userId;
	
	public java.lang.Long getUserId() {
		return userId;
	}
	
	public DBUnlockEventForUserIdBean setUserId(java.lang.Long value) {
		this.userId = value;
		return this;
	}
	
	
	@DataSource({"event_name", "eventName"})
	@DataTarget("event_name")
	@XMLSimple("eventName")
	private java.lang.String eventName;
	
	public java.lang.String getEventName() {
		return eventName;
	}
	
	public DBUnlockEventForUserIdBean setEventName(java.lang.String value) {
		this.eventName = value;
		return this;
	}
	
	
	@DataSource({"json_md5", "jsonMd5"})
	@DataTarget("json_md5")
	@XMLSimple("jsonMd5")
	private java.lang.String jsonMd5;
	
	public java.lang.String getJsonMd5() {
		return jsonMd5;
	}
	
	public DBUnlockEventForUserIdBean setJsonMd5(java.lang.String value) {
		this.jsonMd5 = value;
		return this;
	}
	
	
	@DataSource({"event_json", "eventJson"})
	@DataTarget("event_json")
	@XMLSimple("eventJson")
	private java.lang.String eventJson;
	
	public java.lang.String getEventJson() {
		return eventJson;
	}
	
	public DBUnlockEventForUserIdBean setEventJson(java.lang.String value) {
		this.eventJson = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
	}	
	
}