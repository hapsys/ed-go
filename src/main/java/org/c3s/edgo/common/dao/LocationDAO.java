package org.c3s.edgo.common.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBLocationHistoryBean;
import org.c3s.edgo.common.beans.DBStationHistoryBean;
import org.c3s.edgo.common.beans.DBStationsBean;
import org.c3s.edgo.common.beans.DBSystemsBean;
import org.c3s.edgo.utils.EDUtils;

public class LocationDAO {

	
	public static void insertLocation(long pilot_id, Date timestamp, String system, Float[] coord, String station, String body) {
		try {
			
			
			DBLocationHistoryBean prevLocation = DbAccess.locationHistoryAccess.getLastLocation(pilot_id);
			DBStationHistoryBean prevStation = DbAccess.stationHistoryAccess.getLastStation(pilot_id);
			
			boolean isNewLocation = false;
			
			if (system != null) {
				DBSystemsBean starSystem = SystemsDAO.getOrInsertSystem(system, coord);
				if (prevLocation == null || !starSystem.getSystemId().equals(prevLocation.getSystemId())) {
					DBLocationHistoryBean history = new DBLocationHistoryBean(); 
					history.setPilotId(pilot_id);
					history.setLocationTime(new Timestamp(timestamp.getTime()));
					history.setSystemId(starSystem.getSystemId());
					DbAccess.locationHistoryAccess.insert(history);
					prevLocation = history;
					isNewLocation = true;
				}
			}
			
			
			if (station != null) {
				String stauniq = EDUtils.getStationUniq(station);
				DBStationsBean stat = DbAccess.stationsAccess.getByUniq(stauniq);
				if (prevStation == null || isNewLocation || !stat.getStationId().equals(stat.getStationId())) {
					DBStationHistoryBean curStation = new DBStationHistoryBean();
					curStation.setStationTime(new Timestamp(timestamp.getTime()));
					curStation.setLocationId(prevLocation.getLocationId());
					curStation.setStationId(stat.getStationId());
					curStation.setPilotId(pilot_id);
					DbAccess.stationHistoryAccess.insert(curStation);
				}
			}
			
			/*
			if (prev != null) {
				System.out.println("Prev Station: " + (prev.getStationId() == null?"null":prev.getStationId()));
				System.out.println("Prev System: " + prev.getSystemId());
			}
			System.out.println("Station: " + (stat == null?"null":stat.getStationId()));
			System.out.println("System: " + starSystem.getSystemId());
			*/
			
			/*
			if (prev == null || !prev.getSystemId().equals(starSystem.getSystemId()) || prev.getStationId() != null && stat == null || prev.getStationId() == null && stat != null || prev.getStationId() != null && stat != null && !prev.getStationId().equals(stat.getStationId())) {
				DBLocationHistoryBean history = new DBLocationHistoryBean(); 
				history.setPilotId(pilot_id);
				history.setLocationTime(new Timestamp(timestamp.getTime()));
				if (stat != null) {
					history.setStationId(stat.getStationId());
				}
				history.setSystemId(starSystem.getSystemId());
				DbAccess.locationHistoryAccess.insert(history);
				
				// insert system history location 
				DBLocationSystemHistoryBean prevSys = DbAccess.locationSystemHistoryAccess.getLastSystemLocation(pilot_id);
				if (prevSys == null || !prevSys.getSystemId().equals(starSystem.getSystemId())) {
					DBLocationSystemHistoryBean hisLoc = new DBLocationSystemHistoryBean();
					hisLoc.setPilotId(pilot_id);
					hisLoc.setLocationTime(new Timestamp(timestamp.getTime()));
					hisLoc.setSystemId(starSystem.getSystemId());
					DbAccess.locationSystemHistoryAccess.insert(hisLoc);
				}
			}
			*/
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}


