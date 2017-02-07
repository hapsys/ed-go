package org.c3s.edgo.common.dao;

import java.math.BigInteger;
import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBBodiesBean;
import org.c3s.edgo.common.beans.DBBodyTypesBean;
import org.c3s.edgo.common.beans.DBFactionsBean;
import org.c3s.edgo.common.beans.DBStationsBean;
import org.c3s.edgo.common.beans.DBSystemsBean;
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
		try {
			String uniq = EDUtils.getFactionUniq(faction);
			DBFactionsBean bean = DbAccess.factionsAccess.getByUniq(uniq);
			if (bean == null) {
				bean = new DBFactionsBean();
				bean.setName(faction);
				bean.setUniq(uniq);
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
	
}
