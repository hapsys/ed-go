package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.DockSRVBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DockSRV extends AbstractJournalEvent<DockSRVBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = DockSRVBean.class;
	}
	
	protected void processBean(DockSRVBean bean) {
	}

}
	