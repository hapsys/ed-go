package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.UndockedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Undocked extends AbstractJournalEvent<UndockedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = UndockedBean.class;
	}
	
	protected void processBean(UndockedBean bean) {
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				// Insert cruise mode
				DbAccess.pilotLastInfoAccess.updateSupercruiseFlag(0L, pilot.getPilotId());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
	