package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.BuyDronesBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuyDrones extends AbstractJournalEvent<BuyDronesBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = BuyDronesBean.class;
	}
	
	protected void processBean(BuyDronesBean bean) {
	}

}
	