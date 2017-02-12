package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBMaterialsBean;
import org.c3s.edgo.common.beans.DBMissionsBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.MissionsDAO;
import org.c3s.edgo.common.dao.PilotDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.MaterialDiscoveredBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaterialDiscovered extends AbstractJournalEvent<MaterialDiscoveredBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = MaterialDiscoveredBean.class;
	}
	
	protected void processBean(MaterialDiscoveredBean bean) {
		try {
			DBMaterialsBean mat = MissionsDAO.getMaterial(bean.getName(), bean.getCategory());
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				DBMissionsBean mission = DbAccess.missionsAccess.getgetLastComplitedByPilotId(pilot.getPilotId());
				if (mission != null && (bean.getTimestamp().getTime() - mission.getCompleteDate().getTime()) <= 2000) {
					MissionsDAO.insertUpdateMissionMaterial(mission.getMissionId(), mat.getMaterialId(), 1);
				}
				PilotDAO.insertUpdateMaterial(pilot.getPilotId(), mat.getMaterialId(), 1);
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
	