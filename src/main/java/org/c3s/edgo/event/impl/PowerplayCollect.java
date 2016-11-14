package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PowerplayCollectBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PowerplayCollect extends AbstractJournalEvent<PowerplayCollectBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = PowerplayCollectBean.class;
	}
	
	protected void processBean(PowerplayCollectBean bean) {
	}

}
	