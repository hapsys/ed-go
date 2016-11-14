package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.DockingDeniedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DockingDenied extends AbstractJournalEvent<DockingDeniedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = DockingDeniedBean.class;
	}
	
	protected void processBean(DockingDeniedBean bean) {
	}

}
	