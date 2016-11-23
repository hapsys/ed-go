package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.LocationDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.FSDJumpBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FSDJump extends AbstractJournalEvent<FSDJumpBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = FSDJumpBean.class;
	}
	
	protected void processBean(FSDJumpBean bean) {
		
		DBPilotsBean pilot = getCurrent();
		if (pilot != null) {
			new LocationDAO().insertLocation(pilot.getPilotId(), bean.getTimestamp(), bean.getStarSystem(), bean.getStarPos(), null);
		}
		
	}

}
	