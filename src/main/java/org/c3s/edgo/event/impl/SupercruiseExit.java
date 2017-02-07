package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.LocationDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.SupercruiseExitBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SupercruiseExit extends AbstractJournalEvent<SupercruiseExitBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(SupercruiseExit.class);
	
	{
		beanClass = SupercruiseExitBean.class;
	}
	
	protected void processBean(SupercruiseExitBean bean) {
		DBPilotsBean current = getCurrent();
		if (current != null) {
			LocationDAO.insertLocation(current.getPilotId(), bean.getTimestamp(), bean.getStarsystem(), null, null, bean.getBody(), bean.getBodyType());
		}
	}

}
	