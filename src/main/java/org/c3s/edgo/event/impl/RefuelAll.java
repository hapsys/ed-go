package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.RefuelAllBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RefuelAll extends AbstractJournalEvent<RefuelAllBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = RefuelAllBean.class;
	}
	
	protected void processBean(RefuelAllBean bean) {
	}

}
	