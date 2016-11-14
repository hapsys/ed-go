package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PowerplayDeliverBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PowerplayDeliver extends AbstractJournalEvent<PowerplayDeliverBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = PowerplayDeliverBean.class;
	}
	
	protected void processBean(PowerplayDeliverBean bean) {
	}

}
	