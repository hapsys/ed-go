package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotPowerBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.PowersDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PowerplayFastTrackBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PowerplayFastTrack extends AbstractJournalEvent<PowerplayFastTrackBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(PowerplayFastTrack.class);
	
	{
		beanClass = PowerplayFastTrackBean.class;
	}
	
	protected void processBean(PowerplayFastTrackBean bean) {
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				DBPilotPowerBean pilotPower = PowersDAO.getOrInsertPilotPower(pilot, bean.getPower(), bean.getTimestamp());
				PowersDAO.updateFastTrack(pilot, bean.getTimestamp(), bean.getCost(), pilotPower.getPilotPowerId());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
	