package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;
import java.sql.Timestamp;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBPilotPowerBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.PowersDAO;
import org.c3s.edgo.common.dao.SystemsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.BountyBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bounty extends AbstractJournalEvent<BountyBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Bounty.class);
	
	{
		beanClass = BountyBean.class;
	}
	
	protected void processBean(BountyBean bean) {
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				if (bean.getTotalReward() == 0) {
					// may be power
					if (SystemsDAO.getFaction(bean.getVictimFaction()) == null) {
						Long pilotPowerId = null;
						DBPilotPowerBean pilotPower = DbAccess.pilotPowerAccess.getLastByPilotIdTime(pilot.getPilotId(), new Timestamp(bean.getTimestamp().getTime()));
						if (pilotPower != null) { 
							pilotPowerId = pilotPower.getPowerId();
						}
						PowersDAO.updateCombatMerits(pilot, bean.getTimestamp(), pilotPowerId);
					}
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
	