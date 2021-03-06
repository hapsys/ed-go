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


public class DBEffectsBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"effect", "effect"})
	@DataTarget("effect")
	@XMLSimple("effect")
	private java.lang.String effect;
	
	public java.lang.String getEffect() {
		return effect;
	}
	
	public DBEffectsBean setEffect(java.lang.String value) {
		this.effect = value;
		return this;
	}
	
	
	@DataSource({"effect_id", "effectId"})
	@DataTarget("effect_id")
	@XMLSimple("effectId")
	private java.lang.Long effectId;
	
	public java.lang.Long getEffectId() {
		return effectId;
	}
	
	public DBEffectsBean setEffectId(java.lang.Long value) {
		this.effectId = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
		setEffectId(new java.lang.Long(value.toString()));
		
	}	
	
}