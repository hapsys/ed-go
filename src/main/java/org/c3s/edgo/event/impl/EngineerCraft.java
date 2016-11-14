package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.EngineerCraftBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EngineerCraft extends AbstractJournalEvent<EngineerCraftBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = EngineerCraftBean.class;
	}
	
	protected void processBean(EngineerCraftBean bean) {
	}

}
	