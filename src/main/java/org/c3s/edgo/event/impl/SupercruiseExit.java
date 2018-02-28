package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.LocationDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.SupercruiseExitBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SupercruiseExit extends AbstractJournalEvent<SupercruiseExitBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(SupercruiseExit.class);
	
	{
		beanClass = SupercruiseExitBean.class;
	}
	
	protected void processBean(SupercruiseExitBean bean) {
		try {
			DBPilotsBean current = getCurrent();
			if (current != null) {
				LocationDAO.insertLocation(current.getPilotId(), bean.getTimestamp(), bean.getStarsystem(), null, null, null, null, null, bean.getBody(), bean.getBodyType());
				// Update last info supercruise
				DbAccess.pilotLastInfoAccess.updateSupercruiseFlag(0, current.getPilotId());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
	