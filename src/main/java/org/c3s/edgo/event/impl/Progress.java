package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBProgressBean;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ProgressBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Progress extends AbstractJournalEvent<ProgressBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ProgressBean.class;
	}
	
	protected void processBean(ProgressBean bean) {
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				DBProgressBean progress = DbAccess.progressAccess.getByPrimaryKey(pilot.getPilotId());
				if (progress == null) {
					progress = new DBProgressBean();
					progress.setPilotId(pilot.getPilotId());
					DbAccess.progressAccess.insert(progress);
				}
				progress.setCombat(bean.getCombat());
				progress.setTrade(bean.getTrade());
				progress.setExplore(bean.getExplore());
				progress.setEmpire(bean.getEmpire());
				progress.setFederation(bean.getFederation());
				progress.setCqc(bean.getCQC());
				DbAccess.progressAccess.updateByPrimaryKey(progress, pilot.getPilotId());
			}
		} catch (IllegalArgumentException | IllegalAccessException | SQLException | InstantiationException e) {
			throw new RuntimeException(e);
		}
	}

}
	