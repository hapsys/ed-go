package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ShieldStateBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShieldState extends AbstractJournalEvent<ShieldStateBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ShieldStateBean.class;
	}
	
	protected void processBean(ShieldStateBean bean) {
	}

}
	