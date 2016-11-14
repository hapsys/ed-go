package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.CockpitBreachedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CockpitBreached extends AbstractJournalEvent<CockpitBreachedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = CockpitBreachedBean.class;
	}
	
	protected void processBean(CockpitBreachedBean bean) {
	}

}
	