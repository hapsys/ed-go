package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.PowersDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PowerplayDefectBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PowerplayDefect extends AbstractJournalEvent<PowerplayDefectBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(PowerplayDefect.class);
	
	{
		beanClass = PowerplayDefectBean.class;
	}
	
	protected void processBean(PowerplayDefectBean bean) {
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				PowersDAO.getOrInsertPilotPower(pilot, bean.getToPower(), bean.getTimestamp());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
	