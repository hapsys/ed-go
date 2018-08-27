package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.SupercruiseEntryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SupercruiseEntry extends AbstractJournalEvent<SupercruiseEntryBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = SupercruiseEntryBean.class;
	}
	
	protected void processBean(SupercruiseEntryBean bean) {
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				// Update last info supercruise
				DbAccess.pilotLastInfoAccess.updateSupercruiseFlag(1, pilot.getPilotId());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
	