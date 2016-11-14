package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ContinuedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Continued extends AbstractJournalEvent<ContinuedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ContinuedBean.class;
	}
	
	protected void processBean(ContinuedBean bean) {
	}

}
	