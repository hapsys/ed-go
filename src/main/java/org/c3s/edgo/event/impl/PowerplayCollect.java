package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.PowersDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PowerplayCollectBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PowerplayCollect extends AbstractJournalEvent<PowerplayCollectBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = PowerplayCollectBean.class;
	}
	
	protected void processBean(PowerplayCollectBean bean) {
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
	