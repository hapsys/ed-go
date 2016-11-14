package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.BuyExplorationDataBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuyExplorationData extends AbstractJournalEvent<BuyExplorationDataBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = BuyExplorationDataBean.class;
	}
	
	protected void processBean(BuyExplorationDataBean bean) {
	}

}
	