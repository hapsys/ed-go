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


public class DBFullLastInfoBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"progress_explore", "progressExplore"})
	@DataTarget("explore")
	@XMLSimple("progressExplore")
	private java.lang.Integer progressExplore;
	
	public java.lang.Integer getProgressExplore() {
		return progressExplore;
	}
	
	public DBFullLastInfoBean setProgressExplore(java.lang.Integer value) {
		progressExplore = value;
		return this;
	}
	
	
	@DataSource({"loan", "loan"})
	@DataTarget("loan")
	@XMLSimple("loan")
	private java.math.BigInteger loan;
	
	public java.math.BigInteger getLoan() {
		return loan;
	}
	
	public DBFullLastInfoBean setLoan(java.math.BigInteger value) {
		loan = value;
		return this;
	}
	
	
	@DataSource({"last_seen", "lastSeen"})
	@DataTarget("last_seen")
	@XMLSimple("lastSeen")
	private java.lang.String lastSeen;
	
	public java.lang.String getLastSeen() {
		return lastSeen;
	}
	
	public DBFullLastInfoBean setLastSeen(java.lang.String value) {
		lastSeen = value;
		return this;
	}
	
	
	@DataSource({"combat", "combat"})
	@DataTarget("combat")
	@XMLSimple("combat")
	private java.lang.Integer combat;
	
	public java.lang.Integer getCombat() {
		return combat;
	}
	
	public DBFullLastInfoBean setCombat(java.lang.Integer value) {
		combat = value;
		return this;
	}
	
	
	@DataSource({"pilot_id", "pilotId"})
	@DataTarget("pilot_id")
	@XMLSimple("pilotId")
	private java.lang.Long pilotId;
	
	public java.lang.Long getPilotId() {
		return pilotId;
	}
	
	public DBFullLastInfoBean setPilotId(java.lang.Long value) {
		pilotId = value;
		return this;
	}
	
	
	@DataSource({"credits", "credits"})
	@DataTarget("credits")
	@XMLSimple("credits")
	private java.math.BigInteger credits;
	
	public java.math.BigInteger getCredits() {
		return credits;
	}
	
	public DBFullLastInfoBean setCredits(java.math.BigInteger value) {
		credits = value;
		return this;
	}
	
	
	@DataSource({"progress_empire", "progressEmpire"})
	@DataTarget("empire")
	@XMLSimple("progressEmpire")
	private java.lang.Integer progressEmpire;
	
	public java.lang.Integer getProgressEmpire() {
		return progressEmpire;
	}
	
	public DBFullLastInfoBean setProgressEmpire(java.lang.Integer value) {
		progressEmpire = value;
		return this;
	}
	
	
	@DataSource({"empire", "empire"})
	@DataTarget("empire")
	@XMLSimple("empire")
	private java.lang.Integer empire;
	
	public java.lang.Integer getEmpire() {
		return empire;
	}
	
	public DBFullLastInfoBean setEmpire(java.lang.Integer value) {
		empire = value;
		return this;
	}
	
	
	@DataSource({"body_id", "bodyId"})
	@DataTarget("body_id")
	@XMLSimple("bodyId")
	private java.math.BigInteger bodyId;
	
	public java.math.BigInteger getBodyId() {
		return bodyId;
	}
	
	public DBFullLastInfoBean setBodyId(java.math.BigInteger value) {
		bodyId = value;
		return this;
	}
	
	
	@DataSource({"game_group", "gameGroup"})
	@DataTarget("game_group")
	@XMLSimple("gameGroup")
	private java.lang.String gameGroup;
	
	public java.lang.String getGameGroup() {
		return gameGroup;
	}
	
	public DBFullLastInfoBean setGameGroup(java.lang.String value) {
		gameGroup = value;
		return this;
	}
	
	
	@DataSource({"federation", "federation"})
	@DataTarget("federation")
	@XMLSimple("federation")
	private java.lang.Integer federation;
	
	public java.lang.Integer getFederation() {
		return federation;
	}
	
	public DBFullLastInfoBean setFederation(java.lang.Integer value) {
		federation = value;
		return this;
	}
	
	
	@DataSource({"station_name", "stationName"})
	@DataTarget("name")
	@XMLSimple("stationName")
	private java.lang.String stationName;
	
	public java.lang.String getStationName() {
		return stationName;
	}
	
	public DBFullLastInfoBean setStationName(java.lang.String value) {
		stationName = value;
		return this;
	}
	
	
	@DataSource({"explore", "explore"})
	@DataTarget("explore")
	@XMLSimple("explore")
	private java.lang.Integer explore;
	
	public java.lang.Integer getExplore() {
		return explore;
	}
	
	public DBFullLastInfoBean setExplore(java.lang.Integer value) {
		explore = value;
		return this;
	}
	
	
	@DataSource({"body_name", "bodyName"})
	@DataTarget("body_name")
	@XMLSimple("bodyName")
	private java.lang.String bodyName;
	
	public java.lang.String getBodyName() {
		return bodyName;
	}
	
	public DBFullLastInfoBean setBodyName(java.lang.String value) {
		bodyName = value;
		return this;
	}
	
	
	@DataSource({"mode_start", "modeStart"})
	@DataTarget("mode_start")
	@XMLSimple("modeStart")
	private java.sql.Timestamp modeStart;
	
	public java.sql.Timestamp getModeStart() {
		return modeStart;
	}
	
	public DBFullLastInfoBean setModeStart(java.sql.Timestamp value) {
		modeStart = value;
		return this;
	}
	
	
	@DataSource({"system_id", "systemId"})
	@DataTarget("system_id")
	@XMLSimple("systemId")
	private java.math.BigInteger systemId;
	
	public java.math.BigInteger getSystemId() {
		return systemId;
	}
	
	public DBFullLastInfoBean setSystemId(java.math.BigInteger value) {
		systemId = value;
		return this;
	}
	
	
	@DataSource({"system_name", "systemName"})
	@DataTarget("name")
	@XMLSimple("systemName")
	private java.lang.String systemName;
	
	public java.lang.String getSystemName() {
		return systemName;
	}
	
	public DBFullLastInfoBean setSystemName(java.lang.String value) {
		systemName = value;
		return this;
	}
	
	
	@DataSource({"station_id", "stationId"})
	@DataTarget("station_id")
	@XMLSimple("stationId")
	private java.lang.Long stationId;
	
	public java.lang.Long getStationId() {
		return stationId;
	}
	
	public DBFullLastInfoBean setStationId(java.lang.Long value) {
		stationId = value;
		return this;
	}
	
	
	@DataSource({"progress_cqc", "progressCqc"})
	@DataTarget("cqc")
	@XMLSimple("progressCqc")
	private java.lang.Integer progressCqc;
	
	public java.lang.Integer getProgressCqc() {
		return progressCqc;
	}
	
	public DBFullLastInfoBean setProgressCqc(java.lang.Integer value) {
		progressCqc = value;
		return this;
	}
	
	
	@DataSource({"quered_events", "queredEvents"})
	@DataTarget("quered_events")
	@XMLSimple("queredEvents")
	private java.lang.Long queredEvents;
	
	public java.lang.Long getQueredEvents() {
		return queredEvents;
	}
	
	public DBFullLastInfoBean setQueredEvents(java.lang.Long value) {
		queredEvents = value;
		return this;
	}
	
	
	@DataSource({"mode_end", "modeEnd"})
	@DataTarget("mode_end")
	@XMLSimple("modeEnd")
	private java.sql.Timestamp modeEnd;
	
	public java.sql.Timestamp getModeEnd() {
		return modeEnd;
	}
	
	public DBFullLastInfoBean setModeEnd(java.sql.Timestamp value) {
		modeEnd = value;
		return this;
	}
	
	
	@DataSource({"progress_federation", "progressFederation"})
	@DataTarget("federation")
	@XMLSimple("progressFederation")
	private java.lang.Integer progressFederation;
	
	public java.lang.Integer getProgressFederation() {
		return progressFederation;
	}
	
	public DBFullLastInfoBean setProgressFederation(java.lang.Integer value) {
		progressFederation = value;
		return this;
	}
	
	
	@DataSource({"fly_mode", "flyMode"})
	@DataTarget("fly_mode")
	@XMLSimple("flyMode")
	private java.lang.String flyMode;
	
	public java.lang.String getFlyMode() {
		return flyMode;
	}
	
	public DBFullLastInfoBean setFlyMode(java.lang.String value) {
		flyMode = value;
		return this;
	}
	
	
	@DataSource({"trade", "trade"})
	@DataTarget("trade")
	@XMLSimple("trade")
	private java.lang.Integer trade;
	
	public java.lang.Integer getTrade() {
		return trade;
	}
	
	public DBFullLastInfoBean setTrade(java.lang.Integer value) {
		trade = value;
		return this;
	}
	
	
	@DataSource({"pilot_game_mode_id", "pilotGameModeId"})
	@DataTarget("pilot_game_mode_id")
	@XMLSimple("pilotGameModeId")
	private java.math.BigInteger pilotGameModeId;
	
	public java.math.BigInteger getPilotGameModeId() {
		return pilotGameModeId;
	}
	
	public DBFullLastInfoBean setPilotGameModeId(java.math.BigInteger value) {
		pilotGameModeId = value;
		return this;
	}
	
	
	@DataSource({"cqc", "cqc"})
	@DataTarget("cqc")
	@XMLSimple("cqc")
	private java.lang.Integer cqc;
	
	public java.lang.Integer getCqc() {
		return cqc;
	}
	
	public DBFullLastInfoBean setCqc(java.lang.Integer value) {
		cqc = value;
		return this;
	}
	
	
	@DataSource({"progress_combat", "progressCombat"})
	@DataTarget("combat")
	@XMLSimple("progressCombat")
	private java.lang.Integer progressCombat;
	
	public java.lang.Integer getProgressCombat() {
		return progressCombat;
	}
	
	public DBFullLastInfoBean setProgressCombat(java.lang.Integer value) {
		progressCombat = value;
		return this;
	}
	
	
	@DataSource({"last_event", "lastEvent"})
	@DataTarget("last_event")
	@XMLSimple("lastEvent")
	private java.lang.Long lastEvent;
	
	public java.lang.Long getLastEvent() {
		return lastEvent;
	}
	
	public DBFullLastInfoBean setLastEvent(java.lang.Long value) {
		lastEvent = value;
		return this;
	}
	
	
	@DataSource({"game_mode", "gameMode"})
	@DataTarget("game_mode")
	@XMLSimple("gameMode")
	private java.lang.String gameMode;
	
	public java.lang.String getGameMode() {
		return gameMode;
	}
	
	public DBFullLastInfoBean setGameMode(java.lang.String value) {
		gameMode = value;
		return this;
	}
	
	
	@DataSource({"event_name", "eventName"})
	@DataTarget("event_name")
	@XMLSimple("eventName")
	private java.lang.String eventName;
	
	public java.lang.String getEventName() {
		return eventName;
	}
	
	public DBFullLastInfoBean setEventName(java.lang.String value) {
		eventName = value;
		return this;
	}
	
	
	@DataSource({"progress_trade", "progressTrade"})
	@DataTarget("trade")
	@XMLSimple("progressTrade")
	private java.lang.Integer progressTrade;
	
	public java.lang.Integer getProgressTrade() {
		return progressTrade;
	}
	
	public DBFullLastInfoBean setProgressTrade(java.lang.Integer value) {
		progressTrade = value;
		return this;
	}
	
	
	@DataSource({"is_supercruise", "isSupercruise"})
	@DataTarget("is_supercruise")
	@XMLSimple("isSupercruise")
	private java.lang.Integer isSupercruise;
	
	public java.lang.Integer getIsSupercruise() {
		return isSupercruise;
	}
	
	public DBFullLastInfoBean setIsSupercruise(java.lang.Integer value) {
		isSupercruise = value;
		return this;
	}
	
	
	@DataSource({"game_mode_id", "gameModeId"})
	@DataTarget("game_mode_id")
	@XMLSimple("gameModeId")
	private java.lang.Long gameModeId;
	
	public java.lang.Long getGameModeId() {
		return gameModeId;
	}
	
	public DBFullLastInfoBean setGameModeId(java.lang.Long value) {
		gameModeId = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
		setPilotGameModeId(new java.math.BigInteger(value.toString()));
		
		setGameModeId(new java.lang.Long(value.toString()));
		
	}	
	
}