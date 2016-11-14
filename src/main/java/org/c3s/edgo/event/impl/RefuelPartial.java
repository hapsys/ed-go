package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.RefuelPartialBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RefuelPartial extends AbstractJournalEvent<RefuelPartialBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = RefuelPartialBean.class;
	}
	
	protected void processBean(RefuelPartialBean bean) {
	}

}
	