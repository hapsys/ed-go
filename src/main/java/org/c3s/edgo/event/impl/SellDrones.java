package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.SellDronesBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SellDrones extends AbstractJournalEvent<SellDronesBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = SellDronesBean.class;
	}
	
	protected void processBean(SellDronesBean bean) {
	}

}
	