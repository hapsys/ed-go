package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.SellExplorationDataBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SellExplorationData extends AbstractJournalEvent<SellExplorationDataBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = SellExplorationDataBean.class;
	}
	
	protected void processBean(SellExplorationDataBean bean) {
	}

}
	