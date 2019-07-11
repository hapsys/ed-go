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


public class DBLastActivityTimeBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"hours", "hours"})
	@DataTarget("hours")
	@XMLSimple("hours")
	private java.lang.Long hours;
	
	public java.lang.Long getHours() {
		return hours;
	}
	
	public DBLastActivityTimeBean setHours(java.lang.Long value) {
		this.hours = value;
		return this;
	}
	
	
	@DataSource({"seconds", "seconds"})
	@DataTarget("seconds")
	@XMLSimple("seconds")
	private java.lang.Long seconds;
	
	public java.lang.Long getSeconds() {
		return seconds;
	}
	
	public DBLastActivityTimeBean setSeconds(java.lang.Long value) {
		this.seconds = value;
		return this;
	}
	
	
	@DataSource({"year", "year"})
	@DataTarget("year")
	@XMLSimple("year")
	private java.math.BigInteger year;
	
	public java.math.BigInteger getYear() {
		return year;
	}
	
	public DBLastActivityTimeBean setYear(java.math.BigInteger value) {
		this.year = value;
		return this;
	}
	
	
	@DataSource({"minutes", "minutes"})
	@DataTarget("minutes")
	@XMLSimple("minutes")
	private java.lang.Long minutes;
	
	public java.lang.Long getMinutes() {
		return minutes;
	}
	
	public DBLastActivityTimeBean setMinutes(java.lang.Long value) {
		this.minutes = value;
		return this;
	}
	
	
	@DataSource({"event_date", "eventDate"})
	@DataTarget("event_date")
	@XMLSimple("eventDate")
	private java.lang.String eventDate;
	
	public java.lang.String getEventDate() {
		return eventDate;
	}
	
	public DBLastActivityTimeBean setEventDate(java.lang.String value) {
		this.eventDate = value;
		return this;
	}
	
	
	@DataSource({"days", "days"})
	@DataTarget("days")
	@XMLSimple("days")
	private java.lang.Long days;
	
	public java.lang.Long getDays() {
		return days;
	}
	
	public DBLastActivityTimeBean setDays(java.lang.Long value) {
		this.days = value;
		return this;
	}
	
	
	@DataSource({"monthes", "monthes"})
	@DataTarget("monthes")
	@XMLSimple("monthes")
	private java.lang.Long monthes;
	
	public java.lang.Long getMonthes() {
		return monthes;
	}
	
	public DBLastActivityTimeBean setMonthes(java.lang.Long value) {
		this.monthes = value;
		return this;
	}
	
	
	@DataSource({"event_timestamp", "eventTimestamp"})
	@DataTarget("event_timestamp")
	@XMLSimple("eventTimestamp")
	private java.sql.Timestamp eventTimestamp;
	
	public java.sql.Timestamp getEventTimestamp() {
		return eventTimestamp;
	}
	
	public DBLastActivityTimeBean setEventTimestamp(java.sql.Timestamp value) {
		this.eventTimestamp = value;
		return this;
	}
	
	
	@DataSource({"event_time", "eventTime"})
	@DataTarget("event_time")
	@XMLSimple("eventTime")
	private java.lang.String eventTime;
	
	public java.lang.String getEventTime() {
		return eventTime;
	}
	
	public DBLastActivityTimeBean setEventTime(java.lang.String value) {
		this.eventTime = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
	}	
	
}