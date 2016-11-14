package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ReceiveTextBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReceiveText extends AbstractJournalEvent<ReceiveTextBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ReceiveTextBean.class;
	}
	
	protected void processBean(ReceiveTextBean bean) {
	}

}
	