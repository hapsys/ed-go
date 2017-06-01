package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.LocationDAO;
import org.c3s.edgo.common.dao.PowersDAO;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.common.dao.SystemsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.FSDJumpBean;
import org.c3s.utils.RegexpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FSDJump extends AbstractJournalEvent<FSDJumpBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = FSDJumpBean.class;
	}
	
	protected void processBean(FSDJumpBean bean) {
		
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				LocationDAO.insertLocation(pilot.getPilotId(), bean.getTimestamp(), bean.getStarSystem(), bean.getStarPos(), null, null, null, null, null);
				PowersDAO.updateOrInsertPowerState(bean.getStarSystem(), bean.getPowers(), bean.getPowerplayState(), bean.getTimestamp());
				ShipsDAO.updateCurrentShipPosition(pilot);
				if (bean.getFactions() != null) {
					SystemsDAO.updateSystemFactionStates(bean.getTimestamp(), bean.getStarSystem(), bean.getStarPos(), bean.getFactions());
				}
				if (bean.getSystemFaction() != null) {
					String gov = bean.getSystemGovernment();
					if (gov != null && gov.startsWith("$government_")) {
						gov = RegexpUtils.preg_replace("~^.*_(.+);?$~is", gov, "$1");
					}
					SystemsDAO.updateSystemFactionControl(bean.getTimestamp(), bean.getStarSystem(), bean.getStarPos(), bean.getSystemFaction(), gov, bean.getSystemAllegiance());
				}
				
				// Update last info supercruise
				DbAccess.pilotLastInfoAccess.updateSupercruiseFlag(1, pilot.getPilotId());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
	