package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.RepairBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Repair extends AbstractJournalEvent<RepairBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = RepairBean.class;
	}
	
	protected void processBean(RepairBean bean) {
	}

}
	