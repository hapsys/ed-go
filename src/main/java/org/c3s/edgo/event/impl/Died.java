package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.DiedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Died extends AbstractJournalEvent<DiedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = DiedBean.class;
	}
	
	protected void processBean(DiedBean bean) {
	}

}
	