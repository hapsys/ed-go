package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;
import java.sql.Timestamp;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBMissionsBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.MissionsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.MissionCompletedBean;
import org.c3s.edgo.event.impl.beans.MissionCompletedBean.Commodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MissionCompleted extends AbstractJournalEvent<MissionCompletedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = MissionCompletedBean.class;
	}
	
	protected void processBean(MissionCompletedBean bean) {
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				DBMissionsBean mission = DbAccess.missionsAccess.getByPilotIdAndLinkId(pilot.getPilotId(), Long.valueOf(bean.getMissionID()));
				if (mission != null) {
					mission.setReward(bean.getReward());
					mission.setCompleteDate(new Timestamp(bean.getTimestamp().getTime()));
					DbAccess.missionsAccess.updateByPrimaryKey(mission, mission.getMissionId());
					
					if (bean.getCommodityReward() != null) {
						for (Commodity com: bean.getCommodityReward()) {
							MissionsDAO.insertUpdateMissionComodity(mission.getMissionId(), MissionsDAO.getComodity(com.getName()).getCommodityId(), com.getCount());
						}
					}
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
	