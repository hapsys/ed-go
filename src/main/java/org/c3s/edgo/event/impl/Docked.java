package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.LocationDAO;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.common.dao.SystemsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.DockedBean;
import org.c3s.utils.RegexpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Docked extends AbstractJournalEvent<DockedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = DockedBean.class;
	}
	
	protected void processBean(DockedBean bean) {
		
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				LocationDAO.insertLocation(pilot.getPilotId(), bean.getTimestamp(), bean.getStarSystem(), null, bean.getStationName(), bean.getStationType(), bean.getDistFromStarLS(), null, null);
				ShipsDAO.updateCurrentShipPosition(pilot);
				if (bean.getStationFaction() != null) {
					String gov = bean.getStationGovernment();
					if (gov != null && gov.startsWith("$government_")) {
						gov = RegexpUtils.preg_replace("~^.*_(.+);?$~is", gov, "$1");
					}
					SystemsDAO.updateStationFactionControl(bean.getTimestamp(), bean.getStarSystem(), bean.getStationName(), bean.getStationType(), bean.getDistFromStarLS(), 
							bean.getStationFaction(), gov, bean.getStationAllegiance());
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
	