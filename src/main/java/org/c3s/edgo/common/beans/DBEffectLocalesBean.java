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


public class DBEffectLocalesBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"lang_id", "langId"})
	@DataTarget("lang_id")
	@XMLSimple("langId")
	private java.lang.Long langId;
	
	public java.lang.Long getLangId() {
		return langId;
	}
	
	public DBEffectLocalesBean setLangId(java.lang.Long value) {
		this.langId = value;
		return this;
	}
	
	
	@DataSource({"effect_id", "effectId"})
	@DataTarget("effect_id")
	@XMLSimple("effectId")
	private java.lang.Long effectId;
	
	public java.lang.Long getEffectId() {
		return effectId;
	}
	
	public DBEffectLocalesBean setEffectId(java.lang.Long value) {
		this.effectId = value;
		return this;
	}
	
	
	@DataSource({"effect_locale", "effectLocale"})
	@DataTarget("effect_locale")
	@XMLSimple("effectLocale")
	private java.lang.String effectLocale;
	
	public java.lang.String getEffectLocale() {
		return effectLocale;
	}
	
	public DBEffectLocalesBean setEffectLocale(java.lang.String value) {
		this.effectLocale = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
	}	
	
}