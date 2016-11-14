package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ApproachSettlementBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApproachSettlement extends AbstractJournalEvent<ApproachSettlementBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ApproachSettlementBean.class;
	}
	
	protected void processBean(ApproachSettlementBean bean) {
	}

}
	