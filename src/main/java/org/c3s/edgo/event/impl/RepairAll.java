package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.RepairAllBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RepairAll extends AbstractJournalEvent<RepairAllBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = RepairAllBean.class;
	}
	
	protected void processBean(RepairAllBean bean) {
	}

}
	