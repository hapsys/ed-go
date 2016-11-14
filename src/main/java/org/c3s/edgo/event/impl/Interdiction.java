package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.InterdictionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Interdiction extends AbstractJournalEvent<InterdictionBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = InterdictionBean.class;
	}
	
	protected void processBean(InterdictionBean bean) {
	}

}
	