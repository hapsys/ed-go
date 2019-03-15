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


public class DBPilotsRelationsBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"is_me", "isMe"})
	@DataTarget("is_me")
	@XMLSimple("isMe")
	private java.lang.Integer isMe;
	
	public java.lang.Integer getIsMe() {
		return isMe;
	}
	
	public DBPilotsRelationsBean setIsMe(java.lang.Integer value) {
		this.isMe = value;
		return this;
	}
	
	
	@DataSource({"relation", "relation"})
	@DataTarget("relation")
	@XMLSimple("relation")
	private java.math.BigDecimal relation;
	
	public java.math.BigDecimal getRelation() {
		return relation;
	}
	
	public DBPilotsRelationsBean setRelation(java.math.BigDecimal value) {
		this.relation = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
	}	
	
}