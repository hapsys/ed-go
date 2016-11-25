package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.PowersDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PowerplayVoteBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PowerplayVote extends AbstractJournalEvent<PowerplayVoteBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = PowerplayVoteBean.class;
	}
	
	protected void processBean(PowerplayVoteBean bean) {
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
	