package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBMissionsBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.MissionAbandonedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MissionAbandoned extends AbstractJournalEvent<MissionAbandonedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = MissionAbandonedBean.class;
	}
	
	protected void processBean(MissionAbandonedBean bean) {
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				DBMissionsBean mission = DbAccess.missionsAccess.getByPilotIdAndLinkId(pilot.getPilotId(), Long.valueOf(bean.getMissionID()));
				if (mission != null) {
					mission.setIsFailed(1);
					DbAccess.missionsAccess.updateByPrimaryKey(mission, mission.getMissionId());
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
	