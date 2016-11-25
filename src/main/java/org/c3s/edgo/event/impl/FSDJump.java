package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.LocationDAO;
import org.c3s.edgo.common.dao.PowersDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.FSDJumpBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FSDJump extends AbstractJournalEvent<FSDJumpBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = FSDJumpBean.class;
	}
	
	protected void processBean(FSDJumpBean bean) {
		
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				LocationDAO.insertLocation(pilot.getPilotId(), bean.getTimestamp(), bean.getStarSystem(), bean.getStarPos(), null);
				PowersDAO.updateOrInsertPowerState(bean.getStarSystem(), bean.getPowers(), bean.getPowerplayState(), bean.getTimestamp());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
	