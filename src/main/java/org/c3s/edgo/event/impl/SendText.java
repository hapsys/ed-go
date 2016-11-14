package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.SendTextBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendText extends AbstractJournalEvent<SendTextBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = SendTextBean.class;
	}
	
	protected void processBean(SendTextBean bean) {
	}

}
	