package org.c3s.edgo.common.dao;

import java.math.BigInteger;
import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;
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
}
