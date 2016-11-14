package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ProgressBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Progress extends AbstractJournalEvent<ProgressBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ProgressBean.class;
	}
	
	protected void processBean(ProgressBean bean) {
	}

}
	