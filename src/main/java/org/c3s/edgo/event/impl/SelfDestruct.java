package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.SelfDestructBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelfDestruct extends AbstractJournalEvent<SelfDestructBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = SelfDestructBean.class;
	}
	
	protected void processBean(SelfDestructBean bean) {
	}

}
	