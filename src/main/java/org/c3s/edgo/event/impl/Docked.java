package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.common.dao.LocationDAO;
import org.c3s.edgo.common.entity.Pilot;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.DockedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Docked extends AbstractJournalEvent<DockedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = DockedBean.class;
	}
	
	protected void processBean(DockedBean bean) {
		
		Pilot pilot = getCurrent();
		if (pilot != null) {
			new LocationDAO(em).insertLocation(pilot.getPilotId(), bean.getTimestamp(), bean.getStarSystem(), null, bean.getStationName());
		}
		
	}

}
	