package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.PowersDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PowerplayDeliverBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PowerplayDeliver extends AbstractJournalEvent<PowerplayDeliverBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(PowerplayDeliver.class);
	
	{
		beanClass = PowerplayDeliverBean.class;
	}
	
	protected void processBean(PowerplayDeliverBean bean) {
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				PowersDAO.getOrInsertPilotPower(pilot, bean.getPower(), bean.getTimestamp());
				PowersDAO.updateDeliver(pilot, bean.getTimestamp(), bean.getCount());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
	