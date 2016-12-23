package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.LocationDAO;
import org.c3s.edgo.common.dao.PowersDAO;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.LocationBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Location extends AbstractJournalEvent<LocationBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = LocationBean.class;
	}
	
	protected void processBean(LocationBean bean) {
		
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				LocationDAO.insertLocation(pilot.getPilotId(), bean.getTimestamp(), bean.getStarSystem(), bean.getStarPos(), bean.getStationName());
				PowersDAO.updateOrInsertPowerState(bean.getStarSystem(), bean.getPowers(), bean.getPowerplayState(), bean.getTimestamp());
				ShipsDAO.updateCurrentShipPosition(pilot);
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
	