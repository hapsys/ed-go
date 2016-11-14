package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.HeatDamageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeatDamage extends AbstractJournalEvent<HeatDamageBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = HeatDamageBean.class;
	}
	
	protected void processBean(HeatDamageBean bean) {
	}

}
	