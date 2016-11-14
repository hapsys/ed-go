package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.LaunchSRVBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LaunchSRV extends AbstractJournalEvent<LaunchSRVBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = LaunchSRVBean.class;
	}
	
	protected void processBean(LaunchSRVBean bean) {
	}

}
	