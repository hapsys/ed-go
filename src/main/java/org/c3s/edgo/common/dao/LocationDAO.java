package org.c3s.edgo.common.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBLocationHistoryBean;
import org.c3s.edgo.common.beans.DBLocationSystemHistoryBean;
import org.c3s.edgo.common.beans.DBStationsBean;
import org.c3s.edgo.common.beans.DBSystemsBean;
import org.c3s.edgo.utils.EDUtils;

public class LocationDAO {

	
	public static void insertLocation(long pilot_id, Date timestamp, String system, Float[] coord, String station) {
		try {
			String stauniq = null;
			
			DBSystemsBean starSystem = SystemsDAO.getOrInsertSystem(system, coord);
	
			DBStationsBean stat = null;
			if (station != null) {
				stauniq = EDUtils.getStationUniq(station);
				stat = DbAccess.stationsAccess.getByUniq(stauniq);
			}
			
			
			DBLocationHistoryBean prev = DbAccess.locationHistoryAccess.getLastLocation(pilot_id);
			/*
			if (prev != null) {
				System.out.println("Prev Station: " + (prev.getStationId() == null?"null":prev.getStationId()));
				System.out.println("Prev System: " + prev.getSystemId());
			}
			System.out.println("Station: " + (stat == null?"null":stat.getStationId()));
			System.out.println("System: " + starSystem.getSystemId());
			*/
			
			if (prev == null || !prev.getSystemId().equals(starSystem.getSystemId()) || prev.getStationId() != null && stat == null || prev.getStationId() == null && stat != null || prev.getStationId() != null && stat != null && !prev.getStationId().equals(stat.getStationId())) {
				DBLocationHistoryBean history = new DBLocationHistoryBean(); 
				history.setPilotId(pilot_id);
				history.setLocationTime(new Timestamp(timestamp.getTime()));
				if (stat != null) {
					history.setStationId(stat.getStationId());
				}
				history.setSystemId(starSystem.getSystemId());
				DbAccess.locationHistoryAccess.insert(history);
				
				/**
				 * insert system history location 
				 */
				DBLocationSystemHistoryBean prevSys = DbAccess.locationSystemHistoryAccess.getLastSystemLocation(pilot_id);
				if (prevSys == null || !prevSys.getSystemId().equals(starSystem.getSystemId())) {
					DBLocationSystemHistoryBean hisLoc = new DBLocationSystemHistoryBean();
					hisLoc.setPilotId(pilot_id);
					hisLoc.setLocationTime(new Timestamp(timestamp.getTime()));
					hisLoc.setSystemId(starSystem.getSystemId());
					DbAccess.locationSystemHistoryAccess.insert(hisLoc);
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}


