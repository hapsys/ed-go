package org.c3s.edgo.common.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBLocationHistoryBean;
import org.c3s.edgo.common.beans.DBStationsBean;
import org.c3s.edgo.common.beans.DBSystemsBean;
import org.c3s.utils.RegexpUtils;

public class LocationDAO {

	
	public void insertLocation(long pilot_id, Date timestamp, String system, Float[] coord, String station) {
		try {
			String sysuniq = RegexpUtils.preg_replace("~[^0-9a-z]~isu", system.toLowerCase(), "");
			String stauniq = null;
			
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
				//getEntityManager().persist(starSystem);
				DbAccess.systemsAccess.insert(starSystem);
			}
	
			DBStationsBean stat = null;
			if (station != null) {
				stauniq = RegexpUtils.preg_replace("~[\\s]~isu", station.toLowerCase(), "");
				//stat = getEntityManager().createNamedQuery("Station.findByUniq", Station.class).setParameter("uniq", stauniq).getResultList().stream().findFirst().orElse(null);
				stat = DbAccess.stationsAccess.getByUniq(stauniq);
			}
			
			
			DBLocationHistoryBean prev = DbAccess.locationHistoryAccess.getLastLocation(pilot_id);//getLastLocation(pilot_id);
			if (prev != null) {
				System.out.println("Prev Station: " + (prev.getStationId() == null?"null":prev.getStationId()));
				System.out.println("Prev System: " + prev.getSystemId());
			}
			System.out.println("Station: " + (stat == null?"null":stat.getStationId()));
			System.out.println("System: " + starSystem.getSystemId());
			
			if (prev == null || !prev.getSystemId().equals(starSystem.getSystemId()) || prev.getStationId() != null && stat == null || prev.getStationId() == null && stat != null || prev.getStationId() != null && stat != null && !prev.getStationId().equals(stat.getStationId())) {
				DBLocationHistoryBean history = new DBLocationHistoryBean(); 
				history.setPilotId(pilot_id);
				history.setLocationTime(new Timestamp(timestamp.getTime()));
				if (stat != null) {
					history.setStationId(stat.getStationId());
				}
				history.setSystemId(starSystem.getSystemId());
				DbAccess.locationHistoryAccess.insert(history);
				//getEntityManager().persist(history);
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}


