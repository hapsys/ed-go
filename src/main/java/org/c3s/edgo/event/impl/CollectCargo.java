package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.CollectCargoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollectCargo extends AbstractJournalEvent<CollectCargoBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = CollectCargoBean.class;
	}
	
	protected void processBean(CollectCargoBean bean) {
	}

}
	