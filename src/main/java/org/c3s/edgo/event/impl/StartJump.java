package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.StartJumpBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartJump extends AbstractJournalEvent<StartJumpBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(StartJump.class);
	
	{
		beanClass = StartJumpBean.class;
	}
	
	protected void processBean(StartJumpBean bean) {
	}

}
	