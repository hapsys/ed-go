package org.c3s.edgo.common.dao;

import java.math.BigInteger;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBBgsStatesBean;
import org.c3s.edgo.common.beans.DBBodiesBean;
import org.c3s.edgo.common.beans.DBBodyTypesBean;
import org.c3s.edgo.common.beans.DBFactionsBean;
import org.c3s.edgo.common.beans.DBLastSystemFactionStateBean;
import org.c3s.edgo.common.beans.DBStationFactionControlBean;
import org.c3s.edgo.common.beans.DBStationsBean;
import org.c3s.edgo.common.beans.DBSystemFactionControlBean;
import org.c3s.edgo.common.beans.DBSystemFactionsHistoryBean;
import org.c3s.edgo.common.beans.DBSystemsBean;
import org.c3s.edgo.event.impl.beans.intl.FactionBean;
import org.c3s.edgo.utils.EDUtils;

public class SystemsDAO {

	public static DBSystemsBean getOrInsertSystem(String system, Float[] coord) {
		try {
			String sysuniq = EDUtils.getSystemUniq(system);
			
			DBSystemsBean starSystem = DbAccess.systemsAccess.getByUniq(sysuniq);
			
			if (starSystem == null) {
				starSystem = new DBSystemsBean();
				starSystem.setName(system);
				if (coord != null && coord.length == 3) {
					starSystem.setX(new Double(coord[0]));
					starSystem.setY(new Double(coord[1]));
					starSystem.setZ(new Double(coord[2]));
				}
				starSystem.setIsPopulated(0);
				starSystem.setNameUniq(sysuniq);
				starSystem.setSystemId(BigInteger.valueOf(System.nanoTime()));
				DbAccess.systemsAccess.insert(starSystem);
			}
			return starSystem;
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static DBStationsBean getStation(String station, BigInteger systemId) {
		DBStationsBean result = null;
		try {
			String stauniq = EDUtils.getStationUniq(station);
			result = DbAccess.stationsAccess.getByUniqAndSystemId(stauniq, systemId);
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	
	public static DBFactionsBean getOrInsertFaction(String faction) {
		return getOrInsertFaction(faction, null, null);
	}
	public static DBFactionsBean getOrInsertFaction(String faction, String government, String allegiance) {
		try {
			String uniq = EDUtils.getFactionUniq(faction);
			DBFactionsBean bean = DbAccess.factionsAccess.getByUniq(uniq);
			if (bean == null) {
				bean = new DBFactionsBean();
				bean.setName(faction);
				bean.setUniq(uniq);
				bean.setGovernment(government);
				bean.setAllegiance(allegiance);
				DbAccess.factionsAccess.insert(bean);
			}
			return bean;
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static DBFactionsBean getFaction(String faction) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		String uniq = EDUtils.getFactionUniq(faction);
		DBFactionsBean bean = DbAccess.factionsAccess.getByUniq(uniq);
		return bean;
	}
	
	
	public static DBBodiesBean getOrInsertBody(BigInteger systemId, String body, String bodyType) {
		try {
			String uniq = EDUtils.getBodyUniq(body);
			DBBodiesBean bean = DbAccess.bodiesAccess.getByUniq(uniq);
			if (bean == null) {
				bean = new DBBodiesBean();
				bean.setBodyName(body);
				bean.setBodyUniq(uniq);
				bean.setSystemId(systemId);
				bean.setBodyId(BigInteger.valueOf(System.nanoTime()));
				if (bodyType != null && !bodyType.toLowerCase().equals("null")) {
					bean.setBodyTypeId(getOrInsertBodyType(bodyType).getBodyTypeId());
				}
				DbAccess.bodiesAccess.insert(bean);
			}
			return bean;
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static DBBodyTypesBean getOrInsertBodyType(String name) {
		try {
			String uniq = EDUtils.cutSpaces(name);
			DBBodyTypesBean bean = DbAccess.bodyTypesAccess.getByUniq(uniq);
			if (bean == null) {
				bean = new DBBodyTypesBean();
				bean.setBodyTypeName(name);
				bean.setBodyTypeUniq(uniq);
				DbAccess.bodyTypesAccess.insert(bean);
			}
			return bean;
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public static DBStationsBean getOrInsertStation(BigInteger systemId, String station, String stationType, Float dist) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		String uniq = EDUtils.getStationUniq(station);
		DBStationsBean bean = getStation(station, systemId);
		if (bean == null) {
			bean = new DBStationsBean();
			bean.setSystemId(systemId)
				.setStationId(DbAccess.stationsAccess.getStationsMaxId().getMaxStationId() + 1)
				.setName(station)
				.setNameUniq(uniq)
				.setType(stationType)
				.setDistanceToStar(dist != null?dist.longValue():null)
				.setUpdatedAt(new Date().getTime())
				;
			DbAccess.stationsAccess.insert(bean);
		}
		return bean;
	}
	/**
	 * Faction states
	 */
	private static Map<String, DBBgsStatesBean> states = new HashMap<>();
	
	public static DBBgsStatesBean getOrInsertState(String stateName) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		
		String uniq = EDUtils.getPowerUniq(stateName);
		
		DBBgsStatesBean result;
		
		if (!states.containsKey(uniq)) {
			result = DbAccess.bgsStatesAccess.getByUniq(uniq);
			if (result == null) {
				result = new DBBgsStatesBean().setStateName(stateName).setStateUniq(uniq);
				DbAccess.bgsStatesAccess.insert(result);
			}
			states.put(uniq, result);
		} else {
			result = states.get(uniq);
		}
		
		return result;
	}
	
	public static void updateSystemFactionStates(Date timestamp, String systemName, Float[] coord, FactionBean[] factions) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBSystemsBean system = getOrInsertSystem(systemName, coord);
		List<DBLastSystemFactionStateBean> history = DbAccess.systemFactionsHistoryAccess.getLastSystemFactionState(system.getSystemId(), new Timestamp(timestamp.getTime()));
		Map<String, DBLastSystemFactionStateBean> fmap;
		if (history == null) {
			fmap = new HashMap<>();
		} else {
			fmap = history.parallelStream().collect(Collectors.toMap(x -> x.getUniq(), x -> x));
		}
		Map <String, FactionBean> newStates = Arrays.asList(factions).parallelStream().collect(Collectors.toMap(x -> EDUtils.getFactionUniq(x.getName()), x -> x));
		
		for (String uniq: newStates.keySet()) {
			FactionBean newf = newStates.get(uniq);
			DBBgsStatesBean state = getOrInsertState(newf.getFactionState());
			if (fmap.containsKey(uniq)) {
				DBLastSystemFactionStateBean last = fmap.get(uniq);
				if (!last.getStateId().equals(state.getStateId()) || Math.abs(last.getInfluence() - newf.getInfluence()) > 0.005f) {
					DBSystemFactionsHistoryBean bean = new DBSystemFactionsHistoryBean();
					bean.setSystemId(system.getSystemId()).setFactionId(last.getFactionId()).setCreateDate(new Timestamp(timestamp.getTime())).setStateId(state.getStateId()).setInfluence(newf.getInfluence());
					DbAccess.systemFactionsHistoryAccess.insert(bean);
				}
				fmap.remove(uniq);
			} else {
				DBFactionsBean last = getOrInsertFaction(newf.getName(), newf.getGovernment(), newf.getAllegiance());
				DBSystemFactionsHistoryBean bean = new DBSystemFactionsHistoryBean();
				bean.setSystemId(system.getSystemId()).setFactionId(last.getFactionId()).setCreateDate(new Timestamp(timestamp.getTime())).setStateId(state.getStateId()).setInfluence(newf.getInfluence());
				DbAccess.systemFactionsHistoryAccess.insert(bean);
			}
		}
		// Remove leaving
		for (String uniq: fmap.keySet()) {
			DBLastSystemFactionStateBean last = fmap.get(uniq);
			if (last.getStateId() != null) {
				DBSystemFactionsHistoryBean bean = new DBSystemFactionsHistoryBean();
				bean.setSystemId(system.getSystemId()).setFactionId(last.getFactionId()).setCreateDate(new Timestamp(timestamp.getTime())).setStateId(null).setInfluence(null);
				DbAccess.systemFactionsHistoryAccess.insert(bean);
			}
		}
	}
	
	public static void updateSystemFactionControl(Date timestamp, String systemName, Float[] coord, String factionName, String government, String allegiance) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBSystemsBean system = getOrInsertSystem(systemName, coord);
		DBFactionsBean faction = getOrInsertFaction(factionName, government, allegiance);
		DBSystemFactionControlBean control = DbAccess.systemFactionControlAccess.getLastSystemControl(system.getSystemId());
		if (control == null || !control.getFactionId().equals(faction.getFactionId())) {
			DBSystemFactionControlBean bean = new DBSystemFactionControlBean();
			bean.setCreateTime(new Timestamp(timestamp.getTime())).setFactionId(faction.getFactionId()).setSystemId(system.getSystemId());
			DbAccess.systemFactionControlAccess.insert(bean);
		}
	}
	
	public static void updateStationFactionControl(Date timestamp, String systemName, String stationName, String stationType, Float dist, String factionName, String government, String allegiance) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBSystemsBean system = getOrInsertSystem(systemName, null);
		DBStationsBean station = getOrInsertStation(system.getSystemId(), stationName, stationType, dist);
		DBFactionsBean faction = getOrInsertFaction(factionName, government, allegiance);
		DBStationFactionControlBean control = DbAccess.stationFactionControlAccess.getLaststationControl(station.getStationId());
		if (control == null || !control.getFactionId().equals(faction.getFactionId())) {
			DBStationFactionControlBean bean = new DBStationFactionControlBean();
			bean.setCreateTime(new Timestamp(timestamp.getTime())).setFactionId(faction.getFactionId()).setStationId(station.getStationId());
			DbAccess.stationFactionControlAccess.insert(bean);
		}
	}
	
}
