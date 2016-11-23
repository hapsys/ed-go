package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBRanksBean;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.RankBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rank extends AbstractJournalEvent<RankBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = RankBean.class;
	}
	
	protected void processBean(RankBean bean) {
		
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				DBRanksBean rank = DbAccess.ranksAccess.getByPrimaryKey(pilot.getPilotId());
				if (rank == null) {
					rank = new DBRanksBean();
					rank.setPilotId(pilot.getPilotId());
					DbAccess.ranksAccess.insert(rank);
				}
				rank.setCombat(bean.getCombat());
				rank.setTrade(bean.getTrade());
				rank.setExplore(bean.getExplore());
				rank.setEmpire(bean.getEmpire());
				rank.setFederation(bean.getFederation());
				rank.setCqc(bean.getCQC());
				DbAccess.ranksAccess.updateByPrimaryKey(rank, pilot.getPilotId());
			}
		} catch (IllegalArgumentException | IllegalAccessException | SQLException | InstantiationException e) {
			throw new RuntimeException(e);
		}
	}

}
	