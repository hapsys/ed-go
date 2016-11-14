package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PowerplayLeaveBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PowerplayLeave extends AbstractJournalEvent<PowerplayLeaveBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = PowerplayLeaveBean.class;
	}
	
	protected void processBean(PowerplayLeaveBean bean) {
	}

}
	