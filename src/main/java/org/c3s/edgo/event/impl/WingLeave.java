package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.WingLeaveBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WingLeave extends AbstractJournalEvent<WingLeaveBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = WingLeaveBean.class;
	}
	
	protected void processBean(WingLeaveBean bean) {
	}

}
	