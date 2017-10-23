package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;
import java.sql.Timestamp;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBMissionsBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBStationHistoryBean;
import org.c3s.edgo.common.beans.DBStationsBean;
import org.c3s.edgo.common.beans.DBSystemsBean;
import org.c3s.edgo.common.dao.MissionsDAO;
import org.c3s.edgo.common.dao.SystemsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.MissionAcceptedBean;
import org.c3s.edgo.utils.EDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MissionAccepted extends AbstractJournalEvent<MissionAcceptedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = MissionAcceptedBean.class;
	}
	
	protected void processBean(MissionAcceptedBean bean) {

		try {
			
			DBPilotsBean pilot = getCurrent();
			
			if (pilot != null) {
				DBStationHistoryBean prevStation = DbAccess.stationHistoryAccess.getLastStation(pilot.getPilotId(), new Timestamp(bean.getTimestamp().getTime()));

				if (prevStation != null) {
					DBMissionsBean mission = new DBMissionsBean();
					mission.setPilotId(pilot.getPilotId());
					mission.setStationHistoryId(prevStation.getStationHistoryId());
					mission.setMissionLinkId(Long.valueOf(bean.getMissionID()));
					mission.setAcceptDate(new Timestamp(bean.getTimestamp().getTime()));
					mission.setMissionTypeId(MissionsDAO.getOrInsertMissionType(bean.getName()).getMissionTypeId());
					mission.setIsFailed(0);
					mission.setInfluence(bean.getInfluence());
					mission.setReputation(bean.getReputation());
					mission.setPassengers(bean.getPassengerCount());
					mission.setDescription(bean.getLocalisedName());
					if (bean.getDestinationSystem() != null) {
						DBSystemsBean system = DbAccess.systemsAccess.getByUniq(EDUtils.getSystemUniq(bean.getDestinationSystem()));
						if (system != null) {
							mission.setTargetSystemId(system.getSystemId());
						}
					}
					if (bean.getDestinationStation() != null) {
						DBStationsBean station = DbAccess.stationsAccess.getByUniq(EDUtils.getSystemUniq(bean.getDestinationStation()));
						if (station != null) {
							mission.setTargetStationId(station.getStationId());
						}
					}
					if (bean.getFaction() != null) {
						mission.setFactionId(SystemsDAO.getOrInsertFaction(bean.getFaction()).getFactionId());
					}
					if (bean.getTargetFaction() != null) {
						mission.setTargetFactionId(SystemsDAO.getOrInsertFaction(bean.getTargetFaction()).getFactionId());
					}
					if (bean.getExpiry() != null) {
						mission.setExpireDate(new Timestamp(bean.getExpiry().getTime()));
					}
					DbAccess.missionsAccess.insert(mission);
				}
			}
			
			//
			
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		} 
		
		
	}

}
	