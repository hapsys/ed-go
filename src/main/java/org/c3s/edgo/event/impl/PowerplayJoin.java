package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.PowersDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PowerplayJoinBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PowerplayJoin extends AbstractJournalEvent<PowerplayJoinBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(PowerplayJoin.class);
	
	{
		beanClass = PowerplayJoinBean.class;
	}
	
	protected void processBean(PowerplayJoinBean bean) {
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				PowersDAO.getOrInsertPilotPower(pilot, bean.getPower(), bean.getTimestamp());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
	