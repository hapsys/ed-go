package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.SupercruiseExitBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SupercruiseExit extends AbstractJournalEvent<SupercruiseExitBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = SupercruiseExitBean.class;
	}
	
	protected void processBean(SupercruiseExitBean bean) {
	}

}
	