package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.DockingTimeoutBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DockingTimeout extends AbstractJournalEvent<DockingTimeoutBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = DockingTimeoutBean.class;
	}
	
	protected void processBean(DockingTimeoutBean bean) {
	}

}
	