package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.PowersDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PowerplayLeaveBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PowerplayLeave extends AbstractJournalEvent<PowerplayLeaveBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(PowerplayLeave.class);
	
	{
		beanClass = PowerplayLeaveBean.class;
	}
	
	protected void processBean(PowerplayLeaveBean bean) {
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				PowersDAO.getOrInsertPilotPower(pilot, null, bean.getTimestamp());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
	