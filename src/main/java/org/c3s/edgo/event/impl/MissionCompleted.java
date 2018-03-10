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
import org.c3s.edgo.event.impl.beans.intl.MaterialNameCount;
import org.c3s.edgo.event.impl.beans.intl.NameCount;
import org.c3s.utils.RegexpUtils;
import org.hibernate.type.MaterializedNClobType;
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
					if (bean.getDonation() > 0) {
						mission.setReward(-bean.getDonation());
					} else {
						mission.setReward(bean.getReward());
					}
					mission.setCompleteDate(new Timestamp(bean.getTimestamp().getTime()));
					DbAccess.missionsAccess.updateByPrimaryKey(mission, mission.getMissionId());

					if (bean.getMaterialsReward() != null) {
						for (MaterialNameCount com: bean.getMaterialsReward()) {
							MissionsDAO.insertUpdateMissionMaterial(mission.getMissionId(), 
									MissionsDAO.getMaterial(com.getName(), RegexpUtils.preg_replace("~^.+_([^_]+)$~iu", com.getCategory(), "$1")).getMaterialId(), com.getCount());
						}
					}
					
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
	