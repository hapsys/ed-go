package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.DockingCancelledBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DockingCancelled extends AbstractJournalEvent<DockingCancelledBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = DockingCancelledBean.class;
	}
	
	protected void processBean(DockingCancelledBean bean) {
	}

}
	