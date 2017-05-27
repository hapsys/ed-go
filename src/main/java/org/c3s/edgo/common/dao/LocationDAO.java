package org.c3s.edgo.common.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBBodiesBean;
import org.c3s.edgo.common.beans.DBLocationHistoryBean;
import org.c3s.edgo.common.beans.DBPilotLastInfoBean;
import org.c3s.edgo.common.beans.DBStationHistoryBean;
import org.c3s.edgo.common.beans.DBStationsBean;
import org.c3s.edgo.common.beans.DBSystemsBean;
import org.c3s.edgo.utils.EDUtils;

public class LocationDAO {

	public static void insertLocation(long pilot_id, Date timestamp, String system, Float[] coord, String station, String body, String bodyType) {
		try {
			
			if ("".equals(station)) {
				station = null;
			}
			
			if ("".equals(body)) {
				body = null;
			}
			
			if ("Station".equals(bodyType)) {
				station = body;
			}
			
			DBLocationHistoryBean prevLocation = DbAccess.locationHistoryAccess.getLastLocation(pilot_id, new Timestamp(timestamp.getTime()));
			DBStationHistoryBean prevStation = DbAccess.stationHistoryAccess.getLastStation(pilot_id, new Timestamp(timestamp.getTime()));
			
			boolean isNewLocation = false;
			
			DBPilotLastInfoBean lastInfo = DbAccess.pilotLastInfoAccess.getByPrimaryKey(pilot_id);
			lastInfo.setSystemId(null).setStationId(null).setPilotId(null);
			
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
				
				lastInfo.setSystemId(starSystem.getSystemId());
			}
			
			
			if (station != null || body != null) {
				DBStationHistoryBean curStation = new DBStationHistoryBean();
				curStation.setStationTime(new Timestamp(timestamp.getTime()));
				curStation.setLocationId(prevLocation.getLocationId());
				curStation.setPilotId(pilot_id);

				if (station != null) {
					String stauniq = EDUtils.getStationUniq(station);
					DBStationsBean stat = DbAccess.stationsAccess.getByUniq(stauniq);
					if (prevStation == null || isNewLocation || !stat.getStationId().equals(prevStation.getStationId())) {
						curStation.setStationId(stat.getStationId());
						DbAccess.stationHistoryAccess.insert(curStation);
					}
					lastInfo.setStationId(stat.getStationId());
				} else if (body != null) {
					DBBodiesBean bod = SystemsDAO.getOrInsertBody(prevLocation.getSystemId(), body, bodyType);
					if (prevStation == null || isNewLocation || !bod.getBodyId().equals(prevStation.getBodyId())) {
						curStation.setBodyId(bod.getBodyId());
						DbAccess.stationHistoryAccess.insert(curStation);
					}
					lastInfo.setBodyId(bod.getBodyId());
				}
			}
			
			DbAccess.pilotLastInfoAccess.updateByPrimaryKey(lastInfo, pilot_id);
			
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}


