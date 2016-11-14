package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.InterdictedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Interdicted extends AbstractJournalEvent<InterdictedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = InterdictedBean.class;
	}
	
	protected void processBean(InterdictedBean bean) {
	}

}
	