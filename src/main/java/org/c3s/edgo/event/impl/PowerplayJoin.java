package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PowerplayJoinBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PowerplayJoin extends AbstractJournalEvent<PowerplayJoinBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = PowerplayJoinBean.class;
	}
	
	protected void processBean(PowerplayJoinBean bean) {
	}

}
	