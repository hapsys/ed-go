package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.RebootRepairBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RebootRepair extends AbstractJournalEvent<RebootRepairBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = RebootRepairBean.class;
	}
	
	protected void processBean(RebootRepairBean bean) {
	}

}
	