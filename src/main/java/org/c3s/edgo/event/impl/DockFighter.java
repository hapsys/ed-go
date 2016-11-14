package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.DockFighterBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DockFighter extends AbstractJournalEvent<DockFighterBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = DockFighterBean.class;
	}
	
	protected void processBean(DockFighterBean bean) {
	}

}
	