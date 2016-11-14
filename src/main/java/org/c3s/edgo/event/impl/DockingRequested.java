package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.DockingRequestedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DockingRequested extends AbstractJournalEvent<DockingRequestedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = DockingRequestedBean.class;
	}
	
	protected void processBean(DockingRequestedBean bean) {
	}

}
	