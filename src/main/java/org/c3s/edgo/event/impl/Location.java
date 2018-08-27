package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.LocationDAO;
import org.c3s.edgo.common.dao.PowersDAO;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.common.dao.SystemsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.LocationBean;
import org.c3s.utils.RegexpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Location extends AbstractJournalEvent<LocationBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Location.class);
	
	{
		beanClass = LocationBean.class;
	}
	
	
	protected void processBean(LocationBean bean) {
		
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				LocationDAO.insertLocation(pilot.getPilotId(), bean.getTimestamp(), bean.getStarSystem(), bean.getStarPos(), bean.getSystemAddress(), bean.getStationName(), bean.getMarketID(), bean.getStationType(), null, bean.getBody(), bean.getBodyType());
				PowersDAO.updateOrInsertPowerState(bean.getStarSystem(), bean.getPowers(), bean.getPowerplayState(), bean.getTimestamp());
				ShipsDAO.updateCurrentShipPosition(pilot);
				if (bean.getFactions() != null) {
					SystemsDAO.updateSystemFactionStates(bean.getTimestamp(), bean.getStarSystem(), bean.getStarPos(), bean.getSystemAddress(), bean.getFactions());
				}
				if (bean.getSystemFaction() != null) {
					String gov = bean.getSystemGovernment();
					if (gov != null && gov.startsWith("$government_")) {
						gov = RegexpUtils.preg_replace("~^.*_(.+);?$~is", gov, "$1");
					}
					SystemsDAO.updateSystemFactionControl(bean.getTimestamp(), bean.getStarSystem(), bean.getStarPos(), bean.getSystemAddress(), bean.getSystemFaction(), gov, bean.getSystemAllegiance());
				}
			}
			
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
	