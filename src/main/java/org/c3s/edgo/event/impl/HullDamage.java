package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.HullDamageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HullDamage extends AbstractJournalEvent<HullDamageBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = HullDamageBean.class;
	}
	
	protected void processBean(HullDamageBean bean) {
	}

}
	